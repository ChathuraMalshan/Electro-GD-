package com.paf.model;

public class User {

	private String Id;
	private String UserName;
	private String Address;
	private String MobileNo;
	private String Email;
	private String AccNumber;

	public User() {

	}

	public User(String Id, String UserName, String Address, String MobileNo, String Email, String AccNumber) {
		super();
		this.Id = Id;
		this.UserName = UserName;
		this.Address = Address;
		this.MobileNo = MobileNo;
		this.Email = Email;
		this.AccNumber = AccNumber;
	}

	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String MobileNo) {
		this.MobileNo = MobileNo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getAccNumber() {
		return AccNumber;
	}

	public void setAccNumber(String AccNumber) {
		this.AccNumber = AccNumber;
	}

}
