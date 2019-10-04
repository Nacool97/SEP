package com.cognizant.sharingeconomy.dao;

import java.sql.PreparedStatement;

import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import com.cognizant.sharingeconomy.model.Product;
import com.cognizant.sharingeconomy.model.Service;
import com.cognizant.sharingeconomy.model.Vendor;
import com.cognizant.sharingeconomy.util.ConnectionHandler;
import com.cognizant.sharingeconomy.util.Encryptor;

public class VendorDaoSqlImpl implements VendorDao {
	  
	@Override
	public void addVendor(Vendor vendor) throws Exception {
		try {
			Connection con = ConnectionHandler.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into share_economy_vendor_details(ve_first_name,ve_last_name,ve_age,ve_gender,ve_contact_number,ve_email,ve_vendor_id,ve_password) values (?,?,?,?,?,?,?,?)");
			ps.setString(1, vendor.getFirstName());
			ps.setString(2, vendor.getLastName());
			ps.setInt(3, vendor.getAge());
			ps.setString(4, vendor.getGender());
			ps.setLong(5, vendor.getContactNumber());
			ps.setString(6, vendor.getEmail());
			ps.setString(7, vendor.getVendorId());
			ps.setString(8, Encryptor.getEncrypted(vendor.getPassword()));
			//ps.setString(8,vendor.getPassword());
			int i = ps.executeUpdate();
			System.out.println("In addVendor");
			con.close();
		} catch (SQLException e) {
			//throw new IdExistException();
			System.out.println(e.getMessage());
		e.printStackTrace();
		}
	}

