package com.renatopuskaric.FilmApi.models;

public class Items {

	private String kind;
	private String etag;
	private Id IdObject;
	private Snippet SnippetObject;
	private Player player;
	
	


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
	 
	 public Player getPlayer() {
		return player;
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
	 
		public void setPlayer(Player player) {
			this.player = player;
		}

}
