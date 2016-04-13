package com.ecommerce.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * <h2>Logout</h2>
	 * <p>Kill the session, resulting in terminating users login status</p>
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
         PrintWriter out=response.getWriter();  

		 HttpSession session=request.getSession();  
         session.invalidate(); 
         response.setContentType("text/html");
         out.println("<html><head><title>"
         		+ "You have successfully logged out</title></head><body style='text-align:center;'>");
         out.println("<a href='index.jsp'><img style='width:150px' src='img/logo.png'></a>");
         out.print("<p>You have logged out, see you later!</p>");
         out.print("Go to <a href='index.jsp'>Homepage</a>");
         out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
