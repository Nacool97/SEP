package com.cognizant.sharingeconomy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.sharingeconomy.dao.VendorDao;
import com.cognizant.sharingeconomy.dao.VendorDaoSqlImpl;
import com.cognizant.sharingeconomy.model.Vendor;

@WebServlet("/VendorLogin")
public class VendorLogin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Vendor vendor = new Vendor(request.getParameter("vid"), request.getParameter("pass"));
		VendorDao vdsi = new VendorDaoSqlImpl();
		request.setAttribute("loginstatus", false);
		// HttpSession session = request.getSession();
		try {
			int result = vdsi.vendorLoginDetails(vendor);
			// session.setAttribute("vendorid", request.getParameter("vid"));
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

}
