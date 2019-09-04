package com.example.SpringBoot.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	@Pattern(regexp = "^[A-Za-z]+$", message = "Please enter the username containing only alphabets")
	@Size(min = 3, max = 50, message = "Username must be between 3 and 200 characters")
	@Column(name="username")
	private String username;
	@Column(name="password")
	@NotEmpty(message = "please enter the password")
	private String password;
	@Column(name="usertype")
	@NotEmpty(message = "please enter the usertype")
	private String usertype;
	//@Email(message = "Email should be valid")
	@NotEmpty(message = "please enter the Email")
	@Column(name="email")
	private String email;
	@Column(name="mobile_no")
	private long mobileNo;
	@NotEmpty(message = "please enter the status of confirmation")
	@Column(name="confirmed")
	private String confirmed;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}

}
