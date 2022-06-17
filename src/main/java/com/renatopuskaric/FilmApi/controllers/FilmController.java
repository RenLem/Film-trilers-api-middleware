package com.renatopuskaric.FilmApi.controllers;


import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.renatopuskaric.FilmApi.models.FilmObject;
import com.renatopuskaric.FilmApi.models.FilmResponseObject;
import com.renatopuskaric.FilmApi.services.FilmService;


@RestController
@EnableCaching
public class FilmController {
		
	@Autowired
	FilmResponseObject filmResponseObject;
	@Autowired
	FilmObject filmObject;
	@Autowired
	FilmService filmService;
	

	@GetMapping("/get")
	public FilmResponseObject getFilm(
			@Valid @RequestParam(value = "search", defaultValue = "Terminator") String q) throws InterruptedException, Exception {
	
		FilmResponseObject responce = filmService.getFilmService(q);
		
		return responce;
	}
	
//	@GetMapping("/film")
//	public String getFilmTMDB(
//			@Valid @RequestParam(value = "title"/* , defaultValue = "Terminator" */) String title) throws InterruptedException, Exception {
//		
//		// Upit za TMDB za orginalni naziv filma
//		String orginalTitle = filmService.getFilmTMDBService(title);
//				
//		return orginalTitle;
//	}
//	
//	@GetMapping("/filmyt")
//	public ArrayList<FilmObject> getFilmYouTube(@Valid @RequestParam(value = "original_title"/*, defaultValue = "Terminator"*/) String originalTitle) throws InterruptedException, Exception {
//		
//		// Upit u XouTube za listu filmova pod tim orginalnim nazivom
//		ArrayList<FilmObject> videoIdYouTube = filmService.getFilmYouTubeService(originalTitle);
//				
//		return videoIdYouTube;
//	}
//	
//	@GetMapping("/triler")
//	public FilmResponseObject getTrilerYouTube(
//			@Valid @RequestParam(value = "videoId"/* , defaultValue = "k64P4l2Wmeg" */) ArrayList<FilmObject>  filmObjectsList)throws InterruptedException, Exception {
//		
//		// Upit za konkretni triler filma na Youtubeu
//		FilmResponseObject filmResponseObject = filmService.getTrailerYouTubeService(filmObjectsList);
//				
//		return filmResponseObject;
//	}

}
