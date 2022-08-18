package com.springBoot.ticketBooking.model;

import java.sql.Date;

public class ShowFilter {
	
	private String showtype;
	private Date showdate;
	private String movietype;
	private String screenid;
	private String name;
	private String city;
	public String getShowtype() {
		return showtype;
	}
	public void setShowtype(String showtype) {
		this.showtype = showtype;
	}
	public Date getShowdate() {
		return showdate;
	}
	public void setShowdate(Date showdate) {
		this.showdate = showdate;
	}
	public String getMovietype() {
		return movietype;
	}
	public void setMovietype(String movietype) {
		this.movietype = movietype;
	}
	public String getScreenid() {
		return screenid;
	}
	public void setScreenid(String screenid) {
		this.screenid = screenid;
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
	public ShowFilter(String showtype, Date showdate, String movietype, String screenid, String name, String city) {
		super();
		this.showtype = showtype;
		this.showdate = showdate;
		this.movietype = movietype;
		this.screenid = screenid;
		this.name = name;
		this.city = city;
	}
	public ShowFilter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
