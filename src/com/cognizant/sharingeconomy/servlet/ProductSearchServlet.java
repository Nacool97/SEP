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
import com.cognizant.sharingeconomy.dao.VendorDao;
import com.cognizant.sharingeconomy.dao.VendorDaoSqlImpl;
import com.cognizant.sharingeconomy.model.Product;

@WebServlet("/ProductSearch")
public class ProductSearchServlet extends UserBaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isValidSession(request, response)) {
			HttpSession session = request.getSession(false);
			String userid = (String) session.getAttribute("userid");
			UserDao udsi = new UserDaoSqlImpl();
			VendorDao vd = new VendorDaoSqlImpl();
			String category = request.getParameter("category");
			session.setAttribute("category", category);
			try {
				List<Product> productList = udsi.getProductByCategory(category);
				request.setAttribute("product", productList);
				request.setAttribute("categoryList", vd.getCategoryVendor());
				request.getRequestDispatcher("user_product_home.jsp").forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			response.sendRedirect("home.jsp");
		}

	}

}
