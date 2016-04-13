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
 * Servlet implementation class MusicListing
 */
@WebServlet("/albums")
public class MusicListing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusicListing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * <h2>Music Listings</h2>
	 *  <p>Once ArrayList is passed back from the DAOs function request dispatcher sends 
	 * it into the albums.jsp where scope of the item is requested and invidual 
	 * items are extracted. </p>
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		com.ecommerce.dao.DataDAO pconnect = new com.ecommerce.dao.DataDAO(); 
		ArrayList<DataBean> music = pconnect.findAllTracks();
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/albums.jsp");

		    for (DataBean l : music){
		    	request.setAttribute("albums", music);
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
