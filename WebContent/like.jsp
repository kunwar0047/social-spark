<%@page import="java.sql.*"%>
<%@page import="com.socialspark.main.model.Posts"%>
<%@page import="java.util.Vector"%>
<%@page import="javax.servlet.http.*"%>
<%
try (Connection connection = DriverManager
.getConnection("jdbc:mysql://localhost:3306/SocialSpark?useSSL=false", "root", "dell123");	        
PreparedStatement preparedStatement = connection
.prepareStatement("UPDATE posts set plikes=plikes+1 where postid=?")) 
{
	String num = request.getParameter("id");
	int id=Integer.parseInt(num);
	preparedStatement.setInt(1,id);
	System.out.println(preparedStatement);
	preparedStatement.executeUpdate();
	Connection connection1 = DriverManager
	        .getConnection("jdbc:mysql://localhost:3306/SocialSpark?useSSL=false", "root", "dell123");	        
	        PreparedStatement preparedStatement1 = connection
	        .prepareStatement("select * from posts");
	    
	    	HttpSession session1=request.getSession(); 
			String userid = (String) session1.getAttribute("username");
			System.out.println("post owner"+userid);
			
			ResultSet rs = null;				
			Vector<Posts> listOfAllPosts = new Vector<Posts>();				
			rs = preparedStatement1.executeQuery();
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
			request.setAttribute("listOfAllPosts", listOfAllPosts);
			if(_sorce==null)
			{				
				
			    RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher("/home.jsp");
			    dispatcher1.forward(request, response);
				
			}
			else{
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/allposts.jsp");
			    dispatcher.forward(request, response);				
			}
	
	
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
%>                                                                                                                                                                                                                                          