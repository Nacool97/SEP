package com.cognizant.sharingeconomy.service.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.sharingeconomy.dao.VendorDao;
import com.cognizant.sharingeconomy.dao.VendorDaoSqlImpl;
import com.cognizant.sharingeconomy.servlet.BaseServlet;

@WebServlet("/AddCategoryService")
public class AddCategoryServiceServlet extends BaseServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isValidSession(request, response)) {
			VendorDao vdsi = new VendorDaoSqlImpl();
			String category = request.getParameter("category");
			try {
				vdsi.addCategoryService(category);
				request.getRequestDispatcher("add_categoryservice_status.jsp").forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {
			response.sendRedirect("home.jsp");
		}

	}

}
