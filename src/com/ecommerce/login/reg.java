package com.ecommerce.login;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class reg
 */
@WebServlet("/reg")
public class reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * <h2>Register new customer</h2>
	 * <p>This function takes all the parameters passed from form on login.jsp page
	 * stores them locally and populates the bean with the results, once process is completed
	 * bean is passed to addCustomer in LoginDAO.</p>
	 * <p>When everything is completed, user is redirected to login.jsp page again and parameter
	 * indicating that process has been completed is passed.</p>
	 * 
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	    response.setContentType("text/html");
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final String firstname = request.getParameter("firstname");
		final String lastname = request.getParameter("lastname");
		final String address = request.getParameter("address");
		final String postcode = request.getParameter("postcode");
		final String telephone = request.getParameter("telephone");
		final String email = request.getParameter("email");
		final String type = request.getParameter("type");
		LoginBean bean = new LoginBean();
		bean.setUserName(username);
		bean.setFirstname(firstname);
		bean.setLastname(lastname);
		bean.setPassword(password);
		bean.setAddress(address);
		bean.setPostcode(postcode);
		bean.setTelephone(telephone);
		bean.setEmail(email);
		bean.setType(type);
		LoginDAO registeruser = new LoginDAO();
		//username, password, firstname,lastname,address,postcode,telephone,email,type
		registeruser.addCustomer(bean);
		 RequestDispatcher rd = request
                 .getRequestDispatcher("/login.jsp?&m=success");
         rd.forward(request, response);
	}

}
