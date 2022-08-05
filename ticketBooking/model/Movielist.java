package com.springBoot.ticketBooking.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movieslist")
public class Movielist {
	
	private String movieid;
	private String moviename;
	private String movietype;
	
	@Id 
	public String getMovieid() {
		return movieid;
	}
	public Movielist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setMovieid(String movieid) {
		this.movieid = movieid;
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
	public Movielist(String movieid, String moviename, String movietype) {
		super();
		this.movieid = movieid;
		this.moviename = moviename;
		this.movietype = movietype;
	}

}
