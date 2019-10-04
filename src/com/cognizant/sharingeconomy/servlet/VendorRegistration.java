package com.cognizant.sharingeconomy.servlet;

import java.io.IOException;
import com.cognizant.sharingeconomy.util.ConnectionHandler;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Request;

import com.cognizant.sharingeconomy.dao.IdExistException;
import com.cognizant.sharingeconomy.dao.VendorDao;
import com.cognizant.sharingeconomy.dao.VendorDaoSqlImpl;
import com.cognizant.sharingeconomy.model.Vendor;

@WebServlet("/VendorRegistration")
public class VendorRegistration extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Vendor vendor = new Vendor(request.getParameter("fname"), request.getParameter("lname"),
				Integer.parseInt(request.getParameter("age")), request.getParameter("gender"),
				Long.parseLong(request.getParameter("cno")), request.getParameter("eid"), request.getParameter("vid"),
				request.getParameter("pass"));
		String password=request.getParameter("pass");
			VendorDao vdsi = new VendorDaoSqlImpl();
			System.out.println(vendor);

		try {
			vdsi.addVendor(vendor);
			request.getRequestDispatcher("vendorregistrationstatus.jsp").forward(request, response);
		} catch (IdExistException e) {
			response.sendRedirect("alreadyexist.jsp");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
