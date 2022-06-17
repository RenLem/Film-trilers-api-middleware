package com.renatopuskaric.FilmApi.models;

import java.util.ArrayList;


public class YouTubeObject {

	private String kind;
	private String etag;
	private String nextPageToken;
	private String regionCode;

	ArrayList<Items> items = new ArrayList<Items>();

	// Getter Methods

	public ArrayList<Items> getItems() {
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

	public void setItems(ArrayList<Items> items) {
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
	
	public class Object {
		
		private String kind;
		 private String etag;
		 Id IdObject;
		 Snippet SnippetObject;


		 // Getter Methods 

		 public String getKind() {
		  return kind;
		 }

		 public String getEtag() {
		  return etag;
		 }

		 public Id getId() {
		  return IdObject;
		 }

		 public Snippet getSnippet() {
		  return SnippetObject;
		 }

		 // Setter Methods 

		 public void setKind(String kind) {
		  this.kind = kind;
		 }

		 public void setEtag(String etag) {
		  this.etag = etag;
		 }

		 public void setId(Id idObject) {
		  this.IdObject = idObject;
		 }

		 public void setSnippet(Snippet snippetObject) {
		  this.SnippetObject = snippetObject;
		 }

	}
	
	public class Id {
		
		 private String kind;
		 private String videoId;


		 // Getter Methods 

		 public String getKind() {
		  return kind;
		 }

		 public String getVideoId() {
		  return videoId;
		 }

		 // Setter Methods 

		 public void setKind(String kind) {
		  this.kind = kind;
		 }

		 public void setVideoId(String videoId) {
		  this.videoId = videoId;
		 }

	}
	
	public class Snippet {
		 private String publishedAt;
		 private String channelId;
		 private String title;
		 private String description;
		 private String channelTitle;
		 private String liveBroadcastContent;
		 private String publishTime;


		 // Getter Methods 

		 public String getPublishedAt() {
		  return publishedAt;
		 }

		 public String getChannelId() {
		  return channelId;
		 }

		 public String getTitle() {
		  return title;
		 }

		 public String getDescription() {
		  return description;
		 }

		 public String getChannelTitle() {
		  return channelTitle;
		 }

		 public String getLiveBroadcastContent() {
		  return liveBroadcastContent;
		 }

		 public String getPublishTime() {
		  return publishTime;
		 }

		 // Setter Methods 

		 public void setPublishedAt(String publishedAt) {
		  this.publishedAt = publishedAt;
		 }

		 public void setChannelId(String channelId) {
		  this.channelId = channelId;
		 }

		 public void setTitle(String title) {
		  this.title = title;
		 }

		 public void setDescription(String description) {
		  this.description = description;
		 }

		 public void setChannelTitle(String channelTitle) {
		  this.channelTitle = channelTitle;
		 }

		 public void setLiveBroadcastContent(String liveBroadcastContent) {
		  this.liveBroadcastContent = liveBroadcastContent;
		 }

		 public void setPublishTime(String publishTime) {
		  this.publishTime = publishTime;
		 }
		 
		}




}
