package com.springBoot.ticketBooking.model;

public class Seat {

	private String seatId;
	private String SeatNumber;
	private boolean status;
	private int price;
	private String cinemaHallId;
	private String bookingId;
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public String getSeatNumber() {
		return SeatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		SeatNumber = seatNumber;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCinemaHallId() {
		return cinemaHallId;
	}
	public void setCinemaHallId(String cinemaHallId) {
		this.cinemaHallId = cinemaHallId;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	
	
}
