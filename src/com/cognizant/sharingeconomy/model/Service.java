package com.cognizant.sharingeconomy.model;

public class Service {
	private String vendorid;
	private String userid;
	private String serviceid;
	private String servicename;
	private float price;
	private String category;
	private String status;
	private String time;
	private String contact;

	public String getVendorid() {
		return vendorid;
	}

	public void setVendorid(String vendorid) {
		this.vendorid = vendorid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getServiceid() {
		return serviceid;
	}

	public void setServiceid(String serviceid) {
		this.serviceid = serviceid;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public Service(String vendorid, String userid, String serviceid, String servicename, float price, String category,
			String status, String time, String contact) {
		super();
		this.vendorid = vendorid;
		this.userid = userid;
		this.serviceid = serviceid;
		this.servicename = servicename;
		this.price = price;
		this.category = category;
		this.status = status;
		this.time = time;
		this.contact = contact;
	}

	public Service(String vendorid, String serviceid, String servicename, float price, String category, String status,
			String time, String contact) {
		super();
		this.vendorid = vendorid;
		this.serviceid = serviceid;
		this.servicename = servicename;
		this.price = price;
		this.category = category;
		this.status = status;
		this.time = time;
		this.contact = contact;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Service(String serviceid, String servicename, String category, float price, String status, String time,
			String contact) {
		super();
		this.serviceid = serviceid;
		this.servicename = servicename;
		this.price = price;
		this.category = category;
		this.status = status;
		this.time = time;
		this.contact = contact;
	}

}
