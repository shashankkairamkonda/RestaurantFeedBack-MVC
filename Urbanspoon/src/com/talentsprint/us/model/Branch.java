package com.talentsprint.us.model;

public class Branch {
private int branchId;
private String location;
private String city;
private String state;
private String imagePath;
private String postalCode;
private  int restaurntId;
private long phoneNumber;
private String emailId;
private String country;
public int getBranchId() {
	return branchId;
}
public void setBranchId(int branchId) {
	this.branchId = branchId;
}

public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getImagePath() {
	return imagePath;
}
public void setImagePath(String imagePath) {
	this.imagePath = imagePath;
}
public String getPostalCode() {
	return postalCode;
}
public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
}
public int getRestaurntId() {
	return restaurntId;
}
public void setRestaurntId(int restaurntId) {
	this.restaurntId = restaurntId;
}
public long getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(long phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
@Override
public String toString() {
	return "Branch [branchId=" + branchId + ", location=" + location
			+ ", city=" + city + ", state=" + state + ", imagePath="
			+ imagePath + ", postalCode=" + postalCode + ", restaurntId="
			+ restaurntId + ", phoneNumber=" + phoneNumber + ", emailId="
			+ emailId + ", country=" + country + "]";
}

}
