package com.ecommerce.shop;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.DataBean;
import com.ecommerce.dao.DataDAO;
import com.ecommerce.login.LoginBean;
import com.ecommerce.login.LoginDAO;

/**
 * Servlet implementation class CheckoutShop
 */
@WebServlet("/CheckoutShop")
public class CheckoutShop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutShop() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		final String username = request.getParameter("user");
		final String password = request.getParameter("pw");
		final String record = request.getParameter("recording");
		int recordId = Integer.parseInt(record);
		LoginBean login = new LoginBean();
		login.setUserName(username);
		login.setPassword(password);
		LoginDAO getlogin = new LoginDAO();
		ArrayList<LoginBean> loginbean = getlogin.getlog();
		
		DataBean data = new DataBean();
		data.setRecordId(recordId);
		DataDAO getRecord = new DataDAO();
		ArrayList<DataBean> recordbean = getRecord.retrieveRecordings(recordId);
		
		RequestDispatcher rd = request.getRequestDispatcher("/checkout.jsp");
        System.out.println(recordbean);
		for (DataBean c : recordbean) {
			request.setAttribute("rcdb", recordbean);
			rd.forward(request, response);
		}
	}

}
