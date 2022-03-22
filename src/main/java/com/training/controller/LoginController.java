package com.training.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.ers.dao.EmployeeDAO;
import com.training.ers.dao.EmployeeDAOImpl;
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
		
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		
		out.println("<html><body>");
		
		LoginDAO loginDAO = new LoginDAOImpl();
		
		boolean result = loginDAO.validate(username, password);
		
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		boolean typeNum = employeeDAO.typeIs(username,password);
		
		if(result) {
			session.setAttribute("message", "Valid User");
			
			out.println("Welcome, "+username);
			if(typeNum) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
			dispatcher.include(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("welcomeManager.jsp");
				dispatcher.include(request, response);
			}
			
		} else {
			session.setAttribute("message", "Invalid User");
			
			out.println("Your username/password is incorrect , please <a href=login.html>login</a> again.");
		}
		
		out.println("</body></html>");
	}

}
