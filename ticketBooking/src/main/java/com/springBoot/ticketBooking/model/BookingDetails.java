package com.springBoot.ticketBooking.model;

import java.util.List;

public class BookingDetails {
	
	private String deatailId;
	private String bookingId;
	private String movieId;
	private float price;
	private List<ScreenSeat> seat;
	public String getDeatailId() {
		return deatailId;
	}
	public void setDeatailId(String deatailId) {
		this.deatailId = deatailId;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public List<ScreenSeat> getSeat() {
		return seat;
	}
	public void setSeat(List<ScreenSeat> seat) {
		this.seat = seat;
	}
	

}
