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

@WebServlet("/RemoveCartService")
public class RemoveCartServiceServlet extends UserBaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isValidSession(request, response)) {
			HttpSession session = request.getSession(false);
			String userid = (String) session.getAttribute("userid");
			String serviceid = request.getParameter("serviceId");

			try {
				UserDao u = new UserDaoSqlImpl();
				u.removeCartService(userid, serviceid);
				request.setAttribute("removeCartStatus", true);
				request.setAttribute("total", u.getServiceTotal(userid));
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
