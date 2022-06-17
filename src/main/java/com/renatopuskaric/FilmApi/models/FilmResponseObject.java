package com.renatopuskaric.FilmApi.models;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class FilmResponseObject {
	
	@NotNull
	private String responceId;
	@NotNull
	private String originalTitle;
	@NotNull
	private String overview;
	@NotNull
	private ArrayList<String> embedHtml;
	
	public FilmResponseObject() {
		super();
	}
	

	public FilmResponseObject(String responceId, String originalTitle, String overview,
			@NotNull ArrayList<String> embedHtml) {
		super();
		this.responceId = responceId;
		this.originalTitle = originalTitle;
		this.overview = overview;
		this.embedHtml = embedHtml;
	}

	
	

	// Getter Methods


	public String getResponceId() {
		return responceId;
	}


	public String getOriginalTitle() {
		return originalTitle;
	}


	public String getOverview() {
		return overview;
	}


	public ArrayList<String> getEmbedHtml() {
		return embedHtml;
	}


	// Setter Methods
	
	public void setResponceId(String responceId) {
		this.responceId = responceId;
	}


	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}


	public void setEmbedHtml(ArrayList<String> embedHtmlList) {
		this.embedHtml = embedHtmlList;
	}
	
	
	
	

}
