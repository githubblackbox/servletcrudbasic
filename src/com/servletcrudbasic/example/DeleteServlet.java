package com.servletcrudbasic.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a=request.getParameter("uname");
		String b=request.getParameter("pword");
		DBConnection db = new DBConnection();
		int i = db.deleteName(a, b);
		if(i>0){
			request.setAttribute("success", i+"id deleted");
			RequestDispatcher rd =request.getRequestDispatcher("Welcome.jsp");
			rd.forward(request, response);
		}else{
			request.setAttribute("failure", "id  not deleted");
			RequestDispatcher rd =request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
			
		}

		
		}

}
