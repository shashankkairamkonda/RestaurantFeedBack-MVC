package com.talentsprint.us.model;

import java.util.ArrayList;

public class User {
	private int user_id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private long phoneNumber;
	private ArrayList<Feedback> userFeedback;

	public ArrayList<Feedback> getUserFeedback() {
		return userFeedback;
	}

	public void setUserFeedback(ArrayList<Feedback> userFeedback) {
		this.userFeedback = userFeedback;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
