package com.springBoot.ticketBooking.model;

import java.util.Date;

import javax.persistence.ColumnResult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class FilterResponse {

	private String title;
	private String movieurl;
	private String moviedescription;
	private String movieduration;
	private String movietype;
	private String show_type;
	private Date show_date;
	private String start_time;
	private String screename;
	private String name;
	private String city;

	public FilterResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	public FilterResponse(String title, String movieurl, String moviedescription, String movieduration,
			String movietype, String show_type, Date show_date, String start_time, String screename, String name,
			String city) {
		super();
		this.title = title;
		this.movieurl = movieurl;
		this.moviedescription = moviedescription;
		this.movieduration = movieduration;
		this.movietype = movietype;
		this.show_type = show_type;
		this.show_date = show_date;
		this.start_time = start_time;
		this.screename = screename;
		this.name = name;
		this.city = city;
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

	public String getMovieduration() {
		return movieduration;
	}

	public void setMovieduration(String movieduration) {
		this.movieduration = movieduration;
	}

	public String getMovietype() {
		return movietype;
	}

	public void setMovietype(String movietype) {
		this.movietype = movietype;
	}

	public String getShow_type() {
		return show_type;
	}

	public void setShow_type(String show_type) {
		this.show_type = show_type;
	}

	public Date getShow_date() {
		return show_date;
	}

	public void setShow_date(Date show_date) {
		this.show_date = show_date;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getScreename() {
		return screename;
	}

	public void setScreename(String screename) {
		this.screename = screename;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
