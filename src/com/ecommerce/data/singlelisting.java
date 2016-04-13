package com.ecommerce.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ecommerce.dao.DataBean;
import com.ecommerce.dao.DataDAO;
/**
 * Servlet implementation class singlelisting
 */
@WebServlet("/singlelisting")
public class singlelisting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public singlelisting() {
        super();
        // TODO Auto-generated constructor stub
    }
    private int counter;
    
    public void initialise() {
    	counter = 0;
    }
	/**
	 * <h2>Single Listings</h2>
	 * <p>Each album can have a single listing, which shows different songs from thatw album,
	 * parameters are saved and cookies are created for things like artist and title</p>
	 * <p>Cookies are created for the purpose of displaying last viewed items in the sidebar on few internal
	 * pages</p>
	 * <p>Once ArrayList is passed back from the DAOs function request dispatcher sends 
	 * it into the singlelisting.jsp where scope of the item is requested and invidual 
	 * items are extracted. </p>
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String artist = request.getParameter("artist");
		String title = request.getParameter("title");
		String id = request.getParameter("id");
		String art = null;
		if (title != null && artist != null) {
		art = title + " by " + artist;
		}else {
			art = artist;
		}
		counter++;
		Cookie cookie = new Cookie("artist" + counter, art);
		Cookie cookie2 = new Cookie("control_id" + counter, id);
		Cookie cookie3 = new Cookie("control_art" + counter, artist);
		Cookie cookie4 = new Cookie("title" + counter, title);
		cookie.setMaxAge(60*60);
		if(counter <= 5) {
			response.addCookie(cookie);
			response.addCookie(cookie2);
			response.addCookie(cookie3);
			response.addCookie(cookie4);
		}else {
			counter =0;
		}
		DataDAO pconnect = new DataDAO(); 
		ArrayList<DataBean> single = pconnect.retrieveSingle(id);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/singlelisting.jsp");
	    for (DataBean c : single){
	    	request.setAttribute("sin", single);	  
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
