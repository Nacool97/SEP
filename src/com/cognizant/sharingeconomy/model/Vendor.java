package com.cognizant.sharingeconomy.model;

public class Vendor {
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private long contactNumber;
	private String vendorId;
	private String password;
	private String email;
	private String address;
	private String zip;
	private String city;

	public Vendor(String firstName, String lastName, int age, String gender, long contactNumber, String vendorId,
			String email, String address, String zip, String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.vendorId = vendorId;
		this.email = email;
		this.address = address;
		this.zip = zip;
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Vendor(String firstName, String lastName, int age, String gender, long contactNumber, String email,
			String vendorId, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.email = email;
		this.vendorId = vendorId;
		this.password = password;
	}

	public Vendor(String vendorId, String password) {
		super();
		this.vendorId = vendorId;
		this.password = password;
	}

}
