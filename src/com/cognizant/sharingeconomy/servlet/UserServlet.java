package com.cognizant.sharingeconomy.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.cognizant.sharingeconomy.dao.IdExistException;
import com.cognizant.sharingeconomy.dao.UserDao;
import com.cognizant.sharingeconomy.dao.UserDaoSqlImpl;
import com.cognizant.sharingeconomy.dao.VendorDao;
import com.cognizant.sharingeconomy.dao.VendorDaoSqlImpl;
import com.cognizant.sharingeconomy.model.Service;
import com.cognizant.sharingeconomy.model.User;
import com.cognizant.sharingeconomy.model.Vendor;
@WebServlet("/user")
public class UserServlet extends BaseServlet {
HttpSession sess;
String page;
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			callAction(request, response);
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
			try {
				callAction(request, response);
				
			}catch (Exception e) {
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
			addUser(request, response);
			break;
		case "login":
			System.out.println("login");
			loginUser(request, response);
			break;
		case "logout":
			System.out.println("logout");
			logoutUser(request, response);
			break;
		}
	}
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
	UserDao udsi = new UserDaoSqlImpl();
	System.out.println("In user registration servlet");
	try {
			User user=getModel(request,response);
		udsi.addUser(user);
		System.out.println("In user registration servlet");
		request.getRequestDispatcher("userregistrationstatus.jsp").forward(request, response);

	} catch (IdExistException e) {
		response.sendRedirect("alreadyexist.jsp");
	} catch (Exception e) {

		e.printStackTrace();
	}
	}
	
	private void loginUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = new User(request.getParameter("uid"), request.getParameter("pass"));
		UserDao vdsi = new UserDaoSqlImpl();
		request.setAttribute("loginstatus", false);
		// HttpSession session = request.getSession();
		try {
			int result = vdsi.userLoginDetails(user);
			// session.setAttribute("vendorid", request.getParameter("vid"));
			if (result == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("userid", request.getParameter("uid"));
				request.getRequestDispatcher("user_home.jsp").forward(request, response);

			} else {
				request.setAttribute("loginstatus", true);
				request.getRequestDispatcher("user_login.jsp").forward(request, response);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	private User getModel(HttpServletRequest request, HttpServletResponse response)
	{
		User user = new User(request.getParameter("fname"), request.getParameter("lname"),
				Integer.parseInt(request.getParameter("age")), request.getParameter("gender"),
				Long.parseLong(request.getParameter("cno")), request.getParameter("email"), request.getParameter("uid"),
				request.getParameter("pass"));
		return user;
	}
	private void logoutUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		session.invalidate();
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	
		
}