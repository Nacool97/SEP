package com.cognizant.sharingeconomy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.sharingeconomy.dao.NoServiceException;
import com.cognizant.sharingeconomy.dao.VendorDao;
import com.cognizant.sharingeconomy.dao.VendorDaoSqlImpl;
import com.cognizant.sharingeconomy.model.Product;
import com.cognizant.sharingeconomy.model.Service;
import com.cognizant.sharingeconomy.model.Vendor;

@WebServlet("/vendorservice")
public class VendorServiceServlet extends BaseServlet {
	HttpSession sess;
	String page;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			callAction(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			callAction(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void callAction(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String c = request.getParameter("actionName");
		System.out.println(c);

		switch (c) {
		case "add":
			System.out.println("add");
			addServiceVendor(request, response);
			break;
		case "get":
			System.out.println("get");
			getServiceVendor(request, response);
			break;
		case "edit":
			System.out.println("edit");
			editServiceVendor(request, response);
			break;
		case "update":
			System.out.println("updae");
			updateServiceVendor(request, response);
			break;
		case "delete":
			System.out.println("delete");
			deleteServiceVendor(request, response);
			break;
		case "addcategory":
			System.out.println("add");
			addServiceCategoryVendor(request, response);
			break;
		case "display":
			System.out.println("display");
			displayServiceVendor(request, response);
		}
	}

	private void getServiceVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {

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

	private Service getModel(HttpServletRequest request, HttpServletResponse response) {
		Service service;
		HttpSession session = request.getSession(false);
		String vendorId = (String) session.getAttribute("vendorid");
		service = new Service(vendorId, request.getParameter("sid"), request.getParameter("sname"),
				Float.parseFloat(request.getParameter("sprice")), request.getParameter("scategory"),
				request.getParameter("sstatus"), request.getParameter("stime"), request.getParameter("scontact"));
		return service;
	}

	private void addServiceVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (isValidSession(request, response)) {
			VendorDao vdsi = new VendorDaoSqlImpl();
			HttpSession session = request.getSession(false);
			String vendorId = (String) session.getAttribute("vendorid");
			System.out.println("sakshi");
			System.out.println(vendorId);
			try {
				/*
				 * Service service = new Service(vendorId,
				 * request.getParameter("sid"), request.getParameter("sname"),
				 * Float.parseFloat(request.getParameter("sprice")),
				 * request.getParameter("scategory"),
				 * request.getParameter("sstatus"),
				 * request.getParameter("stime"),
				 * request.getParameter("scontact"));
				 */
				Service service = getModel(request, response);
				vdsi.addService(service);
				request.getRequestDispatcher("add_service_status.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("home.jsp");
		}
	}

	private void updateServiceVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
				request.getRequestDispatcher("edit_service.jsp").forward(request, response);

			} catch (Exception e) {

				e.printStackTrace();
			}

		} else {
			response.sendRedirect("home.jsp");
		}
	}

	private void editServiceVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (isValidSession(request, response)) {
			VendorDao vd = new VendorDaoSqlImpl();
			HttpSession session = request.getSession(false);
			String vendorId = (String) session.getAttribute("vendorid");
			System.out.println("sakshi");
			System.out.println(vendorId);
			try {
				Service service = getModel(request, response);
				/*
				 * Service service = new Service(vendorId,
				 * request.getParameter("sid"), request.getParameter("sname"),
				 * Float.parseFloat(request.getParameter("sprice")),
				 * request.getParameter("scategory"),
				 * request.getParameter("sstatus"),
				 * request.getParameter("stime"),
				 * request.getParameter("scontact"));
				 */
				System.out.println(service);
				vd.editService(service);
				request.setAttribute("service", vd.getServiceVendor(vendorId));
				request.getRequestDispatcher("edit_service_status.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("home.jsp");
		}
	}

	private void deleteServiceVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (isValidSession(request, response)) {
			VendorDao vd = new VendorDaoSqlImpl();
			HttpSession session = request.getSession(false);
			String vendorId = (String) session.getAttribute("vendorid");
			String serviceid = (String) request.getParameter("serviceid");
			Service service;
			try {
				service = vd.getService(vendorId, serviceid);
				vd.deleteService(service);
				request.setAttribute("service", service);
				request.getRequestDispatcher("delete_service_status.jsp").forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("home.jsp");
		}
	}

	private void addServiceCategoryVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (isValidSession(request, response)) {
			VendorDao vdsi = new VendorDaoSqlImpl();
			String category = request.getParameter("category");
			try {
				vdsi.addCategoryService(category);
				System.out.println("ggiuiyio");
				request.getRequestDispatcher("add_categoryservice_status.jsp").forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {
			response.sendRedirect("home.jsp");
		}
	}

	private void displayServiceVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (isValidSession(request, response)) {
			VendorDao vsi = new VendorDaoSqlImpl();
			try {
				HttpSession session = request.getSession(false);
				String vid = (String) session.getAttribute("vendorid");
				request.setAttribute("serviceList", vsi.getServiceVendor(vid));
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
