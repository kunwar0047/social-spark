package com.socialspark.home.controller;

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
import com.socialspark.main.model.Users;

/**
 * Servlet implementation class home
 */
@WebServlet(name = "home", urlPatterns = { "/home" })
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public home() {
        super();
        // TODO Auto-generated constructor stub
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Vector<Users> listOfFriends = new Vector<Users>();
		try (Connection connection1 = DriverManager
		        .getConnection("jdbc:mysql://localhost:3306/SocialSpark?useSSL=false", "root", "varun");	        
		        PreparedStatement preparedStatement1 = connection1
		        .prepareStatement("select * from relationship where user_one_name like ?");) 
		    {
		    	
				String useridd="%";
				HttpSession session=request.getSession(); 
				String username = (String) session.getAttribute("username");
				if(username!="") 
				{
					useridd=username;
				}
				ResultSet rs1 = null;			
				preparedStatement1.setString(1, username);
				rs1 = preparedStatement1.executeQuery();
				
				//System.out.println(rs1);				
				while(rs1.next()){
					String fusername =null;			
					fusername = rs1.getString(2);					 
					Users objfriend = new Users(fusername);
					System.out.println("friend"+objfriend.getUsername());
					listOfFriends.add(objfriend);	
				}
				System.out.println("inloop sizw"+listOfFriends.size());
				
		    }
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		try (Connection connection = DriverManager
		        .getConnection("jdbc:mysql://localhost:3306/SocialSpark?useSSL=false", "root", "varun");	        
		        PreparedStatement preparedStatement = connection
		        .prepareStatement("select * from posts where username like ?");
				) 
		    {
		    	
				String userid="%";
				HttpSession session1=request.getSession(); 
				String usernme = (String) session1.getAttribute("username");
				if(usernme!="") 
				{
					userid=usernme;
				}
				//System.out.println(userid);
				preparedStatement.setString(1, userid);
				ResultSet rs = null;				
				Vector<Posts> listOfAllPosts = new Vector<Posts>();				
				rs = preparedStatement.executeQuery();
				//System.out.println(rs);
				
				while(rs.next()){
					int pid = rs.getInt(1);
					String uname = rs.getString(2);
					uname=uname.toUpperCase();
					String ptitle = rs.getString(3);
					ptitle=ptitle.toUpperCase();
					String pbody = rs.getString(4);
					int plikes = rs.getInt(5);
					//System.out.println(rs);
					Posts objPost = new Posts(pid, uname, ptitle, pbody,plikes);
					listOfAllPosts.add(objPost);
					//System.out.println("pid = "+pid);
					
				}
				request.setAttribute("listOfAllPosts", listOfAllPosts);
				request.setAttribute("listOfFriends", listOfFriends);
				////System.out.println(listOfFriends.size());
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			    dispatcher.forward(request, response);

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
		doGet(request,response);
	}

}
