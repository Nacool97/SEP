package com.cognizant.sharingeconomy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.sharingeconomy.dao.VendorDao;
import com.cognizant.sharingeconomy.dao.VendorDaoSqlImpl;
import com.cognizant.sharingeconomy.model.Vendor;

@WebServlet("/EditVendorStatus")
public class EditVendorStatusServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isValidSession(request, response)) {
			Vendor vendor = new Vendor(request.getParameter("fname"), request.getParameter("lname"),
					Integer.parseInt(request.getParameter("age")), request.getParameter("gender"),
					Long.parseLong(request.getParameter("cno")), request.getParameter("vid"),
					request.getParameter("email"), request.getParameter("address"), request.getParameter("zip"),
					request.getParameter("city"));
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

}
