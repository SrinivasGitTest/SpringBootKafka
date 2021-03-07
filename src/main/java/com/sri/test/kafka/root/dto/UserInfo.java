package com.sri.test.kafka.root.dto;

public class UserInfo {
	
	private String userId;
	private String userName;
	private String address;
	private String email;
	
	public UserInfo(String userId, String userName, String address, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.email = email;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", address=" + address + ", email=" + email
				+ "]";
	}

	
}
