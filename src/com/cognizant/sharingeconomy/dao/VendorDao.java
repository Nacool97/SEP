package com.cognizant.sharingeconomy.dao;

import java.util.List;

import com.cognizant.sharingeconomy.model.Product;
import com.cognizant.sharingeconomy.model.Service;
import com.cognizant.sharingeconomy.model.Vendor;

public interface VendorDao {
	
	public void addVendor(Vendor vendor) throws Exception;

	public int vendorLoginDetails(Vendor vendor) throws Exception;

	public void addProduct(Product product) throws Exception;

	public void addCategory(String category) throws Exception;

	public List<String> getCategoryVendor() throws Exception;

	public List<Product> getProductVendor(String vendorid) throws Exception;

	public Product getProduct(String vendorId, String productId) throws Exception;

	public void editProduct(Product product) throws Exception;

	public void deleteProduct(Product product) throws Exception;

	public List<String> getCategoryServiceVendor() throws Exception;

	public void addService(Service service) throws Exception;

	public void addCategoryService(String category) throws Exception;

	public List<Service> getServiceVendor(String vendorid) throws Exception;

	public Service getService(String vendorId, String serviceid) throws Exception;

	public void editService(Service service) throws Exception;

	public void deleteService(Service service) throws Exception;

	public Vendor getVendor(String vendorid) throws Exception;

	public void editVendor(Vendor vendor) throws Exception;
}
