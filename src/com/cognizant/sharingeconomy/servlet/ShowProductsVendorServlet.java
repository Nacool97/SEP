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

@WebServlet("/ShowProductsVendor")
public class ShowProductsVendorServlet extends BaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (isValidSession(request, response)) {
			VendorDao vsi = new VendorDaoSqlImpl();
			try {

				HttpSession session = request.getSession(false);
				String vid = (String) session.getAttribute("vendorid");
				request.setAttribute("productList", vsi.getProductVendor(vid));
				System.out.println(vid);
				request.getRequestDispatcher("product_home.jsp").include(request, response);
			} catch (NoProductException e) {
				request.getRequestDispatcher("empty_product.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		} else {
			response.sendRedirect("home.jsp");
		}

	}

}
