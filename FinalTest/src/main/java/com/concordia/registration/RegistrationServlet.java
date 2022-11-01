package com.concordia.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.concordia.entity.UserAccount;
import com.concordia.repository.UserAccountRepository;
 
/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserAccountRepository useraccountrep = new UserAccountRepository();
		String uname = request.getParameter("name");
		String upwd = request.getParameter("pass");
		String uemail = request.getParameter("email");
		String umobile = request.getParameter("contact");
		UserAccount useraccount = new UserAccount();
		useraccount.setUsername(uname);
		useraccount.setPassword(upwd);
		useraccount.setUserEmail(uemail);
		useraccount.setUserMobile(umobile);
		RequestDispatcher dispatcher = null;
		Connection con = null;
		try {
			boolean status = useraccountrep.insertToDatabase(useraccount);
			dispatcher = request.getRequestDispatcher("registration.jsp");
			if(status) {
				request.setAttribute("status", "success");
			}else {
				request.setAttribute("status", "failed");
			}
			dispatcher.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
