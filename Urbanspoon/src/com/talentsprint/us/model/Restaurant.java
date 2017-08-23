package com.talentsprint.us.model;

import java.util.List;

public class Restaurant {
	private int restaurantId;
	private String registrationName;
	private String password;
	private String registartionId;
	private List<Branch> branchesList;

	public List<Branch> getBranchesList() {
		return branchesList;
	}

	public void setBranchesList(List<Branch> branchesList) {
		this.branchesList = branchesList;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public int setRestaurantId(int restaurantId) {
		return this.restaurantId = restaurantId;
	}

	public String getRegistrationName() {
		return registrationName;
	}

	public void setRegistrationName(String registrationName) {
		this.registrationName = registrationName;
	}

	public String getRegistartionId() {
		return registartionId;
	}

	public void setRegistartionId(String registartionId) {
		this.registartionId = registartionId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", registrationName=" + registrationName + ", password="
				+ password + ", registartionId=" + registartionId + ", branchesList=" + branchesList + "]";
	}

}
