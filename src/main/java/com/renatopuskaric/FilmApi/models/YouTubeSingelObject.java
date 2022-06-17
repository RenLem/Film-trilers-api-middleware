package com.renatopuskaric.FilmApi.models;

import java.util.ArrayList;

public class YouTubeSingelObject {
	
	private String kind;
	private String etag;
	private String nextPageToken;
	private String regionCode;

	ArrayList<Object> items = new ArrayList<Object>();

	// Getter Methods

	public ArrayList<Object> getItems() {
		return items;
	}

	public String getKind() {
		return kind;
	}

	public String getEtag() {
		return etag;
	}

	public String getNextPageToken() {
		return nextPageToken;
	}

	public String getRegionCode() {
		return regionCode;
	}

	// Setter Methods

	public void setItems(ArrayList<Object> items) {
		this.items = items;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public void setEtag(String etag) {
		this.etag = etag;
	}

	public void setNextPageToken(String nextPageToken) {
		this.nextPageToken = nextPageToken;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

}
