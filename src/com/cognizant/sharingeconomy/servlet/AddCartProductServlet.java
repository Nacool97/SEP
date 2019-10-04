package com.cognizant.sharingeconomy.servlet;

import java.io.IOException;

import javax.print.DocFlavor.STRING;
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

@WebServlet("/AddCartProduct")
public class AddCartProductServlet extends UserBaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isValidSession(request, response)) {

			HttpSession session = request.getSession(false);
			String uid = (String) session.getAttribute("userid");
			UserDao usdi = new UserDaoSqlImpl();
			VendorDao vd = new VendorDaoSqlImpl();

			try {
				usdi.addCartProduct(uid, request.getParameter("productId"));
				// String category = (String)request.getParameter("category");
				// System.out.println(category);
				String category = (String) session.getAttribute("category");
				System.out.println(category);
				request.setAttribute("addCartStatus", true);
				request.setAttribute("categoryList", vd.getCategoryVendor());
				request.setAttribute("product", usdi.getProductByCategory(category));
				System.out.println(usdi.getProductByCategory(category));
				request.getRequestDispatcher("user_product_home.jsp").forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {

			response.sendRedirect("home.jsp");

		}
	}

}
