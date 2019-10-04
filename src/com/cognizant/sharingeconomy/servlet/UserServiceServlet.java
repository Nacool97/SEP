package com.cognizant.sharingeconomy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.cognizant.sharingeconomy.model.Service;

@WebServlet("/userservice")
public class UserServiceServlet extends UserBaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			callAction(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			callAction(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private void callAction(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// User user = getModel(request);
		String c = request.getParameter("actionName");

		switch (c) {
		case "display":
			System.out.println("in display");
			displayService(request, response);
			break;
		case "search":
			System.out.println("search");
			searchService(request, response);
			break;
		case "add":
			System.out.println("in add");
			addCartService(request, response);
			break;
		case "displayCart":
			System.out.println("in display cart");
			displayCartService(request, response);
			break;
		case "delete":
			System.out.println("delete");
			deleteCartService(request, response);
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
	}

	private void searchService(HttpServletRequest request, HttpServletResponse response) {
		try {
			if (isValidSession(request, response)) {
				UserDao udsi = new UserDaoSqlImpl();
				String category = request.getParameter("category");
				System.out.println("rushikesh");
				HttpSession session=request.getSession(false);
				String userid=(String)session.getAttribute("userid");
				session.setAttribute("category", category);
				try {
					List<Service> serviceList = udsi.getServiceByCategory(category);
					request.setAttribute("service", serviceList);
					request.getRequestDispatcher("user_service_home.jsp").forward(request, response);

				} catch (Exception e) {

					e.printStackTrace();
				}
			} else {
				response.sendRedirect("home.jsp");
			}
		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}

	}

	private void displayService(HttpServletRequest request, HttpServletResponse response) {
		try {
			if (isValidSession(request, response)) {
				HttpSession session = request.getSession(false);
				String userId = (String) session.getAttribute("userid");
				VendorDao vdsi = new VendorDaoSqlImpl();
				UserDao usdi = new UserDaoSqlImpl();
				List<String> categoryList = new ArrayList<String>();
				try {
					request.setAttribute("categoryList", vdsi.getCategoryServiceVendor());
					request.getRequestDispatcher("user_service_home.jsp").forward(request, response);
				} catch (Exception e) {

					e.printStackTrace();
				}
			} else {
				response.sendRedirect("home.jsp");
			}
		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}

	}

	private void addCartService(HttpServletRequest request, HttpServletResponse response) {
		try {
			if (isValidSession(request, response)) {
				HttpSession session = request.getSession(false);
				String uid = (String) session.getAttribute("userid");
				UserDao usdi = new UserDaoSqlImpl();
				VendorDao vd = new VendorDaoSqlImpl();
				System.out.println("anagha");
				try {
					String category=(String)session.getAttribute("category");
					usdi.addCartService(uid, request.getParameter("serviceId"));
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
		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}

	}

	private void displayCartService(HttpServletRequest request, HttpServletResponse response) {

		try {
			if (isValidSession(request, response)) {
				HttpSession session = request.getSession(false);
				String userid = (String) session.getAttribute("userid");

				UserDao usdi = new UserDaoSqlImpl();
				List<Service> serviceList;

				System.out.println("prajakta");
				try {
					serviceList = usdi.getCartServices(userid);
					System.out.println(serviceList);
					request.setAttribute("service", serviceList);
					request.setAttribute("total", usdi.getServiceTotal(userid));
					request.getRequestDispatcher("cart_service.jsp").forward(request, response);

				} catch (Exception e) {

					e.printStackTrace();
				}

			} else {
				response.sendRedirect("home.jsp");
			}
		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}
	}

	private void deleteCartService(HttpServletRequest request, HttpServletResponse response) {

		try {
			if (isValidSession(request, response)) {
				HttpSession session = request.getSession(false);
				String userid = (String) session.getAttribute("userid");
				String serviceid = request.getParameter("serviceId");
				System.out.println("rap");
				try {
					UserDao u = new UserDaoSqlImpl();
					u.removeCartService(userid, serviceid);
					request.setAttribute("removeCartStatus", true);
					request.setAttribute("total", u.getServiceTotal(userid));
					request.setAttribute("service",u.getCartServices(userid));
					request.getRequestDispatcher("cart_service.jsp").forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {

				response.sendRedirect("home.jsp");

			}
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
