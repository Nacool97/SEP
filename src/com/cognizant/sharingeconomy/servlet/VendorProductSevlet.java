package com.cognizant.sharingeconomy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.sharingeconomy.dao.NoProductException;
import com.cognizant.sharingeconomy.dao.VendorDao;
import com.cognizant.sharingeconomy.dao.VendorDaoSqlImpl;
import com.cognizant.sharingeconomy.model.Product;

@WebServlet("/vendorproduct")
public class VendorProductSevlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			callAction(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {

			callAction(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void callAction(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// User user = getModel(request);
		String c = request.getParameter("actionName");

		switch (c) {
		case "add":
			System.out.println("add");
			addProduct(request, response);
			break;
		case "get":
			System.out.println("add");
			getProduct(request, response);
			break;
		case "edit":
			System.out.println("in Edit");
			editProduct(request, response);
			break;
		case "update":
			System.out.println("in update");
			updateProduct(request, response);
			break;
		case "delete":
			System.out.println("in Delete");
			deleteProduct(request, response);
			break;
		case "display":
			System.out.println("in Display");
			displayProduct(request, response);
			break;
		case "addcategory":
			System.out.println("In add Category");
			addCategory(request, response);
			break;
		default:
			System.out.println("Invalid choice");
			break;

		}
	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (isValidSession(request, response)) {

			VendorDao vdsi = new VendorDaoSqlImpl();
			HttpSession session = request.getSession(false);
			String vendorId = (String) session.getAttribute("vendorid");

			System.out.println(vendorId);
			System.out.println("Hello from combined servlet");

			try {
				Product product = getModel(request, response);
				vdsi.addProduct(product);
				request.getRequestDispatcher("add_product_status.jsp").forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {
			response.sendRedirect("home.jsp");
		}
	}

	private void editProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (isValidSession(request, response)) {
			VendorDao vd = new VendorDaoSqlImpl();
			HttpSession session = request.getSession(false);
			String vendorid = (String) session.getAttribute("vendorid");
			Product product = getModel(request, response);
			try {
				vd.editProduct(product);
				request.setAttribute("product", vd.getProductVendor(vendorid));
				/*
				 * Product p=(Product) vd.getProductVendor(vendorid);
				 * System.out.println(p);
				 */
				request.getRequestDispatcher("edit_product_status.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("home.jsp");
		}

	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (isValidSession(request, response)) {
			VendorDao vd = new VendorDaoSqlImpl();
			HttpSession hs = request.getSession(false);
			String vendorId = (String) hs.getAttribute("vendorid");
			// System.out.println(vendorId);
			String productId = request.getParameter("productId");

			try {
				Product product = vd.getProduct(vendorId, productId);
				request.setAttribute("categoryList", vd.getCategoryVendor());
				request.setAttribute("product", product);

			} catch (Exception e) {

				e.printStackTrace();
			}
			request.getRequestDispatcher("edit_product.jsp").forward(request, response);
		} else {
			response.sendRedirect("home.jsp");
		}

	}

	private void getProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (isValidSession(request, response)) {
			VendorDao vendorDao = new VendorDaoSqlImpl();

			try {
				request.setAttribute("categoryL", vendorDao.getCategoryVendor());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.getRequestDispatcher("addProduct.jsp").forward(request, response);

		} else {
			response.sendRedirect("home.jsp");
		}
	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (isValidSession(request, response)) {
			VendorDao vd = new VendorDaoSqlImpl();
			HttpSession session = request.getSession(false);
			String vendorId = (String) session.getAttribute("vendorid");
			String productId = (String) request.getParameter("productId");
			Product product;
			try {
				product = vd.getProduct(vendorId, productId);
				vd.deleteProduct(product);
				request.setAttribute("product", product);
				request.getRequestDispatcher("delete_status.jsp").include(request, response);

			} catch (NoProductException e) {
				request.getRequestDispatcher("empty_product.jsp").include(request, response);
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			response.sendRedirect("home.jsp");
		}
	}

	private void displayProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (isValidSession(request, response)) {
			VendorDao vsi = new VendorDaoSqlImpl();
			try {

				HttpSession session = request.getSession(false);
				String vid = (String) session.getAttribute("vendorid");
				request.setAttribute("productList", vsi.getProductVendor(vid));
				System.out.println(vid);
				request.getRequestDispatcher("product_home.jsp").include(request, response);
			} catch (NoProductException e) {
				request.getRequestDispatcher("empty_product.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		} else {
			response.sendRedirect("home.jsp");
		}
	}

	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (isValidSession(request, response)) {
			VendorDao vdsi = new VendorDaoSqlImpl();
			String category = request.getParameter("category");
			try {
				vdsi.addCategory(category);
				request.getRequestDispatcher("add_category_status.jsp").forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {
			response.sendRedirect("home.jsp");
		}

	}

	private Product getModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		String vendorId = (String) session.getAttribute("vendorid");
		Product product = new Product(vendorId, request.getParameter("pid"), request.getParameter("pname"),
				request.getParameter("category"), Double.parseDouble(request.getParameter("price")),
				Double.parseDouble(request.getParameter("stock")));
		return product;
	}

}
