package com.qub.artios.Entity;


public class Website {
	private String title;
	private String url;
	
	// parameterized constructor 
	public Website(String title, String url) {
		super();
		this.title = title;
		this.url = url;
	}
	
	// Getters and setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	

}
