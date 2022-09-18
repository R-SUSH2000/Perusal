package com.suyash.Servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class f1Servlet extends HttpServlet{
	 public void service(HttpServletRequest rs,HttpServletResponse re) throws IOException
	 {
		 int a=Integer.parseInt(rs.getParameter("num1"));
		 int b=Integer.parseInt(rs.getParameter("num2"));
		  
	 }
	 
	
}
