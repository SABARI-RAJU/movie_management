package com.springBoot.ticketBooking.model;

import java.time.Duration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Movielist {
	
	@Id
	private String movieid;
	private String title;
	private String movieurl;
	private String moviedescription;
	private String movietype;
	private String movieduration;
	private String releaseddate;
	
//	@OneToOne(mappedBy = "screen")
//	private Shows show;

	public String getMovieid() {
		return movieid;
	}

	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMovieurl() {
		return movieurl;
	}

	public void setMovieurl(String movieurl) {
		this.movieurl = movieurl;
	}

	public String getMoviedescription() {
		return moviedescription;
	}

	public void setMoviedescription(String moviedescription) {
		this.moviedescription = moviedescription;
	}

	public String getMovietype() {
		return movietype;
	}

	public void setMovietype(String movietype) {
		this.movietype = movietype;
	}

	public String getMovieduration() {
		return movieduration;
	}

	public void setMovieduration(String movieduration) {
		this.movieduration = movieduration;
	}

	public String getReleaseddate() {
		return releaseddate;
	}

	public void setReleaseddate(String releaseddate) {
		this.releaseddate = releaseddate;
	}

	

	public Movielist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movielist(String movieid, String title, String movieurl, String moviedescription, String movietype,
			String movieduration, String releaseddate) {
		super();
		this.movieid = movieid;
		this.title = title;
		this.movieurl = movieurl;
		this.moviedescription = moviedescription;
		this.movietype = movietype;
		this.movieduration = movieduration;
		this.releaseddate = releaseddate;
	}
	
	
	
	

}
