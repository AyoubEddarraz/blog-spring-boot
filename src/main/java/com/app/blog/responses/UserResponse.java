package com.app.blog.responses;

public class UserResponse {
	
	private Long id;
	private String UID;
	private String firstName;
	private String lastName;
	private String email; 
	private Boolean admin;

	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserResponse(Long id, String uID, String firstName, String lastName, String email, Boolean admin) {
		super();
		this.id = id;
		this.UID = uID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.admin = admin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		this.UID = uID;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
}
