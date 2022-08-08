package com.springBoot.ticketBooking.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movieslist")
public class Movielist {
	
	private String movieid;
	private String movieurl;
	private String moviename;
	private String movietype;
	
	@Id
	public String getMovieid() {
		return movieid;
	}
	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}
	public String getMovieurl() {
		return movieurl;
	}
	public void setMovieurl(String movieurl) {
		this.movieurl = movieurl;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getMovietype() {
		return movietype;
	}
	public void setMovietype(String movietype) {
		this.movietype = movietype;
	}
	public Movielist(String movieid, String movieurl, String moviename, String movietype) {
		super();
		this.movieid = movieid;
		this.movieurl = movieurl;
		this.moviename = moviename;
		this.movietype = movietype;
	}
	public Movielist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
