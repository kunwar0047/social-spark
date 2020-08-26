package com.socialspark.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.socialspark.main.dao.RegistrationDao;
import com.socialspark.main.model.Registration;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/register.jsp");
	    dispatcher.forward(request, response);
	
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegistrationDao registerDao = new RegistrationDao();
        String fname = request.getParameter("firstName");
        String lname = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");

        Registration registration = new Registration();
        registration.setFname(fname);
        registration.setLname(lname);
        registration.setUsername(username);
        registration.setPassword(password);
        registration.setContact(contact);
        registration.setAddress(address);

        try {
        	registerDao.register(registration);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login");
	    dispatcher.forward(request, response);
	}

}
