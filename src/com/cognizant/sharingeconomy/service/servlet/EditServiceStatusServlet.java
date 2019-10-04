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
import com.cognizant.sharingeconomy.model.Product;
import com.cognizant.sharingeconomy.model.Service;
import com.cognizant.sharingeconomy.servlet.BaseServlet;

@WebServlet("/EditServiceStatus")
public class EditServiceStatusServlet extends BaseServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isValidSession(request, response)) {
			VendorDao vd = new VendorDaoSqlImpl();
			HttpSession session = request.getSession(false);
			String vendorId = (String) session.getAttribute("vendorid");
			System.out.println("sakshi");
			System.out.println(vendorId);
			try {
				Service service = new Service(vendorId, request.getParameter("sid"), request.getParameter("sname"),
						Float.parseFloat(request.getParameter("sprice")), request.getParameter("scategory"),
						request.getParameter("sstatus"), request.getParameter("stime"),
						request.getParameter("scontact"));
				vd.editService(service);
				request.setAttribute("service", vd.getServiceVendor());
				request.getRequestDispatcher("edit_service_status.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("home.jsp");
		}

	}

}
