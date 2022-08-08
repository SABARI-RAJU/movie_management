package com.springBoot.ticketBooking.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Booking {
	
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public int getNumberOfSeat() {
		return numberOfSeat;
	}
	public void setNumberOfSeat(int numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public List<Movielist> getMovies() {
		return movies;
	}
	public void setMovies(List<Movielist> movies) {
		this.movies = movies;
	}
	public String getCinemaHallId() {
		return cinemaHallId;
	}
	public void setCinemaHallId(String cinemaHallId) {
		this.cinemaHallId = cinemaHallId;
	}
	private String bookingId;
	private int numberOfSeat;				
	private Date date;
	private Time time;
	private String userEmail;
	private List<Movielist> movies;
	private String cinemaHallId;
	
	
	

}
