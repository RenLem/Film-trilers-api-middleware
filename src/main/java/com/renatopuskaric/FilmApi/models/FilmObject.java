package com.renatopuskaric.FilmApi.models;

import org.springframework.stereotype.Component;

@Component
public class FilmObject {
	
	private String videoIdOfYouTube;
	private String titleOfYouTube;
	private String descriptionOfYouTube;
	
	
	public FilmObject() {
		super();
	}
	
	public FilmObject(String videoIdOfYouTube, String titleOfYouTube, String descriptionOfYouTube) {
		super();
		this.videoIdOfYouTube = videoIdOfYouTube;
		this.titleOfYouTube = titleOfYouTube;
		this.descriptionOfYouTube = descriptionOfYouTube;
	}

	public String getVideoIdOfYouTube() {
		return videoIdOfYouTube;
	}

	public String getTitleOfYouTube() {
		return titleOfYouTube;
	}

	public String getDescriptionOfYouTube() {
		return descriptionOfYouTube;
	}

	public void setVideoIdOfYouTube(String videoIdOfYouTube) {
		this.videoIdOfYouTube = videoIdOfYouTube;
	}

	public void setTitleOfYouTube(String titleOfYouTube) {
		this.titleOfYouTube = titleOfYouTube;
	}

	public void setDescriptionOfYouTube(String descriptionOfYouTube) {
		this.descriptionOfYouTube = descriptionOfYouTube;
	}
	
	

	
}
