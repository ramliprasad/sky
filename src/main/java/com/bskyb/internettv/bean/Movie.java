package com.bskyb.internettv.bean;
/**
 * Movie class is used to create the movie database.
 * @author surramli
 *
 */
public class Movie {
	
	private String id;
	private String name;
	private String rating;
	
	public Movie(String id, String name, String rating) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRating() {
		return rating;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	
}
