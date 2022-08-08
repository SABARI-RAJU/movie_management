package com.springBoot.ticketBooking.model;

import java.util.List;

public class CinemaHall {
	
	private String cinemaHallId;
	private String name;
	private int totalSeats;
	private String city;
	private List<Movielist> movies;
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
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Movielist> getMovies() {
		return movies;
	}
	public void setMovies(List<Movielist> movies) {
		this.movies = movies;
	}
	

}
