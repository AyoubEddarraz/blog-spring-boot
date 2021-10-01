package com.app.blog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
		name = "users",
		uniqueConstraints = {
				@UniqueConstraint(
						name = "unique_email_constraint",
						columnNames = "email"
				)
		}
)
public class UserEntity {
	
	@Id
	@SequenceGenerator(
			name = "id_user_sequence",
			sequenceName = "id_user_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "id_user_sequence"
	)
	private Long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false)
	private String email; 
	
	@Column(name = "EncryptedPassword" ,nullable = false)
	private String password;
	
	@Column(nullable = false)
	private Boolean admin;
	
	@Column(nullable = false)
	private String UID;
	
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(Long id, String firstName, String lastName, String email, String password, Boolean admin,
			String uID) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.admin = admin;
		this.UID = uID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		this.UID = uID;
	}

}
