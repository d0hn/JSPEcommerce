package com.ecommerce.admin;

import java.io.IOException;

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
 * Servlet implementation class add_category
 */
@WebServlet("/add_category")
public class add_category extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_category() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * <h2>Add new Category</h2>
	 * <p>One of many functions introduced for admin panel,
	 * this one allows user to add new category.</p>
	 * <p>Database had to be adjusted to support auto increment values
	 * to prevent user from entering new id each time</p>
	 * <h4>Way of operation</h4>
	 * <ul>
	 * <li>Parameter is extracted to a string variable</li>
	 * <li>New bean is called</li>
	 * <li>Data DAO is called</li>
	 * <li>Bean is populated with the variable</li>
	 * <li>DAO function setCatName is called and populated bean is passed</li>
	 * <li>Request dispatcher goes back to the "add_new_cat.jsp" page</li>
	 * </ul>
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category = request.getParameter("categoryname");
		DataBean bean = new DataBean();
		DataDAO dao = new DataDAO();
		bean.setCatName(category);
		dao.addCategory(bean);
		 RequestDispatcher rd = request
                 .getRequestDispatcher("/add_new_cat.jsp");
         rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
