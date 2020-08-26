package com.socialspark.AllUsers.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.socialspark.main.model.Users;

/**
 * Servlet implementation class AllUsers
 */
@WebServlet("/AllUsers")
public class AllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllUsers() {
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
		        .prepareStatement("select * from users where username!=?")) 
		    {
		    	
				HttpSession session1=request.getSession(); 
				String usernme = (String) session1.getAttribute("username");
				String error="";
				error=request.getParameter("error");
				ResultSet rs1 = null;				
				Vector<Users> listOfAllFriends = new Vector<Users>();
				preparedStatement1.setString(1, usernme);
				rs1 = preparedStatement1.executeQuery();			
				while(rs1.next()){
					String fusername =null;			
					int fuid = rs1.getInt(1);
					 fusername = rs1.getString(4);
					 if(usernme!=fusername) 
					 {
						 Users objfriend = new Users( fuid,fusername);
						listOfAllFriends.add(objfriend);
					}
					
				}
				request.setAttribute("listOfAllFriends", listOfAllFriends);
				request.setAttribute("error", error);

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AllUsers.jsp");
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
