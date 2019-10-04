package com.cognizant.sharingeconomy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.sharingeconomy.dao.UserDao;
import com.cognizant.sharingeconomy.dao.UserDaoSqlImpl;
import com.cognizant.sharingeconomy.model.Product;
import com.cognizant.sharingeconomy.model.Service;

@WebServlet("/ShowCartService")
public class ShowCartServiceServlet extends UserBaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isValidSession(request, response)) {
			HttpSession session = request.getSession(false);
			String userid = (String) session.getAttribute("userid");
			System.out.println(userid);
			UserDao usdi = new UserDaoSqlImpl();
			List<Service> serviceList;

			try {
				serviceList = usdi.getCartServices(userid);
				System.out.println(serviceList);
				request.setAttribute("service", serviceList);
				request.setAttribute("total", usdi.getServiceTotal(userid));
				request.getRequestDispatcher("cart_service.jsp").forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			response.sendRedirect("home.jsp");
		}
	}

}
