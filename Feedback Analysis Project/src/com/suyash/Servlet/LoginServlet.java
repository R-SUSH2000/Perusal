package com.suyash.Servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dbservice.UserDBService;
import com.feedback.DAO.User;
import com.feedback.DAO.Userfeedback;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailID = request.getParameter("emailID");
		String pass= request.getParameter("pass");
		User u1= new User(emailID,pass); 
		UserDBService userDBService=new UserDBService();
		//boolean flag = false;
		//flag=userDBService.verifyUser(u1); 
		boolean found = userDBService.verifyUser(u1);	
		String role="" ;
		if (found) {
			role = userDBService.getRole(u1);
		}
		System.out.println(role);
		if(role.equals("a")) {
			UserDBService userdbservice= new UserDBService();
			ArrayList<User> pList = userdbservice.selectAllFromPerson();
			request.setAttribute("pListf", pList);
			RequestDispatcher requestDispatcher= request.getRequestDispatcher("welcomeAdmin.jsp");
			requestDispatcher.forward(request, response);
		}else if (role.equals("u"))
		{
			UserDBService userdbservice= new UserDBService();
			ArrayList<Userfeedback> feedbackList = userdbservice.selectAllFromUserfeedback();
			RequestDispatcher requestDispatcher= request.getRequestDispatcher("Ufeedback.jsp?emailID="+u1.getEmailID());
			request.getSession().setAttribute("u1",u1);
			requestDispatcher.forward(request, response);
		} else if (role.equals(""))
		{
			RequestDispatcher requestDispatcher= request.getRequestDispatcher("Login.jsp");
			requestDispatcher.forward(request, response);
		
		}
		try {
		userDBService.getConnection().close();
		}
		catch (Exception e) {}
		
		
	}
}