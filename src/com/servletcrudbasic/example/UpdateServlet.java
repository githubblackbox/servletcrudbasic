package com.servletcrudbasic.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a=request.getParameter("uname");
		String c= request.getParameter("fname");
		String b=request.getParameter("pword");
		System.out.println(a+"-->"+b+"---->"+c);
		DBConnection db = new DBConnection();
		int count=db.updateName(a, b, c);
		if(count>0){
			request.setAttribute("success", "Name updated");
			RequestDispatcher rd =request.getRequestDispatcher("Welcome.jsp");
			rd.forward(request, response);
		}else{
			request.setAttribute("failure", " Name not Upadted");
			RequestDispatcher rd =request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
			
		}

	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
