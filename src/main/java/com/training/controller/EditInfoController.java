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

/**
 * Servlet implementation class ReimbursementController
 */
public class EditInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String o_username = request.getParameter("o_username");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		

		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		
		//User user = new User(-1, username, first_name, last_name);
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		//User user = new User()
		boolean result = employeeDAO.editInfo(o_username, password, username, first_name, last_name);
		
		PrintWriter out = response.getWriter();		

		if (result) {
			session.setAttribute("message", "Valid User Edit");

			//out.println("You've successfully signed up, " + username);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employeeInfo.jsp");
			dispatcher.include(request, response);
		} else {
session.setAttribute("message", "Invalid Edit");
			
			out.println("Something is incorrect , please <a href=editEmployeeInfo.jsp>try to edit</a> again.");
		}
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
