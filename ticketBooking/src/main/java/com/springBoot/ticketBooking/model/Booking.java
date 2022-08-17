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
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingid;
	private int numberofseat;				
	private Date date;
	private String showtime;
	private String useremail;
	private String moviename;
	
	@ElementCollection
	private List<String> seatno;
	 
	public List<String> getSeatno() {
		return seatno;
	}
	public void setSeatno(List<String> seatno) {
		this.seatno = seatno;
	}
	private String cinemahallname;
	
	
	public long getBookingid() {
		return bookingid;
	}
	
	public void setBookingid(long bookingid) {
		this.bookingid = bookingid;
	}
	public int getNumberofseat() {
		return numberofseat;
	}
	public void setNumberofseat(int numberofseat) {
		this.numberofseat = numberofseat;
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
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	
	public String getCinemahallname() {
		return cinemahallname;
	}
	public void setCinemahallname(String cinemahallname) {
		this.cinemahallname = cinemahallname;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(int bookingid, int numberofseat, Date date, String showtime, String useremail, String moviename,
			List<String> seatno, String cinemahallname) {
		super();
		this.bookingid = bookingid;
		this.numberofseat = numberofseat;
		this.date = date;
		this.showtime = showtime;
		this.useremail = useremail;
		this.moviename = moviename;
		this.seatno = seatno;
		this.cinemahallname = cinemahallname;
	}
	
	
	
	
	
	

}
