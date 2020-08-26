package com.socialspark.like.controller;

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
import com.socialspark.main.model.Posts;

/**
 * Servlet implementation class likepost
 */
@WebServlet("/likepost")
public class likepost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public likepost() {
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
				.prepareStatement("UPDATE posts set plikes=plikes+1 where postid=?")) 
				{
					String num = request.getParameter("likeid");
					int likeid=Integer.parseInt(num);
					preparedStatement.setInt(1,likeid);
					System.out.println(preparedStatement);
					preparedStatement.executeUpdate();
					Connection connection1 = DriverManager
					        .getConnection("jdbc:mysql://localhost:3306/SocialSpark?useSSL=false", "root", "varun");	        
					        PreparedStatement preparedStatement1 = connection
					        .prepareStatement("select * from posts");
					    
					    	HttpSession session1=request.getSession(); 
							String userid = (String) session1.getAttribute("username");
							System.out.println("post owner"+userid);
				
							Vector<Posts> listOfAllPosts = new Vector<Posts>();				
							ResultSet rs = preparedStatement1.executeQuery();
							System.out.println(rs);
							
							while(rs.next()){
								int pid = rs.getInt(1);
								String uname = rs.getString(2);
								uname=uname.toUpperCase();
								String ptitle = rs.getString(3);
								String pbody = rs.getString(4);
								ptitle=ptitle.toUpperCase();
								int plikes = rs.getInt(5);
								System.out.println(rs);
								Posts objPost = new Posts(pid, uname, ptitle, pbody,plikes);
								listOfAllPosts.add(objPost);
								System.out.println("pid = "+pid);
							}
							String _sorce=request.getParameter("sourcepage");
							System.out.println(_sorce);
							
							if(_sorce==null)
							{				
								
							    RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher("/home");
							    dispatcher1.forward(request, response);
								
							}
							else{
								request.setAttribute("listOfAllPosts", listOfAllPosts);
								RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/allposts.jsp");
							    dispatcher.forward(request, response);				
							}
					
					
				} catch (SQLException e) {
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
