package com.ecommerce.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class log
 */
@WebServlet("/log")
public class log extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public log() {
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
	 * <h2>Login System</h2>
	 * <p>Database holds all the details of users in the table Music_Users, function firstly extracts
	 * 2 parameters of username and password, then these are passed to check whether they correspond to any field
	 * in the database</p>
	 * <p>If username and password are both correct user is logged in and session user is saved</p>
	 * <p>However, if user fails to provide correect details he is redirected to an error page</p>
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		LoginDAO login = new LoginDAO();
		if(login.validate(username,password)) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	        HttpSession session=request.getSession();  
	        session.setAttribute("user", username);
	        session.setAttribute("pw", password);
			rd.include(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.include(request, response);
		}
	}

}
