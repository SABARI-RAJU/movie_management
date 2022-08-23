package com.springBoot.ticketBooking.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CinemaHall {
	
	@Id
	private String cinemaHallId;
	private String name;
	private int totalScreens;
	private String city;
public CinemaHall() {
		super();
		// TODO Auto-generated constructor stub
	}
	//	private List<Movielist> movies;
	@OneToMany(mappedBy = "hall")
	private List<cinemaScreen> screen;
	private Date createdDate;
	private Date modifiedDate;
	
	public int getTotalScreens() {
		return totalScreens;
	}
	public void setTotalScreens(int totalScreens) {
		this.totalScreens = totalScreens;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCinemaHallId() {
		return cinemaHallId;
	}
	public void setCinemaHallId(String cinemaHallId) {
		this.cinemaHallId = cinemaHallId;
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
	public CinemaHall(String cinemaHallId, String name, int totalScreens, String city, List<cinemaScreen> screen,
			Date createdDate, Date modifiedDate) {
		super();
		this.cinemaHallId = cinemaHallId;
		this.name = name;
		this.totalScreens = totalScreens;
		this.city = city;
		this.screen = screen;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
	public List<cinemaScreen> getScreen() {
		return screen;
	}
	public void setScreen(List<cinemaScreen> screen) {
		this.screen = screen;
	}
	public void setCity(String city) {
		this.city = city;
	}
//	public List<Movielist> getMovies() {
//		return movies;
//	}
//	public void setMovies(List<Movielist> movies) {
//		this.movies = movies;
//	}
	

}
