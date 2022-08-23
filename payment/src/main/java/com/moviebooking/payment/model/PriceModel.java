package com.moviebooking.payment.model;

public class PriceModel {
	private int totalPrice;
	private int amount;
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public PriceModel(int totalPrice, int amount) {
		super();
		this.totalPrice = totalPrice;
		this.amount = amount;
	}
	public PriceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
