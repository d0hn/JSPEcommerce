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
 * Servlet implementation class admin
 */
@WebServlet("/admin")
public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * <h2>Admin</h2>
	 * <p>Method of operation is identical to the login one, however there's an extra table in the database
	 * Music_Admin which holds all the details of the admin users.</p>
	 * <p>2 Parameters are extracted, username and password and are checked against details held in the 
	 * database</p>
	 * <p>If login is successful, user is logged into the system and session attribute is saved</p>
	 * <p>If user fails to login he is redirected to an error page.</p>
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		LoginDAO login = new LoginDAO();
		if(login.admin(username,password)) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	        HttpSession session=request.getSession();  
	        session.setAttribute("admin", username);
			rd.include(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.include(request, response);
		}
	}
}
