package com.cognizant.sharingeconomy.service.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import com.cognizant.sharingeconomy.dao.VendorDao;
import com.cognizant.sharingeconomy.dao.VendorDaoSqlImpl;
import com.cognizant.sharingeconomy.model.Product;
import com.cognizant.sharingeconomy.model.Service;
import com.cognizant.sharingeconomy.servlet.BaseServlet;

@WebServlet("/EditService")
public class EditServiceServlet extends BaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (isValidSession(request, response)) {
			VendorDao vd = new VendorDaoSqlImpl();
			HttpSession hs = request.getSession(false);
			String vendorId = (String) hs.getAttribute("vendorid");
			// System.out.println(vendorId);
			String serviceid = request.getParameter("serviceid");

			try {
				Service service = vd.getService(vendorId, serviceid);
				request.setAttribute("categoryList", vd.getCategoryServiceVendor());
				request.setAttribute("service", service);

			} catch (Exception e) {

				e.printStackTrace();
			}
			request.getRequestDispatcher("edit_service.jsp").forward(request, response);
		} else {
			response.sendRedirect("home.jsp");
		}

	}

}
