package com.suyash.Servlet;
import com.dbservice.UserDBService;
import com.feedback.DAO.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/UserFeedbackServlet")
public class UserFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User u1=(User)session.getAttribute("u1"); 
		System.out.println(u1.getEmailID()); 
		String gender = request.getParameter("gender");
		String amount = request.getParameter("amount");
		String userInterface = request.getParameter("userInterface");
		String issuesolution = request.getParameter("issuesolution");
		String suggestion = request.getParameter("suggestion");
		Userfeedback userFeedback= new Userfeedback(gender,amount,userInterface,issuesolution,suggestion,u1.getEmailID());
		UserDBService dbservice=new UserDBService();
		System.out.println("dbservice obj created");
		int updateRec = dbservice.newUFeedback(userFeedback);	
		if (updateRec!=0) {
			System.out.println("insert successful");
			RequestDispatcher requestDispatcher= request.getRequestDispatcher("FeedbackStatus.jsp");
			requestDispatcher.forward(request, response);
			}
		else
		{
			System.out.println("insert Failed");}
		}
}