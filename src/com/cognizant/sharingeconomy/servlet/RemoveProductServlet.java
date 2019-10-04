package com.cognizant.sharingeconomy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.sharingeconomy.dao.NoProductException;
import com.cognizant.sharingeconomy.dao.VendorDao;
import com.cognizant.sharingeconomy.dao.VendorDaoSqlImpl;
import com.cognizant.sharingeconomy.model.Product;

@WebServlet("/RemoveProduct")
public class RemoveProductServlet extends BaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isValidSession(request, response)) {
			VendorDao vd = new VendorDaoSqlImpl();
			HttpSession session = request.getSession(false);
			String vendorId = (String) session.getAttribute("vendorid");
			String productId = (String) request.getParameter("productId");
			Product product;
			try {
				product = vd.getProduct(vendorId, productId);
				vd.deleteProduct(product);
				request.setAttribute("product", product);
				request.getRequestDispatcher("delete_status.jsp").include(request, response);

			} catch (NoProductException e) {
				request.getRequestDispatcher("empty_product.jsp").include(request, response);
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			response.sendRedirect("home.jsp");
		}

	}

}
