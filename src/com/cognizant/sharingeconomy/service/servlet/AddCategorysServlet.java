package com.cognizant.sharingeconomy.service.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.sharingeconomy.dao.VendorDao;
import com.cognizant.sharingeconomy.dao.VendorDaoSqlImpl;
import com.cognizant.sharingeconomy.servlet.BaseServlet;

@WebServlet("/AddCategorys")
public class AddCategorysServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isValidSession(request, response)) {
			VendorDao vendorDao = new VendorDaoSqlImpl();

			try {
				request.setAttribute("categoryL", vendorDao.getCategoryServiceVendor());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.getRequestDispatcher("add_service.jsp").forward(request, response);

		}

		else {
			response.sendRedirect("home.jsp");
		}
	}

}
