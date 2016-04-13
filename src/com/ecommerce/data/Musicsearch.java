package com.ecommerce.data;

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

/**
 * Servlet implementation class Musicsearch
 */
@WebServlet("/Musicsearch")
public class Musicsearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Musicsearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * <h2>Music Search</h2>
	 * 
	 * <p>Function exctracts parameter from the url and sends it over to DataDAO function
	 * which searches for fields, if arraylist is empty go to error page otherwise
	 * go to results page
	 * </p>
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search = request.getParameter("search");
		DataDAO data = new DataDAO();
		System.out.println(search);
		ArrayList<DataBean> searchres = data.searchFor(search);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/search.jsp");
		System.out.println(searchres);
		if(searchres.isEmpty()) {
        response.sendRedirect("notfound.jsp");
		}
	    if(searchres != null) {
			for (DataBean c : searchres){
		    	request.setAttribute("searches", searchres);
		    	rd.forward(request, response);
		    	return;
		}
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
