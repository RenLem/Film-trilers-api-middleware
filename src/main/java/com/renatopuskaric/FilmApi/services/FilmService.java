package com.renatopuskaric.FilmApi.services;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.renatopuskaric.FilmApi.constants.Constant;
import com.renatopuskaric.FilmApi.controllers.FilmController;
import com.renatopuskaric.FilmApi.models.FilmObject;
import com.renatopuskaric.FilmApi.models.FilmResponseObject;

@Service
public class FilmService {
	
	@Autowired
	FilmResponseObject filmResponseObject;
	@Autowired
	FilmObject filmObject;
	
	// From TMDB
	String original_title = null;
	String overview = null;
	
	// From YouTube search
	String videoIdOfYouTube = null;
	String titleOfYouTube = null;
	String descriptionOfYouTube = null;
	ArrayList<FilmObject> filmObjectsList = new ArrayList<FilmObject>();;
	
	// From YouTube video
	String embedHtmlOfYouTube = null;
	ArrayList<String> embedHtmlList = new ArrayList<String>();
	
	private static final Logger logger = LoggerFactory.getLogger(FilmController.class);
	
	private final RestTemplate restTemplate;

	public FilmService(RestTemplateBuilder restTemplateBuilder) {
	    this.restTemplate = restTemplateBuilder.build();
	  }
	
	

	public FilmResponseObject getFilmService(
			@Valid @RequestParam(value = "search", defaultValue = "Terminator") String q) throws InterruptedException, Exception {
	
		// Search for original title of the movie
		String originalTitle = getFilmTMDBService(q);
		
		// Search on YouTube for list of IDs that respond to original title
		ArrayList<FilmObject> filmObjectsList = getFilmYouTubeService(originalTitle);
		
		// Search for trailers by IDs on YouTube
		FilmResponseObject filmResponseObject = getTrailerYouTubeService(filmObjectsList);
		
		Gson gson = new Gson();
		String responce = gson.toJson(filmResponseObject);
		
		return filmResponseObject;
	}
	
	
	public String getFilmTMDBService(
			@Valid @RequestParam(value = "title"/* , defaultValue = "Terminator" */) String title) throws InterruptedException, Exception {

		if (!embedHtmlList.isEmpty())embedHtmlList.clear();
		
		logger.info("Looking up " + title);
		final String uri =  Constant.SEARCH_TMDB_URL + title;
		
		String json = restTemplate.getForObject(uri, String.class);
		
		/* Thread.sleep(10L); */
		
	    logger.info("Finish up " + title);

		JsonElement fileElement = com.google.gson.JsonParser.parseString(json);
		JsonObject fileObject = fileElement.getAsJsonObject();
		
		// Get Results
		JsonArray jsonArrayItems = fileObject.get("results").getAsJsonArray();
		JsonObject resultJsonObject = jsonArrayItems.get(0).getAsJsonObject();
		//Extract data from original_title
		original_title = resultJsonObject.get("original_title").getAsString();
		
		//Extract data from Snippet
		overview = resultJsonObject.get("overview").getAsString();
		System.out.println(original_title + " | overview: " + overview + "\r\n");
		
		// Setting to response object
		filmResponseObject.setOriginalTitle(original_title);
		filmResponseObject.setOverview(overview);

		return original_title;
		
	}
	

	public ArrayList<FilmObject> getFilmYouTubeService(@Valid @RequestParam(value = "original_title"/*, defaultValue = "Terminator"*/) String originalTitle) throws InterruptedException, Exception {
		
		//https://youtube.googleapis.com/youtube/v3/search?part=snippet&q=Terminator&key=[YOUR_API_KEY]
		logger.info("Looking up " + originalTitle);
		final String uri = Constant.SEARCH_YOUTUBE_URL + originalTitle;
	
		String json = restTemplate.getForObject(uri, String.class);
		
		/*
		 * if (json.equals(null)) { do { Thread.sleep(10L); } while (json.equals(null));
		 * 
		 * }
		 */
	    
		logger.info("Finish up " + originalTitle);
		
		JsonElement fileElement = com.google.gson.JsonParser.parseString(json);
		JsonObject fileObject = fileElement.getAsJsonObject();

		// Get Items
		JsonArray jsonArrayItems = fileObject.get("items").getAsJsonArray();
		
		// Get Items
		int loopCounter = 0;
		if (!filmObjectsList.isEmpty())filmObjectsList.clear();
		
		for (JsonElement itemElement : jsonArrayItems) {
			
			loopCounter++;
			boolean hasVideoId = false;
			
			JsonObject itemsJsonObject = itemElement.getAsJsonObject();
			
			JsonObject idJsonObject = itemsJsonObject.get("id").getAsJsonObject();
			hasVideoId = idJsonObject.entrySet().toString().contains("videoId");
			
			if (hasVideoId) {
				// Extract data Id
				videoIdOfYouTube = idJsonObject.get("videoId").getAsString();
			} else {
				logger.warn("No video ID! at object number: " + loopCounter);
				continue;
			}
			
			// Extract data Snippet
			JsonObject snippetJsonObject = itemsJsonObject.get("snippet").getAsJsonObject();
			titleOfYouTube = snippetJsonObject.get("title").getAsString();
			descriptionOfYouTube = snippetJsonObject.get("description").getAsString();
			
			filmObject = new FilmObject();
			filmObject.setVideoIdOfYouTube(videoIdOfYouTube);
			filmObject.setDescriptionOfYouTube(descriptionOfYouTube);
			filmObject.setTitleOfYouTube(titleOfYouTube);
			
			
			filmObjectsList.add(filmObject);
			
		}
		System.out.println(filmObjectsList);
		
		return filmObjectsList;

	}
	

	public FilmResponseObject getTrailerYouTubeService(
			@Valid @RequestParam(value = "videoId"/* , defaultValue = "k64P4l2Wmeg" */) ArrayList<FilmObject>  filmObjectsList)throws InterruptedException, Exception {

		// print map entries
		for (FilmObject entry : filmObjectsList) {
			
			videoIdOfYouTube = entry.getVideoIdOfYouTube();

				// https://youtube.googleapis.com/youtube/v3/search?part=snippet&q=Terminator&key=[YOUR_API_KEY]
				// https://youtube.googleapis.com/youtube/v3/videos?key=API_KEY&part=snippet,player&id=VIDEOID
				logger.info("Looking up " + videoIdOfYouTube);
				final String uri = 	Constant.VIDEO_YOUTUBE_URL + videoIdOfYouTube;

				String json = restTemplate.getForObject(uri, String.class);
				
				/* Thread.sleep(10L); */
				
				logger.info("Finish up " + videoIdOfYouTube);

				JsonElement fileElement = com.google.gson.JsonParser.parseString(json);
				JsonObject fileObject = fileElement.getAsJsonObject();

				// Get Items
				JsonArray jsonArrayItems = fileObject.get("items").getAsJsonArray();
				JsonObject itemJsonObject = jsonArrayItems.get(0).getAsJsonObject();
				// Extract data EmbedHtml
				JsonObject trilerJsonObject = itemJsonObject.get("player").getAsJsonObject();
				System.out.println(trilerJsonObject);
				embedHtmlOfYouTube = trilerJsonObject.get("embedHtml").getAsString();
				System.out.println(embedHtmlOfYouTube);
				
				embedHtmlList.add(embedHtmlOfYouTube);

			
		}

		filmResponseObject.setEmbedHtml(embedHtmlList);
		
		return filmResponseObject;

	}

}
