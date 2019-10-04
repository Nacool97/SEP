package com.cognizant.sharingeconomy.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.sharingeconomy.model.Product;
import com.cognizant.sharingeconomy.model.Service;
import com.cognizant.sharingeconomy.model.User;
import com.cognizant.sharingeconomy.model.Vendor;
import com.cognizant.sharingeconomy.util.ConnectionHandler;
import com.cognizant.sharingeconomy.util.Encryptor;

public class UserDaoSqlImpl implements UserDao {

	@Override
	public void addUser(User user) throws Exception {
		try {

			Connection con = ConnectionHandler.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into share_economy_user_details(us_first_name,us_last_name,us_age,us_gender,us_contact_number,us_email,us_user_id,us_password) values (?,?,?,?,?,?,?,?)");
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setInt(3, user.getAge());
			ps.setString(4, user.getGender());
			ps.setLong(5, user.getContactNumber());
			ps.setString(6, user.getEmail());
			ps.setString(7, user.getUserId());
			ps.setString(8, Encryptor.getEncrypted(user.getPassword()));
			ps.executeUpdate();
			System.out.println("In addUser");
			con.close();
		} catch (SQLException e) {
			//throw new IdExistException();
			e.printStackTrace();
		}
	}

	public int userLoginDetails(User user) throws Exception {

		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con
				.prepareStatement("select * from share_economy_user_details where us_user_id=? and us_password=? ");
		ps.setString(1, user.getUserId());
		ps.setString(2,Encryptor.getEncrypted(user.getPassword()));
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			return 1;
		}
		System.out.println("In login user");
		return 0;

	}

	public List<Product> getProductByCategory(String category) throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"select pr_id,pr_product_name,pr_category,pr_price,pr_stock from share_economy_product_details where pr_category=? ");
		ps.setString(1, category);
		ResultSet rs = ps.executeQuery();
		List<Product> productList = new ArrayList<Product>();
		while (rs.next()) {
			Product product = new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
					rs.getDouble(5));
			productList.add(product);
		}
		return productList;

	}

	@Override
	public void addCartProduct(String userId, String productId) throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con
				.prepareStatement("insert into  share_economy_product_cart(ct_product_id,ct_user_id)values(?,?)");
		ps.setString(2, userId);
		ps.setString(1, productId);
		ps.executeUpdate();
		System.out.println("in add cart");

	}

	public List<Product> getCartProducts(String userid) throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"select details.pr_id,details.pr_product_name,details.pr_category,details.pr_price,details.pr_stock from share_economy_product_details details inner join share_economy_product_cart cart on details.pr_id=cart.ct_product_id where cart.ct_user_id=? ");
		ps.setString(1, userid);
		List<Product> productList = new ArrayList<Product>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Product product = new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
					rs.getDouble(5));
			productList.add(product);
		}

		return productList;

	}

	public void removeCartProduct(String userId, String productId) throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"delete from share_economy_product_cart where ct_user_id=? and ct_product_id=? limit 1");
		ps.setString(1, userId);
		ps.setString(2, productId);
		ps.executeUpdate();
	}

	public double getTotal(String userid) throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"select sum(pr_price) from share_economy_product_details inner join share_economy_product_cart on ct_product_id=pr_id where ct_user_id=?");
		ps.setString(1, userid);
		ResultSet rs = ps.executeQuery();
		double total = 0;
		while (rs.next()) {
			total = rs.getDouble(1);
		}
		return total;
	}

	public List<Service> getServiceByCategory(String category) throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"select sr_id,sr_service_name,sr_category,sr_price,sr_status,sr_time,sr_contactDetails from share_economy_service_details where sr_category=? ");
		ps.setString(1, category);
		ResultSet rs = ps.executeQuery();
		List<Service> serviceList = new ArrayList<Service>();
		while (rs.next()) {
			Service service = new Service(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4),
					rs.getString(5), rs.getString(6), rs.getString(7));
			serviceList.add(service);
		}
		return serviceList;

	}

	@Override
	public void addCartService(String userId, String serviceId) throws Exception {
		// TODO Auto-generated method stub

		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con
				.prepareStatement("insert into  share_economy_service_cart(srct_service_id,srct_user_id)values(?,?)");
		ps.setString(2, userId);
		ps.setString(1, serviceId);
		ps.executeUpdate();
		System.out.println("in add cart");

	}

	@Override
	public List<Service> getCartServices(String userid) throws Exception {

		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"select details.sr_id,details.sr_service_name,details.sr_category,details.sr_price,details.sr_status,details.sr_time,details.sr_contactDetails from share_economy_service_details details inner join share_economy_service_cart cart on details.sr_id=cart.srct_service_id where cart.srct_user_id=? ");
		ps.setString(1, userid);
		List<Service> serviceList = new ArrayList<Service>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Service service = new Service(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4),
					rs.getString(5), rs.getString(6), rs.getString(7));
			serviceList.add(service);
		}

		return serviceList;
	}

	public float getServiceTotal(String userid) throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"select sum(sr_price) from share_economy_service_details inner join share_economy_service_cart on srct_service_id=sr_id where srct_user_id=?");
		ps.setString(1, userid);
		ResultSet rs = ps.executeQuery();
		float total = 0;
		while (rs.next()) {
			total = rs.getFloat(1);
		}
		return total;
	}

	public void removeCartService(String userId, String serviceId) throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"delete from share_economy_service_cart where srct_user_id=? and srct_service_id=? limit 1");
		ps.setString(1, userId);
		ps.setString(2, serviceId);
		ps.executeUpdate();
		System.out.println("in remove cart");
	}

}
