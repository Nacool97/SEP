package com.cognizant.sharingeconomy.servlet;

import java.io.IOException;
import java.util.Locale.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.sharingeconomy.dao.UserDao;
import com.cognizant.sharingeconomy.dao.UserDaoSqlImpl;

@WebServlet("/RemoveCartProduct")
public class RemoveCartProductServlet extends UserBaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isValidSession(request, response)) {
			HttpSession session = request.getSession(false);
			String userid = (String) session.getAttribute("userid");
			String productid = request.getParameter("productId");

			try {
				UserDao u = new UserDaoSqlImpl();
				u.removeCartProduct(userid, productid);
				request.setAttribute("removeCartStatus", true);
				request.setAttribute("total", u.getTotal(userid));
				request.setAttribute("product", u.getCartProducts(userid));
				request.getRequestDispatcher("cart.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("home.jsp");

		}
	}

}
