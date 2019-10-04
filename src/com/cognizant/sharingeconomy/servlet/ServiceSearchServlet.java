package com.cognizant.sharingeconomy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.sharingeconomy.dao.UserDao;
import com.cognizant.sharingeconomy.dao.UserDaoSqlImpl;
import com.cognizant.sharingeconomy.model.Product;
import com.cognizant.sharingeconomy.model.Service;

/**
 * Servlet implementation class ProductSearchServlet
 */
@WebServlet("/ServiceSearch")
public class ServiceSearchServlet extends UserBaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isValidSession(request, response)) {
			UserDao udsi = new UserDaoSqlImpl();
			String category = request.getParameter("category");

			try {
				List<Service> serviceList = udsi.getServiceByCategory(category);
				request.setAttribute("service", serviceList);
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
