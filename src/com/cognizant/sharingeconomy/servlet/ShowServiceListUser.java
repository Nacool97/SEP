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

import com.cognizant.sharingeconomy.dao.UserDao;
import com.cognizant.sharingeconomy.dao.UserDaoSqlImpl;
import com.cognizant.sharingeconomy.dao.VendorDao;
import com.cognizant.sharingeconomy.dao.VendorDaoSqlImpl;

@WebServlet("/ShowServiceListUser")
public class ShowServiceListUser extends UserBaseServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isValidSession(request, response)) {
			HttpSession session = request.getSession(false);
			String userId = (String) session.getAttribute("userid");
			VendorDao vdsi = new VendorDaoSqlImpl();
			UserDao usdi = new UserDaoSqlImpl();
			List<String> categoryList = new ArrayList<String>();
			try {
				request.setAttribute("categoryList", vdsi.getCategoryServiceVendor());
				request.getRequestDispatcher("user_service_home.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("home.jsp");
		}
	}

}
