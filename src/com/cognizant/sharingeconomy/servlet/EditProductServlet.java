package com.cognizant.sharingeconomy.servlet;

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

@WebServlet("/EditProduct")
public class EditProductServlet extends BaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isValidSession(request, response)) {
			VendorDao vd = new VendorDaoSqlImpl();
			HttpSession hs = request.getSession(false);
			String vendorId = (String) hs.getAttribute("vendorid");
			// System.out.println(vendorId);
			String productId = request.getParameter("productId");

			try {
				Product product = vd.getProduct(vendorId, productId);
				request.setAttribute("categoryList", vd.getCategoryVendor());
				request.setAttribute("product", product);

			} catch (Exception e) {

				e.printStackTrace();
			}
			request.getRequestDispatcher("edit_product.jsp").forward(request, response);
		} else {
			response.sendRedirect("home.jsp");
		}
	}

}
