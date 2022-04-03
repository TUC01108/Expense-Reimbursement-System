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
import com.training.model.Reimbursement;

/**
 * Servlet implementation class ReimbursementController
 */
public class ReimbursementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursementController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String r_type = request.getParameter("r_type");
		Long amount = Long.parseLong(request.getParameter("amount"));
		String username = request.getParameter("username");
		//String comments = request.getParameter("comments");
		

		HttpSession session = request.getSession();
		session.setAttribute("r_type", r_type);
		
		Reimbursement reimbursement = new Reimbursement(-1, r_type, amount, username);
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		//User user = new User()
		boolean result = employeeDAO.createExpense(reimbursement);
		
		PrintWriter out = response.getWriter();		

		if (result) {
			session.setAttribute("message", "Valid New Expense Created");

			//out.println("You've successfully signed up, " + username);
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
			dispatcher.include(request, response);
		} else {
session.setAttribute("message", "Invalid expense created");
			
			out.println("Something is incorrect , please <a href=createNewExpenseDetails.jsp>create a new expense</a> again.");
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