	public int vendorLoginDetails(Vendor vendor) throws Exception {
		
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con
				.prepareStatement("select * from share_economy_vendor_details where ve_vendor_id=? and ve_password=? ");
		ps.setString(1, vendor.getVendorId());
		ps.setString(2, Encryptor.getEncrypted(vendor.getPassword()));
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
		return 1;
		}
		System.out.println("In loginsVendor");
		return 0;
	}

	public void addProduct(Product product) throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into share_economy_product_details values (?,?,?,?,?,?)");
		ps.setString(1, product.getVendorId());
		ps.setString(2, product.getProductId());
		ps.setString(3, product.getProductName());
		ps.setString(4, product.getCategory());
		ps.setDouble(5, product.getPrice());
		ps.setDouble(6, product.getStock());

		int i = ps.executeUpdate();
		System.out.println("In product");
		con.close();
	}

	public void addCategory(String category) throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into share_economy_product_category values (?)");
		ps.setString(1, category);
		int i = ps.executeUpdate();
		System.out.println("In category");
		con.close();

	}

	public List<String> getCategoryVendor() throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con
				.prepareStatement("select * from sharing_economy_platform.share_economy_product_category");
		List<String> categoryL = new ArrayList<String>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String category = rs.getString(1);
			categoryL.add(category);
		}

		con.close();
		return categoryL;
	}

	public List<Product> getProductVendor(String vendorid) throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from share_economy_product_details where pr_vendor_id=?");
		ps.setString(1, vendorid);
		List<Product> productList = new ArrayList<Product>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Product p = new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),
					rs.getLong(6));
			productList.add(p);

		}

		return productList;
	}

	public Product getProduct(String vendorId, String productId) throws Exception {

		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con
				.prepareStatement("select * from share_economy_product_details where pr_id=? and pr_vendor_id=?");
		ps.setString(1, productId);
		ps.setString(2, vendorId);
		ResultSet rs = ps.executeQuery();
		Product p = null;
		while (rs.next()) {

			p = new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),
					rs.getLong(6));
		}
		return p;
	}

	@Override
	public void editProduct(Product product) throws Exception {

		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"update share_economy_product_details set pr_id=?,pr_product_name=?,pr_category=?,pr_price=?,pr_stock=? where pr_id=?");

		ps.setString(1, product.getProductId());
		ps.setString(2, product.getProductName());
		ps.setString(3, product.getCategory());
		ps.setDouble(4, product.getPrice());
		ps.setDouble(5, product.getStock());
		ps.setString(6, product.getProductId());

		ps.executeUpdate();
		con.close();
	}

	public void deleteProduct(Product product) throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement("delete from share_economy_product_details where pr_id=?");
		ps.setString(1, product.getProductId());
		ps.executeUpdate();
		con.close();
	}

	public void addService(Service service) throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"insert into share_economy_service_details(sr_vendor_id,sr_user_id,sr_id,sr_service_name,sr_price,sr_category,sr_status,sr_time,sr_contactDetails) values (?,?,?,?,?,?,?,?,?)");
		ps.setString(1, service.getVendorid());
		ps.setString(2, service.getUserid());
		ps.setString(3, service.getServiceid());
		ps.setString(4, service.getServicename());
		ps.setFloat(5, service.getPrice());
		ps.setString(6, service.getCategory());
		ps.setString(7, service.getStatus());
		ps.setString(8, service.getTime());
		ps.setString(9, service.getContact());
		int i = ps.executeUpdate();
		System.out.println("In Service");
		con.close();

	}

	public List<String> getCategoryServiceVendor() throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con
				.prepareStatement("select * from sharing_economy_platform.share_economy_service_category");
		List<String> categoryL = new ArrayList<String>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String category = rs.getString(1);
			categoryL.add(category);
		}

		con.close();
		return categoryL;
	}

	public void addCategoryService(String category) throws Exception {

		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into share_economy_service_category values (?)");
		ps.setString(1, category);
		int i = ps.executeUpdate();
		System.out.println("In categoryService");
		con.close();

	}

	public List<Service> getServiceVendor(String vendorid) throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"select sr_vendor_id,sr_user_id,sr_id,sr_service_name,sr_price,sr_category,sr_status,sr_time,sr_contactDetails from share_economy_service_details where sr_vendor_id=?");
		ps.setString(1, vendorid);
		List<Service> serviceList = new ArrayList<Service>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Service services = new Service(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					Float.parseFloat(rs.getString(5)), rs.getString(6), rs.getString(7), rs.getString(8),
					rs.getString(9));
			serviceList.add(services);

		}

		return serviceList;
	}

	public Service getService(String vendorId, String serviceid) throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"select sr_vendor_id,sr_user_id,sr_id,sr_service_name,sr_price,sr_category,sr_status,sr_time,sr_contactDetails from share_economy_service_details where sr_id=? and sr_vendor_id=?");
		ps.setString(1, serviceid);
		ps.setString(2, vendorId);
		ResultSet rs = ps.executeQuery();
		Service p = null;
		while (rs.next()) {
			p = new Service(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					Float.parseFloat(rs.getString(5)), rs.getString(6), rs.getString(7), rs.getString(8),
					rs.getString(9));

		}
		return p;
	}

	public void editService(Service service) throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"update share_economy_service_details set sr_id=?,sr_service_name=?,sr_price=?,sr_category=?,sr_status=?,sr_time=?,sr_contactDetails=? where sr_id=?");

		ps.setString(1, service.getServiceid());
		ps.setString(2, service.getServicename());
		ps.setFloat(3, service.getPrice());
		ps.setString(4, service.getCategory());
		ps.setString(5, service.getStatus());
		ps.setString(6, service.getTime());
		ps.setString(7, service.getContact());
		ps.setString(8, service.getServiceid());
		ps.executeUpdate();
		con.close();
	}

	public void deleteService(Service service) throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement("delete from share_economy_service_details where sr_id=?");
		ps.setString(1, service.getServiceid());
		ps.executeUpdate();
		con.close();
	}

	@Override
	public Vendor getVendor(String vendorid) throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from share_economy_vendor_details where ve_vendor_id=?");
		ps.setString(1, vendorid);
		ResultSet rs = ps.executeQuery();
		Vendor vendor = null;
		while (rs.next()) {
			vendor = new Vendor(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getLong(5),
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));

		}
		System.out.println("hi sakshi");
		return vendor;

	}

	@Override
	public void editVendor(Vendor vendor) throws Exception {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"update share_economy_vendor_details set ve_first_name=?,ve_last_name=?,ve_age=?,ve_gender=?,"
						+ "ve_contact_number=?,ve_vendor_id=?,ve_address=?,ve_city=?,ve_zip_code=?,ve_email=? where ve_vendor_id=?");
		ps.setString(1, vendor.getFirstName());
		ps.setString(2, vendor.getLastName());
		ps.setInt(3, vendor.getAge());
		ps.setString(4, vendor.getGender());
		ps.setLong(5, vendor.getContactNumber());
		ps.setString(6, vendor.getVendorId());
		ps.setString(7, vendor.getAddress());
		ps.setString(8, vendor.getZip());
		ps.setString(9, vendor.getCity());
		ps.setString(10, vendor.getEmail());
		ps.setString(11, vendor.getVendorId());
		ps.executeUpdate();
		System.out.println("hi");

	}
}
