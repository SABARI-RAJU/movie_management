package com.springBoot.ticketBooking.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class cinemaScreen {
	
	@Id
	private String screenid;
	private String screename;
	private int totalseats;
	private int rowdetails;
	private int columndetails;
	@ManyToOne
	@JoinColumn(name = "cinemaHallId")
	private CinemaHall hall;
//	@OneToOne(mappedBy = "screen",fetch = FetchType.LAZY)
//	private Shows show;
public cinemaScreen() {
		super();
		// TODO Auto-generated constructor stub
	}
public cinemaScreen(String screenid, String screename, int totalseats, int rowdetails, int columndetails,
			CinemaHall hall, Date createdDate, Date modifiedDate) {
		super();
		this.screenid = screenid;
		this.screename = screename;
		this.totalseats = totalseats;
		this.rowdetails = rowdetails;
		this.columndetails = columndetails;
		this.hall = hall;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
public String getScreenid() {
		return screenid;
	}
	public void setScreenid(String screenid) {
		this.screenid = screenid;
	}
	public String getScreename() {
		return screename;
	}
	public void setScreename(String screename) {
		this.screename = screename;
	}
	public int getTotalseats() {
		return totalseats;
	}
	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}
	public int getRowdetails() {
		return rowdetails;
	}
	public void setRowdetails(int rowdetails) {
		this.rowdetails = rowdetails;
	}
	public int getColumndetails() {
		return columndetails;
	}
	public void setColumndetails(int columndetails) {
		this.columndetails = columndetails;
	}
	public CinemaHall getHall() {
		return hall;
	}
	public void setHall(CinemaHall hall) {
		this.hall = hall;
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
	//	private String screendetailId;
//	private String screenseatId;
	private Date createdDate;
	private Date modifiedDate;
	

}
