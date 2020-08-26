package com.socialspark.registration.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.socialspark.main.model.Notification;

/**
 * Servlet implementation class passwordchanger
 */
@WebServlet("/passwordchanger")
public class passwordchanger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public passwordchanger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (Connection connection1 = DriverManager
		        .getConnection("jdbc:mysql://localhost:3306/SocialSpark?useSSL=false", "root", "varun");	        
		        PreparedStatement preparedStatement1 = connection1
		        .prepareStatement("Update users SET password=? where username=?");) 
		    {			
				HttpSession session=request.getSession(); 
				String sender = (String) session.getAttribute("username");
				String psswd=request.getParameter("password");
				preparedStatement1.setString(2, sender);
				preparedStatement1.setString(1, psswd);
				preparedStatement1.executeUpdate();				
				////System.out.println(listOfFriends.size());
				request.setAttribute("msg", "Successfully Updated");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/settings.jsp");
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
