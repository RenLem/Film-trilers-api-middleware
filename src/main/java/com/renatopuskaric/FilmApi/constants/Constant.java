package com.renatopuskaric.FilmApi.constants;

public class Constant {
	
	
	// URLs of APIs
	public static final String YOUTUBE_URL = "https://www.googleapis.com/youtube/v3";
	public static final String YOUTUBE_API_KEY = "AIzaSyAPxv0DWhADIVtnjV90IwG7r3NWPQvmlIg";
	public static final String YOUTUBE_API_KEY2 = "AIzaSyCwqLkWJXngDDMFTcAGER3FfNURFWpNJgg";
	
	// URLs combine with parameters
	public static final String SEARCH_TMDB_URL = "https://api.themoviedb.org/3/search/movie?api_key=890ef3ae58aa54c0f0cf0eee959913d9&language=en-US&page=1&include_adult=false&query=";
	public static final String SEARCH_YOUTUBE_URL = "https://youtube.googleapis.com/youtube/v3/search?key=" + YOUTUBE_API_KEY2 + "&part=snippet&q=";
	public static final String VIDEO_YOUTUBE_URL = "https://youtube.googleapis.com/youtube/v3/videos?key=" + YOUTUBE_API_KEY2 + "&part=snippet,player&id=";

	
	// Parameters
	public static final String YOUTUBE_REQUEST_SEARCH = "search";
	public static final String YOUTUBE_REQUEST_VIDEO = "videos";
	public static final String YOUTUBE_PART = "part";
	public static final String YOUTUBE_FILTER_SNIPPET = "snippet";
	public static final String YOUTUBE_FILTER_PLAYER = "player";
	public static final String YOUTUBE_QUERY_q = "q";
	public static final String YOUTUBE_ID = "id";
	public static final String YOUTUBE_MAXRESULTS = "maxResults=";
	

	


}
