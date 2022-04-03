
# Expense Reimbursement System

## Project Description

ERS is an application that manages the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursements requests and history for all employees in the company. They are authorized to approve and deny requests for expense reimbursement. 

## Technologies Used

* Java - version 1.8.0_321
* PostgreSQL - version 14.2
* JavaScript - version 1.7
* Selenium - version 4.1.3
* JUnit - version 5.8.2
* Log4J - version 1.2.17

## Features

Employee can: 
* Login/Logout
* View the employee home page
* Submit a reimbursement request
* View their pending reimbursement requests
* View their resolved reimbursement requests
* View their information
* Update their information

A Manager can: 
* Login/Logout
* View the manager home page
* Approve/deny pending reimbursement requests
* View all pending requests of all employees
* View all resolved requests of all employees
* View reimbursement requests of a specific employee
* View all employees

To-do list:
* 
* 

## Getting Started
   
* git clone https://github.com/TUC01108/Expense-Reimbursement-System.git

* Eclipse- Backend
* DBeaver- Database

********************************

********App wont work without the below action taken**********

Manually create the table in DBeaver found in ERS_TABLES.sql in the following order-
* Login
* Users
* Reimbursement

********************************

Start server in Eclipse by right clicking on project and selecting >Run as>Run on Server.
Default server is 8080
To get started type into browser- http://localhost:8080/ 


## Usage

The application starts on the main welcome screen which gives you an option of login and signup.
Click signup and type in a username, password, confirm password, first name, last name, email.
You will see the employee welcome screen which has options view all employees, search users, create new expense, view all pending reimbursements, view all resolved reimbursements, view employee information, logout.
Click View All Employees to view all employees registered in the system. Click back to return.
Click Search Users. This will besides the employees you create. Click back to return.
Click Create New Expense. This will allow you to create a expense for reimbursement ticket. Click Create. Type in "type of expense", amount, comments. Click submit
Click View All Pending Reimbursements to see any that the manager has not yet approved.
Click view All Resolved Reimbursements to see any that the manager has approved.
Click View Employee Information to see information about the employee.
Click Logout.
Managers can only be added manually by the system as a security feature. Add in the login and users tables. Must have an 'M' accounttype to be read as a manager in system.
Once created click login and use those credentials in the login page.
You will see the manager welcome screen with view all users, search reimbursement requests by username, approve/deny pending reimbursement requests, view all pending reimbursements, view all resolved reimbursements, view manager information, logout.
Click view all users to see all users in the system including managers and employees.
Click search reimbursement requests by username to do so.
Click approve/deny pending reimbursement requests. Type in the id you'd like to approve in the first textbox to approve or in the second textbox to deny.
Click view all pending reimbursements to do so.
Click view all resolved reimbursements to do so.
Click view manager information to do so.


## License

This project does not use any license.

