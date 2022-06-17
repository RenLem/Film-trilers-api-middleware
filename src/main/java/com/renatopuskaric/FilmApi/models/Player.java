package com.renatopuskaric.FilmApi.models;

public class Player {
	private String embedHtml;
	
	public Player() {
		super();
	}

	public Player(String embedHtml) {
		super();
		this.embedHtml = embedHtml;
	}

	// Getter Methods

	public String getEmbedHtml() {
		return embedHtml;
	}

	// Setter Methods

	public void setEmbedHtml(String embedHtml) {
		this.embedHtml = embedHtml;
	}
}
