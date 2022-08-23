package com.springBoot.ticketBooking.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Shows {
	@Id
	private String showId;
	private Date showDate;
	private String showType;
	private String startTime;
	private String endTime;
	private int price;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "screenid")
	private cinemaScreen screen;
	@OneToOne
	@JoinColumn(name = "movieid")
	private Movielist movie;
	private Date createdDate;

	public Shows() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shows(String showId, Date showDate, String showType, String startTime, String endTime, int price,
			cinemaScreen screen, Movielist movie, Date createdDate) {
		super();
		this.showId = showId;
		this.showDate = showDate;
		this.showType = showType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
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
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
		return "Shows [showId=" + showId + ", showDate=" + showDate + ", ShowType=" + showType + ", startTime="
				+ startTime + ", endTime=" + endTime + ", screen=" + screen + ", movie=" + movie + ", createdDate="
				+ createdDate + ", getShowId()=" + showId + ", getShowDate()=" + showDate + ", getShowType()="
				+ showType + ", getStartTime()=" + startTime + ", getEndTime()=" + endTime + ", getScreen()=" + screen
				+ ", getMovie()=" + movie + ", getCreatedDate()=" + createdDate + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
