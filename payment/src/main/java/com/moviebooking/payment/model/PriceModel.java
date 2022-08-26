package com.moviebooking.payment.model;

public class PriceModel {
	private String totalPrice;
	private String amount;
	private String bookingId;

	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getAmount() {
		return amount;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	
	public PriceModel(String totalPrice, String amount, String bookingId) {
		super();
		this.totalPrice = totalPrice;
		this.amount = amount;
		this.bookingId = bookingId;
	}
	public PriceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
