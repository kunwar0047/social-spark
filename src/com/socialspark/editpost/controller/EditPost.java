package com.socialspark.editpost.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class EditPost
 */
@WebServlet(name = "EditPost", urlPatterns = { "/EditPost" })
public class EditPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/SocialSpark?useSSL=false", "root", "varun");	        
				PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE posts set ptitle=?,pbody=? where postid=?")) 
				{
					String pbody,ptitle;
					int pid;
					ptitle=request.getParameter("ptitle");
					pbody=request.getParameter("pbody");
					String num = request.getParameter("pid");
					pid=Integer.parseInt(num);
					preparedStatement.setString(1, ptitle);
					preparedStatement.setString(2, pbody);
					preparedStatement.setInt(3, pid);
					preparedStatement.executeUpdate();
					RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher("/home.jsp");
				    dispatcher1.forward(request, response);
			
				}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    }
		
	}

}
