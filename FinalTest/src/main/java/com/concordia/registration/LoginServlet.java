package com.concordia.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.concordia.entity.UserAccount;
import com.concordia.repository.UserAccountRepository;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserAccountRepository useraccountrep = new UserAccountRepository();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		//PrintWriter prt = response.getWriter();
		UserAccount useraccount = new UserAccount();
		useraccount.setUsername(username);
		useraccount.setPassword(password);
		try { 
			if (useraccountrep.validate(useraccount)) {
				session.setAttribute("name", username);
				dispatcher = request.getRequestDispatcher("index.jsp");
			}else {
				request.setAttribute("status", "failed"); 
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
