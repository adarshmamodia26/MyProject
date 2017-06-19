package com.mobizio.datamodel;

public class UserModel {
	
	private String userName;
	private String email;
	private String password;
	private String confirmPassword;
	private String tenantUserId;	
	private String title;
	private String firstName;
	private String lastName; 
	private String dob;
	private String gender;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String county;
	private String postCode;
	private String country;
	private String latitude;
	private String longitude;
	private String primaryTelephone;
	private String secondaryTelephone;
	private String branch;
	private String userType;
	private String pin;
	
	public String getUserType() {
		return userType;
	}
	public String setUserType(String userType) {
		this.userType = userType;
		return userType;
	}
	
	public String getPin() {
		return pin;
	}
	public String setPin(String pin) {
		this.pin = pin;
		return pin;
	}
	
	public String getTenantUserId() {
		return tenantUserId;
	}
	public String setTenantUserId(String tenantUserId) {
		this.tenantUserId = tenantUserId;
		return tenantUserId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getPrimaryTelephone() {
		return primaryTelephone;
	}
	public void setPrimaryTelephone(String primaryTelephone) {
		this.primaryTelephone = primaryTelephone;
	}
	public String getSecondaryTelephone() {
		return secondaryTelephone;
	}
	public void setSecondaryTelephone(String secondaryTelephone) {
		this.secondaryTelephone = secondaryTelephone;
	}

	public String getBranch() {
		return branch;
	}
	public String setBranch(String branch) {
		this.branch = branch;
		return branch;
	}
	
	
}
