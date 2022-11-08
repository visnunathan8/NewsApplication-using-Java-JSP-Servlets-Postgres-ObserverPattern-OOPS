package com.concordia.registration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.concordia.entity.Notifier;
import com.concordia.entity.Review;
import com.concordia.repository.ReviewRepository;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/review")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		Review reviewObj = new Review();
		reviewObj.setDisplay_title(request.getParameter("disptitle"));
		reviewObj.setHeadline(request.getParameter("headline"));
		reviewObj.setMpaa_rating(request.getParameter("mpaa"));
		reviewObj.setCritics_pick(Integer.valueOf(request.getParameter("critics")));
		reviewObj.setDate_updated(request.getParameter("dateupdated"));
		reviewObj.setByline(request.getParameter("byline"));
		reviewObj.setOpening_date(request.getParameter("openingdate"));
		reviewObj.setPublication_date(request.getParameter("publicationdate"));
		reviewObj.setSummary_short(request.getParameter("shortsummary"));
		Integer publisherId = Integer.valueOf(request.getParameter("publisherid"));
		Notifier notify = new Notifier(publisherId);
		notify.notifyObservers(publisherId, reviewObj);
		dispatcher = request.getRequestDispatcher("admin.jsp");
		dispatcher.forward(request, response);
	}

}
