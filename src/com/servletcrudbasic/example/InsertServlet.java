 package com.servletcrudbasic.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String a = request.getParameter("uname");
		String b = request.getParameter("pword");
		String c = request.getParameter("fname");
		DBConnection db = new DBConnection();
		int count=db.InsertName(a, b, c);
		if(count>0){
			request.setAttribute("success", "successfully Inserted");
			RequestDispatcher rd =request.getRequestDispatcher("Welcome.jsp");
			rd.forward(request, response);
		}else{
			request.setAttribute("failure","not inserted");
			RequestDispatcher rd =request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
			
		}

			
		}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
