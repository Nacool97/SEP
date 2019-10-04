package com.cognizant.sharingeconomy.service.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.sharingeconomy.dao.NoProductException;
import com.cognizant.sharingeconomy.dao.NoServiceException;
import com.cognizant.sharingeconomy.dao.VendorDao;
import com.cognizant.sharingeconomy.dao.VendorDaoSqlImpl;
import com.cognizant.sharingeconomy.servlet.BaseServlet;

@WebServlet("/ShowServiceVendor")
public class ShowServiceVendorServlet extends BaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
		if (isValidSession(request, response)) {
			VendorDao vsi = new VendorDaoSqlImpl();
			try {
				request.setAttribute("serviceList", vsi.getServiceVendor());
				HttpSession session = request.getSession(false);
				String vid = (String) session.getAttribute("vendorid");
				System.out.println(vid);
				request.getRequestDispatcher("service_home.jsp").forward(request, response);
			} catch (NoServiceException e) {
				request.getRequestDispatcher("empty_service.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("home.jsp");
		}

	}

}
