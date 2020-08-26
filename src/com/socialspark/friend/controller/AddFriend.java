package com.socialspark.friend.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class AddFriend
 */
@WebServlet("/AddFriend")
public class AddFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFriend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try (Connection connection = DriverManager
		        .getConnection("jdbc:mysql://localhost:3306/SocialSpark?useSSL=false", "root", "varun");	        
		        PreparedStatement preparedStatement = connection
		        .prepareStatement("INSERT INTO relationship (user_one_name, user_two_name, action_user_name) values(?,?,?)")) 
		    {
		    	HttpSession session=request.getSession(); 
				String user_one_name = (String) session.getAttribute("username");
				String user_two_name=request.getParameter("fid");		
				preparedStatement.setString(1, user_one_name);
				preparedStatement.setString(2, user_two_name);
				preparedStatement.setString(3, user_two_name);
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
				RequestDispatcher rd=request.getRequestDispatcher("/AllUsers");  			 
			    rd.forward(request, response); 
			    System.out.println("Redirection");
		    } catch (SQLException e) {
				// TODO Auto-generated catch block
		    	request.setAttribute("Error", "Already Friends");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AllUsers?error=Already Friends");
			    dispatcher.forward(request, response);
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
