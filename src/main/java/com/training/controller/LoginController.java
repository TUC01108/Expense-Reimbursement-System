package com.training.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.ers.dao.LoginDAO;
import com.training.ers.dao.LoginDAOImpl;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		out.println("<html><body>");
		
		LoginDAO loginDAO = new LoginDAOImpl();
		
		boolean result = loginDAO.validate(username, password);
		
		if(result) {
			out.println("Welcome, "+username);
		} else {
			out.println("Your username/password is incorrect , please <a href=login.html>login</a> again.");
		}
		
		out.println("</body></html>");
	}

}
