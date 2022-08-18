package com.springBoot.ticketBooking.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ScreenSeat {

	@Id
	private String seatId;
	private String SeatNumber;
	private boolean status;
	private boolean reserved;
	private int price;
	private String screenid;
	private Date showDate;
	private String showid;
	
	public String getScreenid() {
		return screenid;
	}
	public void setScreenid(String screenid) {
		this.screenid = screenid;
	}
	
	public String getShowid() {
		return showid;
	}
	public void setShowid(String showid) {
		this.showid = showid;
	}
	public ScreenSeat(String seatId, String seatNumber, boolean status, boolean reserved, int price, String screenid,
			Date showDate, String showid) {
		super();
		this.seatId = seatId;
		SeatNumber = seatNumber;
		this.status = status;
		this.reserved = reserved;
		this.price = price;
		this.screenid = screenid;
		this.showDate = showDate;
		this.showid = showid;
	}
	public ScreenSeat() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public boolean isReserved() {
		return reserved;
	}
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Date getShowDate() {
		return showDate;
	}
	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}
	@Override
	public String toString() {
		return "ScreenSeat [seatId=" + seatId + ", SeatNumber=" + SeatNumber + ", status=" + status + ", reserved="
				+ reserved + ", price=" + price + ", screenid=" + screenid + ", showDate=" + showDate + ", showid="
				+ showid + "]";
	}
	
	
	
	
	
}
