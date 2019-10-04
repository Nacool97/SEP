package com.cognizant.sharingeconomy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.sharingeconomy.dao.UserDao;
import com.cognizant.sharingeconomy.dao.UserDaoSqlImpl;
import com.cognizant.sharingeconomy.dao.VendorDao;
import com.cognizant.sharingeconomy.dao.VendorDaoSqlImpl;
import com.cognizant.sharingeconomy.model.User;
import com.cognizant.sharingeconomy.model.Vendor;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User(request.getParameter("uid"), request.getParameter("pass"));
		UserDao vdsi = new UserDaoSqlImpl();
		request.setAttribute("loginstatus", false);
		// HttpSession session = request.getSession();
		try {
			int result = vdsi.userLoginDetails(user);
			// session.setAttribute("vendorid", request.getParameter("vid"));
			if (result == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("userid", request.getParameter("uid"));
				request.getRequestDispatcher("user_home.jsp").forward(request, response);

			} else {
				request.setAttribute("loginstatus", true);
				request.getRequestDispatcher("user_login.jsp").forward(request, response);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
