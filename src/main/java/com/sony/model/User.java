package com.sony.model;

import java.util.UUID;

import lombok.Data;

@Data
public class User {
	private String uuid;
	private String firstName;
	private String lastName;
	private String homePhone;
	private String notes;

	public User() {
		super();
		this.uuid = UUID.randomUUID().toString();
	}

	public User(String firstName, String lastName, String homePhone, String notes) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.homePhone = homePhone;
		this.notes = notes;
	}


}
