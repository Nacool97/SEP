package com.cognizant.sharingeconomy.dao;

public class NoServiceException extends RuntimeException {

	public String toString() {
		return "No services added!";
	}
}
