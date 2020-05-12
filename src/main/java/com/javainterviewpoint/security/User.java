package com.javainterviewpoint.security;

public class User {

	private String customerId;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String question1;
	private String answer1;
	private String userName;
	private String password;
	private String token;
	private String tokenExpirationDate;
	private boolean social;
	
	
	public boolean isSocial() {
		return social;
	}
	public void setSocial(boolean social) {
		this.social = social;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getQuestion1() {
		return question1;
	}
	public void setQuestion1(String question1) {
		this.question1 = question1;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTokenExpirationDate() {
		return tokenExpirationDate;
	}
	public void setTokenExpirationDate(String tokenExpirationDate) {
		this.tokenExpirationDate = tokenExpirationDate;
	}
}
