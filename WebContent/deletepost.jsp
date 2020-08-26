<%@page import="java.sql.*"%>
<%@page import="com.socialspark.main.model.Posts"%>
<%@page import="java.util.Vector"%>
<%@page import="javax.servlet.http.*"%>
<%
try (Connection connection = DriverManager
<<<<<<< HEAD
.getConnection("jdbc:mysql://localhost:3306/SocialSpark?useSSL=false", "root", "dell123");	        
=======
.getConnection("jdbc:mysql://localhost:3306/SocialSpark?useSSL=false", "root", "varun");	        
>>>>>>> 3d21e81... second commit
PreparedStatement preparedStatement = connection
.prepareStatement("delete from posts where postid=?")) 
{
	String num = request.getParameter("id");
	int id=Integer.parseInt(num);
	preparedStatement.setInt(1,id);
	System.out.println(preparedStatement);
	
	preparedStatement.executeUpdate();	
	HttpSession session1=request.getSession(); 
	String userid = (String) session1.getAttribute("username");
	RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher("/AllPosts?user="+userid);
	dispatcher1.forward(request, response);		
			
			
	
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
%>