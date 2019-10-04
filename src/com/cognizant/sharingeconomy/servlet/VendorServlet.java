package com.cognizant.sharingeconomy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.sharingeconomy.dao.IdExistException;
import com.cognizant.sharingeconomy.dao.VendorDao;
import com.cognizant.sharingeconomy.dao.VendorDaoSqlImpl;
import com.cognizant.sharingeconomy.model.Vendor;

@WebServlet("/vendor")
public class VendorServlet extends BaseServlet {
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
		case "add":
			System.out.println("add");
			addVendor(request, response);
			break;
		case "get":
			System.out.println("get");
			getVendor(request, response);
			break;
		case "edit":
			System.out.println("edit");
			editVendor(request, response);
			break;
		case "login":
			System.out.println("login");
			loginVendor(request, response);
			break;
		case "logout":
			System.out.println("logout");
			logoutVendor(request, response);

		}

	}

	private void addVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("flag", false);
		Vendor vendor = getModel(request, response);

		VendorDao vdsi = new VendorDaoSqlImpl();
		System.out.println(vendor);

		try {
			vdsi.addVendor(vendor);
			request.getRequestDispatcher("vendorregistrationstatus.jsp").forward(request, response);
		} catch (IdExistException e) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

	private Vendor getModel(HttpServletRequest request, HttpServletResponse response) {
		Vendor vendor;
		boolean flag = (boolean) request.getAttribute("flag");
		if (flag == false) {
			vendor = new Vendor(request.getParameter("fname"), request.getParameter("lname"),
					Integer.parseInt(request.getParameter("age")), request.getParameter("gender"),
					Long.parseLong(request.getParameter("cno")), request.getParameter("eid"),
					request.getParameter("vid"), request.getParameter("pass"));
			return vendor;
		} else {
			vendor = new Vendor(request.getParameter("fname"), request.getParameter("lname"),
					Integer.parseInt(request.getParameter("age")), request.getParameter("gender"),
					Long.parseLong(request.getParameter("cno")), request.getParameter("vid"),
					request.getParameter("email"), request.getParameter("address"), request.getParameter("zip"),
					request.getParameter("city"));

		}
		return vendor;
	}

	private void getVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (isValidSession(request, response)) {

			HttpSession session = request.getSession(false);
			String vendorid = (String) session.getAttribute("vendorid");
			VendorDao vd = new VendorDaoSqlImpl();
			Vendor vendor;

			vendor = vd.getVendor(vendorid);
			System.out.println(vendor);
			request.setAttribute("vendor", vendor);
			request.getRequestDispatcher("edit_vendor.jsp").forward(request, response);

		} else {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}

	}

	private void editVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (isValidSession(request, response)) {
			request.setAttribute("flag", true);
			Vendor vendor = getModel(request, response);
			VendorDao vd = new VendorDaoSqlImpl();
			try {
				vd.editVendor(vendor);

				request.getRequestDispatcher("edit_vendor_status.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("home.jsp");
		}

	}

	private void loginVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Vendor vendor = new Vendor(request.getParameter("vid"), request.getParameter("pass"));
		VendorDao vdsi = new VendorDaoSqlImpl();
		request.setAttribute("loginstatus", false);
		// HttpSession session = request.getSession();
		try {
			int result = vdsi.vendorLoginDetails(vendor);
			// session.setAttribute("vendorid", request.getParameter?("vid"));
			if (result == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("vendorid", request.getParameter("vid"));
				request.getRequestDispatcher("vendor_home.jsp").forward(request, response);

			} else {
				request.setAttribute("loginstatus", true);
				request.getRequestDispatcher("vendor_login.jsp").forward(request, response);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void logoutVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);

		session.invalidate();
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
