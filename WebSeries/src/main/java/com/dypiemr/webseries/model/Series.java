package com.dypiemr.webseries.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="series")
public class Series {

	// define fields
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column(name="name")
	private String name;

	@Column(name="seasons")
	private String seasons;
	
	@Column(name="episodes")
	private String episodes;
	
	@Column(name="rating")
	private String rating;
	
		
	// define constructors
	
	public Series() {
		
	}

	public Series(String name, String seasons, String episodes,String rating) {
		this.name = name;
		this.seasons = seasons;
		this.episodes = episodes;
		this.rating=rating;
	}

	// define getter/setter
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeasons() {
		return seasons;
	}

	public void setSeasons(String seasons) {
		this.seasons = seasons;
	}

	public String getEpisodes() {
		return episodes;
	}

	public void setEpisodes(String episodes) {
		this.episodes = episodes;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	// define tostring
	@Override
	public String toString() {
		return "Series [id=" + id + ", name=" + name + ", seasons=" + seasons + ", episodes" + episodes
				+ ", rating=" + rating + "]";
	}
	
		
}

