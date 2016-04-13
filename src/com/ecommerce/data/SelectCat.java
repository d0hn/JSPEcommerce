package com.ecommerce.data;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class SelectCat
 */
@WebServlet("/SelectCat")
public class SelectCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCat() {
        super();
        // TODO Auto-generated constructor stub
    }
  
	/**
	 * <h2>Select Category</h2>
	 * s
	 * <p>Once ArrayList is passed back from the DAOs function request dispatcher sends 
	 * it into the listings.jsp where scope of the item is requested and invidual 
	 * items are extracted. </p>
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataDAO pconnect = new DataDAO(); 
		String CatName = request.getParameter("CatName");
		ArrayList<DataBean> catListing = pconnect.retrieveCatNames(CatName);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/listings.jsp");
		for (DataBean f : catListing){
	    	request.setAttribute("listing", catListing);
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
