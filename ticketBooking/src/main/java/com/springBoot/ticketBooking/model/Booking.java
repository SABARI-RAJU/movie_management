package com.springBoot.ticketBooking.model;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Booking {
	
	@Id
	private String bookingid;
	private int numberofseat;
	@ElementCollection
	private List<String> seatno;
	private Date date;
	private String showtime;
	@ManyToOne
	@JoinColumn(name = "userid")
	private UserModel user;
	@ManyToOne
	@JoinColumn(name = "showId")
	private Shows show;
	private boolean cancelstatus;
	
	public Booking(String bookingid, int numberofseat, List<String> seatno, Date date, String showtime, UserModel user,
			Shows show, boolean cancelstatus) {
		super();
		this.bookingid = bookingid;
		this.numberofseat = numberofseat;
		this.seatno = seatno;
		this.date = date;
		this.showtime = showtime;
		this.user = user;
		this.show = show;
		this.cancelstatus = cancelstatus;
	}
	
	
	public boolean isCancelstatus() {
		return cancelstatus;
	}


	public void setCancelstatus(boolean cancelstatus) {
		this.cancelstatus = cancelstatus;
	}


	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBookingid() {
		return bookingid;
	}
	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
	}
	public int getNumberofseat() {
		return numberofseat;
	}
	public void setNumberofseat(int numberofseat) {
		this.numberofseat = numberofseat;
	}
	public List<String> getSeatno() {
		return seatno;
	}
	public void setSeatno(List<String> seatno) {
		this.seatno = seatno;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getShowtime() {
		return showtime;
	}
	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public Shows getShow() {
		return show;
	}
	public void setShow(Shows show) {
		this.show = show;
	}
	@Override
	public String toString() {
		return "Booking [bookingid=" + bookingid + ", numberofseat=" + numberofseat + ", seatno=" + seatno + ", date="
				+ date + ", showtime=" + showtime + ", user=" + user + ", show=" + show + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
