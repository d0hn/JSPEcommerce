package com.ecommerce.data;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.DataBean;
import com.ecommerce.dao.DataDAO;
import com.sun.glass.ui.CommonDialogs.Type;

/**
 * Servlet implementation class prices
 */
@WebServlet("/prices")
public class MusicPrices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusicPrices() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * <h2>Find between prices</h2>
	 * <p>Firstly passed parameters are changed to an SQL format e.g. 8211 to 8.99 AND 10.99, this indicates
	 * price ranges which will be queried to the database.</p>
	 * <p>Once ArrayList is passed back from the DAOs function request dispatcher sends 
	 * it into the prices.jsp where scope of the item is requested and invidual 
	 * items are extracted. </p>
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String prices = request.getParameter("prices");
		String sort = request.getParameter("sort");
		String type;
		if (prices != null && prices.equals("8211")) {
			prices = "8.99 AND 10.99";
		} 
		if (prices != null && prices.equals("11212")) {
			prices = "10.99 AND 11.99";
		}
		if (prices != null && prices.equals("12213")) {
			prices = "11.99 AND 12.99";
		}
		if (prices != null && prices.equals("13214")) {
			prices = "12.99 AND 13.99";
		}
		if(prices != null && prices.equals("14216")) {
			prices = "13.99 AND 15.99";
		}
		if(prices != null && prices.equals("16")) {
			prices = "15.99 AND 99.99";
		}
		if(sort == null) {
			sort = "ASC";
		} 
		
		DataDAO pconnect = new DataDAO(); 
		ArrayList<DataBean> pric = pconnect.findBetweenPrice(prices, sort);
		request.setAttribute("prices", pric); 
		request.getRequestDispatcher("/prices.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
