package com.example.exercise3.model;

public class UserTO {
	
	private long userId;
	private String firstName;
	private String lastName;
	private String lifeMotto;
	private String password;
	private String email;
	private UserLevel userLevel;
	
	
	public UserTO() {
		super();
	}

	public UserTO(long userId, String firstName, String lastName, String lifeMotto, String password, String email,
			UserLevel userLevel) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lifeMotto = lifeMotto;
		this.password = password;
		this.email = email;
		this.userLevel = userLevel;
	}

	




	public UserEntity copy() {
		return new UserEntity(userId, firstName, lastName, lifeMotto, password, email, userLevel);
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public String getLifeMotto() {
		return lifeMotto;
	}

	public void setLifeMotto(String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserLevel getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(UserLevel userLevel) {
		this.userLevel = userLevel;
	}

}
