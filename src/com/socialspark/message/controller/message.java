package com.socialspark.message.controller;

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
import com.socialspark.main.model.Users;

/**
 * Servlet implementation class message
 */
@WebServlet("/message")
public class message extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public message() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Vector<Message> chatlist = new Vector<Message>();
		try (Connection connection1 = DriverManager
		        .getConnection("jdbc:mysql://localhost:3306/SocialSpark?useSSL=false", "root", "varun");	        
		        PreparedStatement preparedStatement1 = connection1
		        .prepareStatement("select * from message where sender=? AND receiver=? or sender=? AND receiver=?");) 
		    {			
				HttpSession session=request.getSession(); 
				String sender = (String) session.getAttribute("username");
				String receiver =request.getParameter("receiver");
				ResultSet rs1 = null;			
				preparedStatement1.setString(1, sender);
				preparedStatement1.setString(2, receiver);				
				preparedStatement1.setString(3, receiver);
				preparedStatement1.setString(4, sender);
				rs1 = preparedStatement1.executeQuery();
				
				//System.out.println(rs1);				
				while(rs1.next()){
					String message =null;			
					message = rs1.getString(3);
					sender=rs1.getString(1);
					receiver=rs1.getString(2);
					System.out.print(sender+":"+message);
					Message msg=new Message(sender,receiver,message);					
					chatlist.add(msg);	
				}
				receiver =request.getParameter("receiver");
				request.setAttribute("chatlist", chatlist);
				request.setAttribute("receiver", receiver);				
				////System.out.println(listOfFriends.size());
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/message.jsp");
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
		try (Connection connection1 = DriverManager
		        .getConnection("jdbc:mysql://localhost:3306/SocialSpark?useSSL=false", "root", "varun");	        
		        PreparedStatement preparedStatement1 = connection1
		        .prepareStatement("insert into message(sender,receiver,message) values(?,?,?)");) 
		    {				
				HttpSession session=request.getSession(); 
				String sender = (String) session.getAttribute("username");
				String receiver =request.getParameter("receiver");		
				String message =request.getParameter("message");	
				preparedStatement1.setString(1, sender);
				preparedStatement1.setString(2, receiver);				
				preparedStatement1.setString(3, message);
				preparedStatement1.executeUpdate();
				System.out.println("updated");
				response.sendRedirect(request.getContextPath()+"/message?receiver="+receiver+"&sender="+sender);
								
		    }
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

}
