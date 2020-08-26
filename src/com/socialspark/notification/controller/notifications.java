package com.socialspark.notification.controller;

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

import com.socialspark.main.model.Message;
import com.socialspark.main.model.Notification;

/**
 * Servlet implementation class notifications
 */
@WebServlet("/notifications")
public class notifications extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public notifications() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Vector<Notification> notiflist = new Vector<Notification>();
		try (Connection connection1 = DriverManager
		        .getConnection("jdbc:mysql://localhost:3306/SocialSpark?useSSL=false", "root", "varun");	        
		        PreparedStatement preparedStatement1 = connection1
		        .prepareStatement("select * from notifications where username=?");) 
		    {			
				HttpSession session=request.getSession(); 
				String sender = (String) session.getAttribute("username");
				ResultSet rs1 = null;			
				preparedStatement1.setString(1, sender);
				rs1 = preparedStatement1.executeQuery();
				
				//System.out.println(rs1);				
				while(rs1.next()){
					String notification =null;			
					notification = rs1.getString(3);
					System.out.println(notification);	
					Notification msg=new Notification(notification);					
					notiflist.add(msg);	
				}
				
				request.setAttribute("notiflist",notiflist);
				
				////System.out.println(listOfFriends.size());
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/notifications.jsp");
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
