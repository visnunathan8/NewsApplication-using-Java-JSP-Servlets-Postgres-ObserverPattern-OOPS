package com.concordia.dietapp.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.concordia.dietapp.entity.UserAccount;
import com.concordia.dietapp.repository.UserAccountRepository;

/**
 * Servlet implementation class UserAccountServlet
 */
@WebServlet("/UserAccount")
public class UserAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserAccountRepository useraccountrep = new UserAccountRepository();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		UserAccount useraccount = new UserAccount();
		useraccount.setUsername(username);
		useraccount.setPassword(password);
		PrintWriter output = response.getWriter();
		log("output text");
		output.println("Hello, World\\n"+useraccountrep.validate(useraccount));
		if (useraccountrep.validate(useraccount))
		{
			response.sendRedirect("loginsucess.jsp");
		}
		else 
		{
			//HttpSession session = request.getSession();
			response.sendRedirect("LoginPage.jsp");
			
		}
	}

}
