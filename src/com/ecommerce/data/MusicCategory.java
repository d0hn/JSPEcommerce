package com.ecommerce.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.DataBean;
import com.ecommerce.dao.DataDAO;

/**
 * Servlet implementation class category
 */
@WebServlet("/category")
public class MusicCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusicCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * <h2>Category</h2>
	 * <p>Once ArrayList is passed back from the DAOs function request dispatcher sends 
	 * it into the category.jsp where scope of the item is requested and invidual 
	 * items are extracted. </p>
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataDAO pconnect = new DataDAO(); 
		ArrayList<DataBean> categories = pconnect.retrieveCategories();

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/category.jsp");
			    for (DataBean c : categories){
			    	request.setAttribute("cat", categories);
			    	rd.forward(request, response);
			    	return;
			    }
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
