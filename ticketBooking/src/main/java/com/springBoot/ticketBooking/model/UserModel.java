package com.springBoot.ticketBooking.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class UserModel {
	
	@Id
	private String userid;
	private String username;
	private String email;
	private String userpassword;
	private String usertype;

	
	
	
	public String getUserid() {
		return userid;
	}




	public void setUserid(String userid) {
		this.userid = userid;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getUserpassword() {
		return userpassword;
	}




	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}




	public String getUsertype() {
		return usertype;
	}




	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}




	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}




	public UserModel(String userid, String username, String email, String userpassword, String usertype) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.userpassword = userpassword;
		this.usertype = usertype;
	}
	
	
	

	

}
