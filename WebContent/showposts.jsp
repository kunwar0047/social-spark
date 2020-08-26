<%@page import="java.sql.*"%>
<%@page import="com.socialspark.main.model.Posts"%>
<%@page import="java.util.Vector"%>
<%@page import="javax.servlet.http.*"%>
<%
try (Connection connection = DriverManager
.getConnection("jdbc:mysql://localhost:3306/SocialSpark?useSSL=false", "root", "varun");	        
PreparedStatement preparedStatement = connection
.prepareStatement("select * from posts")) 
{
	HttpSession session1=request.getSession(); 
	String userid = (String) session1.getAttribute("username");
	System.out.println("post owner"+userid);
	
	ResultSet rs = null;				
	Vector<Posts> listOfAllPosts = new Vector<Posts>();				
	rs = preparedStatement.executeQuery();
	System.out.println(rs);
	
	while(rs.next()){
		int pid = rs.getInt(1);
		String uname = rs.getString(2);
		uname=uname.toUpperCase();
		String ptitle = rs.getString(3);
		String pbody = rs.getString(4);
		int plikes = rs.getInt(5);
//		java.sql.Date pdate = rs.getDate(5);
		System.out.println(rs);
//		Posts objPost = new Posts(pid, uname, ptitle, pbody, pdate);
		Posts objPost = new Posts(pid, uname, ptitle, pbody,plikes);
		listOfAllPosts.add(objPost);
		System.out.println("pid = "+pid);
	}
	request.setAttribute("listOfAllPosts", listOfAllPosts);
	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/allposts.jsp");
    dispatcher.forward(request, response);
	
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
%>