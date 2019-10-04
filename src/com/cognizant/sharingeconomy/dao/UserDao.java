package com.cognizant.sharingeconomy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.cognizant.sharingeconomy.model.Product;
import com.cognizant.sharingeconomy.model.Service;
import com.cognizant.sharingeconomy.model.User;
import com.cognizant.sharingeconomy.model.Vendor;

public interface UserDao {
	public void addUser(User user) throws Exception;

	public int userLoginDetails(User user) throws Exception;

	public List<Product> getProductByCategory(String category) throws Exception;

	public void addCartProduct(String userId, String productId) throws Exception;

	public List<Product> getCartProducts(String userid) throws Exception;

	public void removeCartProduct(String userId, String productId) throws Exception;

	public double getTotal(String userid) throws Exception;

	public List<Service> getServiceByCategory(String category) throws Exception;

	public void addCartService(String userId, String serviceId) throws Exception;

	public List<Service> getCartServices(String userid) throws Exception;

	public float getServiceTotal(String userid) throws Exception;

	public void removeCartService(String userId, String serviceId) throws Exception;

}
