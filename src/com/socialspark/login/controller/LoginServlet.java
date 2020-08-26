package com.socialspark.login.controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.socialspark.main.dao.LoginDao;
import com.socialspark.main.model.Login;
import com.socialspark.main.model.Users;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */



    	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginDao loginDao = new LoginDao();

		String username = request.getParameter("username");
        String password = request.getParameter("password");
        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);

        try {
            if (loginDao.validate(login)) {
                HttpSession session = request.getSession();
                 session.setAttribute("username",username);
                 //Users objUser = new Users();
     			System.out.println("logged in "+username);	
     			//Vector<Users> listOfAllFriends = objUser.allusers(getServletContext(),request);
    			//session.setAttribute("listOfAllFriends", listOfAllFriends);
                 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home");
         	    dispatcher.forward(request, response);
            } else {
                
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
        	    dispatcher.forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}

}
