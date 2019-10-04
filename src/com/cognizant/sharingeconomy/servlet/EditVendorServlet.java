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

@WebServlet("/EditVendor")
public class EditVendorServlet extends BaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isValidSession(request, response)) {
			HttpSession session = request.getSession(false);
			String vendorid = (String) session.getAttribute("vendorid");
			VendorDao vd = new VendorDaoSqlImpl();
			Vendor vendor;
			try {
				vendor = vd.getVendor(vendorid);
				System.out.println(vendor);
				request.setAttribute("vendor", vendor);
				request.getRequestDispatcher("edit_vendor.jsp").forward(request, response);
				;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("home.jsp");
		}

	}

}
