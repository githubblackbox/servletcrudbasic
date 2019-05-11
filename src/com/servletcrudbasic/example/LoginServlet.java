package com.servletcrudbasic.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}					

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String a= req.getParameter("uname");
		String b= req.getParameter("pword");
		System.out.println(a+"--->"+b);
		DBConnection db = new DBConnection();
		String nme = db.getName(a,b);
		if(nme != null){
			req.setAttribute("success", nme);
			RequestDispatcher rd= req.getRequestDispatcher("Welcome.jsp");
			rd.forward(req, res);
		}else{  
			req.setAttribute("failure", "try again");
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.forward(req, res);
		}
	
        		
		
	}

}
