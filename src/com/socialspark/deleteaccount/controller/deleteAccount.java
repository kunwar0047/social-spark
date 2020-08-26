package com.socialspark.deleteaccount.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class deleteAccount
 */
@WebServlet("/deleteAccount")
public class deleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try (Connection connection1 = DriverManager
		        .getConnection("jdbc:mysql://localhost:3306/SocialSpark?useSSL=false", "root", "varun");	        
		        PreparedStatement preparedStatement1 = connection1
		        .prepareStatement("DELETE FROM USERS WHERE username=?");) 
		    {			
				HttpSession session=request.getSession(); 
				String user = (String) session.getAttribute("username");
				String psswd=request.getParameter("password");
				preparedStatement1.setString(1, user);				
				preparedStatement1.executeUpdate();				
				////System.out.println(listOfFriends.size());
				request.setAttribute("msg", "Successfully Updated");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/logout");
			    dispatcher.forward(request, response);
				
		    }
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
