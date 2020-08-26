package com.socialspark.addpost.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import java.sql.Connection;

/**
 * Servlet implementation class AddPost
 */
@WebServlet("/PostServlet")
public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}

	
	public void init() throws ServletException 
	{
		
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPost() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
	    dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	    try (Connection connection = DriverManager
	        .getConnection("jdbc:mysql://localhost:3306/SocialSpark?useSSL=false", "root", "varun");	        
	        PreparedStatement preparedStatement = connection
	        .prepareStatement("insert into posts(username,ptitle,pbody,pdate) values(?,?,?,?)")) 
	    {
	    	HttpSession session=request.getSession(); 
			String userid = (String) session.getAttribute("username");
			System.out.println("posted by"+userid);			
			String pbody, ptitle;			
			PrintWriter out = response.getWriter();			
	        ptitle = request.getParameter("ptitle");
			pbody = request.getParameter("pbody");
			preparedStatement.setString(1, userid);
			preparedStatement.setString(2, ptitle);
			preparedStatement.setString(3, pbody);
			preparedStatement.setDate(4, getCurrentDate());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			RequestDispatcher rd=request.getRequestDispatcher("/home");  			 
		    rd.forward(request, response); 
		    System.out.println("Redirection");
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
				
	}

}
