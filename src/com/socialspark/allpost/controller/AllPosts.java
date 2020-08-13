package com.socialspark.allpost.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.PreparedStatement;
import com.socialspark.main.model.Posts;

/**
 * Servlet implementation class AllPosts
 */
@WebServlet(name = "AllPosts", urlPatterns = { "/AllPosts" })
public class AllPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllPosts() {
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
		        .getConnection("jdbc:mysql://localhost:3306/SocialSpark?useSSL=false", "root", "dell123");	        
		        PreparedStatement preparedStatement = connection
		        .prepareStatement("select * from posts where username like ?")) 
		    {
		    	
				String userid="%";
				String usernme=request.getParameter("user");
				if(usernme!="") 
				{
					userid=usernme;
				}
				System.out.println(userid);
				preparedStatement.setString(1, userid);
				ResultSet rs = null;				
				Vector<Posts> listOfAllPosts = new Vector<Posts>();				
				rs = preparedStatement.executeQuery();
				System.out.println(rs);
				
				while(rs.next()){
					int pid = rs.getInt(1);
					String uname = rs.getString(2);
					uname=uname.toUpperCase();
					String ptitle = rs.getString(3);
					ptitle=ptitle.toUpperCase();
					String pbody = rs.getString(4);
					int plikes = rs.getInt(5);
					System.out.println(rs);
					Posts objPost = new Posts(pid, uname, ptitle, pbody,plikes);
					listOfAllPosts.add(objPost);
					System.out.println("pid = "+pid);
				}
				request.setAttribute("listOfAllPosts", listOfAllPosts);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			    dispatcher.forward(request, response);

		    } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
