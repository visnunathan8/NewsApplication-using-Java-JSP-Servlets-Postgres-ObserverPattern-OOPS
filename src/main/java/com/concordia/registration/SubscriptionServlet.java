package com.concordia.registration;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import com.concordia.entity.Notifier;

/**
 * Servlet implementation class SubscriptionServlet
 */
@WebServlet("/subscription")
public class SubscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer subscriberId = Integer.valueOf(request.getParameter("publisherid"));
		String[] publisherIds = request.getParameterValues("username");
		Notifier notify = new Notifier(subscriberId);
		RequestDispatcher dispatcher = null;
		
		try {
			notify.removeObserver(subscriberId);
			for(int i=0;publisherIds!=null && i<publisherIds.length; i++) {
				notify.addObserver(subscriberId, Integer.valueOf(publisherIds[i]));
			}
			dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
