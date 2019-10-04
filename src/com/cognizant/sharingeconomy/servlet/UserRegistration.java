package com.cognizant.sharingeconomy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.sharingeconomy.dao.IdExistException;
import com.cognizant.sharingeconomy.dao.UserDao;
import com.cognizant.sharingeconomy.dao.UserDaoSqlImpl;
import com.cognizant.sharingeconomy.dao.VendorDao;
import com.cognizant.sharingeconomy.dao.VendorDaoSqlImpl;
import com.cognizant.sharingeconomy.model.User;
import com.cognizant.sharingeconomy.model.Vendor;

@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {

		User user = new User(request.getParameter("fname"), request.getParameter("lname"),
				Integer.parseInt(request.getParameter("age")), request.getParameter("gender"),
				Long.parseLong(request.getParameter("cno")), request.getParameter("email"), request.getParameter("uid"),
				request.getParameter("pass"));
		UserDao udsi = new UserDaoSqlImpl();
		System.out.println("In user registration servlet");
		try {

			udsi.addUser(user);
			System.out.println("In user registration servlet");
			request.getRequestDispatcher("userregistrationstatus.jsp").forward(request, response);

		} catch (IdExistException e) {
			response.sendRedirect("alreadyexist.jsp");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
