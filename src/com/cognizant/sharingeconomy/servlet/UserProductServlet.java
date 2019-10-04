package com.cognizant.sharingeconomy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.sharingeconomy.dao.NoServiceException;
import com.cognizant.sharingeconomy.dao.UserDao;
import com.cognizant.sharingeconomy.dao.UserDaoSqlImpl;
import com.cognizant.sharingeconomy.dao.VendorDao;
import com.cognizant.sharingeconomy.dao.VendorDaoSqlImpl;
import com.cognizant.sharingeconomy.model.Product;
import com.cognizant.sharingeconomy.model.Service;
import com.cognizant.sharingeconomy.model.Vendor;

@WebServlet("/userproduct")
public class UserProductServlet extends UserBaseServlet {
	HttpSession sess;
	String page;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			callAction(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			callAction(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void callAction(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String c = request.getParameter("actionName");
		System.out.println(c);

		switch (c) {
		case "display":
			System.out.println("display");
			displayProduct(request, response);
			break;
		case "search":
			System.out.println("search");
			searchProduct(request, response);
			break;
		case "addcart":
			System.out.println("addcart");
			addcartProduct(request, response);
			break;
		case "delete":
			System.out.println("delete");
			deletecartProduct(request, response);
			break;
		case "displaycart":
			System.out.println("displaycart");
			displayCart(request, response);
			break;
			
		}
	}
	private void displayProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (isValidSession(request, response)) {
			HttpSession session = request.getSession(false);
			String userId = (String) session.getAttribute("userid");
			VendorDao vdsi = new VendorDaoSqlImpl();
			UserDao usdi = new UserDaoSqlImpl();
			List<String> categoryList = new ArrayList<String>();

			try {
				request.setAttribute("categoryList", vdsi.getCategoryVendor());
				request.getRequestDispatcher("user_product_home.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			response.sendRedirect("home.jsp");
		}
	}
	private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (isValidSession(request, response)) {
			HttpSession session = request.getSession(false);
			String userid = (String) session.getAttribute("userid");
			UserDao udsi = new UserDaoSqlImpl();
			VendorDao vd = new VendorDaoSqlImpl();
			String category = request.getParameter("category");
			session.setAttribute("category", category);
			try {
				List<Product> productList = udsi.getProductByCategory(category);
				request.setAttribute("product", productList);
				request.setAttribute("categoryList", vd.getCategoryVendor());
				request.getRequestDispatcher("user_product_home.jsp").forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			response.sendRedirect("home.jsp");
		}

	}
	private void addcartProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (isValidSession(request, response)) {

			HttpSession session = request.getSession(false);
			String uid = (String) session.getAttribute("userid");
			UserDao usdi = new UserDaoSqlImpl();
			VendorDao vd = new VendorDaoSqlImpl();

			try {
				usdi.addCartProduct(uid, request.getParameter("productId"));
				// String category = (String)request.getParameter("category");
				// System.out.println(category);
				String category = (String) session.getAttribute("category");
				System.out.println(category);
				request.setAttribute("addCartStatus", true);
				request.setAttribute("categoryList", vd.getCategoryVendor());
				request.setAttribute("product", usdi.getProductByCategory(category));
				System.out.println(usdi.getProductByCategory(category));
				request.getRequestDispatcher("user_product_home.jsp").forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {

			response.sendRedirect("home.jsp");

		}
	}
	private void deletecartProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (isValidSession(request, response)) {
			HttpSession session = request.getSession(false);
			String userid = (String) session.getAttribute("userid");
			String productid = request.getParameter("productId");

			try {
				UserDao u = new UserDaoSqlImpl();
				u.removeCartProduct(userid, productid);
				request.setAttribute("removeCartStatus", true);
				request.setAttribute("total", u.getTotal(userid));
				request.setAttribute("product", u.getCartProducts(userid));
				request.getRequestDispatcher("cart.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("home.jsp");

		}
	}
	private void displayCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		String userid = (String) session.getAttribute("userid");
		System.out.println(userid);
		UserDao usdi = new UserDaoSqlImpl();
		List<Product> productList;
		if (isValidSession(request, response)) {
			try {
				productList = usdi.getCartProducts(userid);
				System.out.println(productList);
				request.setAttribute("product", productList);
				request.setAttribute("total", usdi.getTotal(userid));
				request.getRequestDispatcher("cart.jsp").forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("home.jsp");
		}
	}
		}
