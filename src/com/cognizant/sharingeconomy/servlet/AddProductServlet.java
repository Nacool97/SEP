package com.cognizant.sharingeconomy.servlet;

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

@WebServlet("/AddProduct")
public class AddProductServlet extends BaseServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
		if (isValidSession(request, response)) {
			VendorDao vdsi = new VendorDaoSqlImpl();
			HttpSession session = request.getSession(false);
			String vendorId = (String) session.getAttribute("vendorid");
			System.out.println("sakshi");
			System.out.println(vendorId);

			try {
				Product product = new Product(vendorId, request.getParameter("pid"), request.getParameter("pname"),
						request.getParameter("category"), Double.parseDouble(request.getParameter("price")),
						Double.parseDouble(request.getParameter("stock")));
				vdsi.addProduct(product);
				request.getRequestDispatcher("add_product_status.jsp").forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {
			response.sendRedirect("home.jsp");
		}
	}

}
