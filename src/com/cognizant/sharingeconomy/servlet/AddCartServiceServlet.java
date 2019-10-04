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

@WebServlet("/AddCartService")
public class AddCartServiceServlet extends UserBaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isValidSession(request, response)) {
			HttpSession session = request.getSession(false);
			String uid = (String) session.getAttribute("userid");
			UserDao usdi = new UserDaoSqlImpl();
			VendorDao vd = new VendorDaoSqlImpl();

			try {
				usdi.addCartService(uid, request.getParameter("serviceId"));
				String category = request.getParameter("category");
				request.setAttribute("addCartStatus", true);
				request.setAttribute("categoryList", vd.getCategoryServiceVendor());
				request.setAttribute("service", usdi.getServiceByCategory(category));
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
