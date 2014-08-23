package com.knowitco.encryptionexample.model;

import java.util.Date;

public class Person {

	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private Gender gender;
	private Date birthDate;

	public Person() {
		// default constructor
	}

	public Person(String firstName, String lastName, String address,
			String phone, Gender gender, Date birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
		this.birthDate = birthDate;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public enum Gender {
		MALE, FEMALE
	};

	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("firstName: " + getFirstName());
		buffer.append("\nlastName: " + getLastName());
		buffer.append("\naddress: " + getAddress());
		buffer.append("\nphone: " + getPhone());
		buffer.append("\ngender: " + getGender());
		buffer.append("\nbirthDate: " + getBirthDate());

		return buffer.toString();
	}
	
	public byte[] getBytes() {
		return toString().getBytes();
	}
}
