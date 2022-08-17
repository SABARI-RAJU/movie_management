package com.springBoot.ticketBooking.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Shows {
	@Id
	private String showId;
	private Date showDate;
	private String ShowType;
	private String startTime;
	private String endTime;
	@OneToOne
	@JoinColumn(name="screenid")
	private cinemaScreen screen;
	@OneToOne
	@JoinColumn(name="movieid")
	private Movielist movie;
	private Date createdDate;
	
	public Shows() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shows(String showId, Date showDate, String showType, String startTime, String endTime, cinemaScreen screen,
			Movielist movie, Date createdDate) {
		super();
		this.showId = showId;
		this.showDate = showDate;
		ShowType = showType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.screen = screen;
		this.movie = movie;
		this.createdDate = createdDate;
	}
	public String getShowId() {
		return showId;
	}
	public void setShowId(String showId) {
		this.showId = showId;
	}
	public Date getShowDate() {
		return showDate;
	}
	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}
	public String getShowType() {
		return ShowType;
	}
	public void setShowType(String showType) {
		ShowType = showType;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public cinemaScreen getScreen() {
		return screen;
	}
	public void setScreen(cinemaScreen screen) {
		this.screen = screen;
	}
	public Movielist getMovie() {
		return movie;
	}
	public void setMovie(Movielist movie) {
		this.movie = movie;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "Shows [showId=" + showId + ", showDate=" + showDate + ", ShowType=" + ShowType + ", startTime="
				+ startTime + ", endTime=" + endTime + ", screen=" + screen + ", movie=" + movie + ", createdDate="
				+ createdDate + ", getShowId()=" + getShowId() + ", getShowDate()=" + getShowDate() + ", getShowType()="
				+ getShowType() + ", getStartTime()=" + getStartTime() + ", getEndTime()=" + getEndTime()
				+ ", getScreen()=" + getScreen() + ", getMovie()=" + getMovie() + ", getCreatedDate()="
				+ getCreatedDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	

}
