package com.ecommerce.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addCartItems
 */
@WebServlet("/addCartItems")
public class addCartItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCartItems() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
             
       
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html;charset=UTF-8");
	        HttpSession session = request.getSession();
	        Cart shoppingCart;
	        shoppingCart = (Cart) session.getAttribute("cart");
	        if(shoppingCart == null){
	          shoppingCart = new Cart();
	          session.setAttribute("cart", shoppingCart);
	        }
	        String title = request.getParameter("title");
	        Integer recid = Integer.parseInt(request.getParameter("recordId"));
	        shoppingCart.addToCart(title, recid);
	        session.setAttribute("cart", shoppingCart);
	        ServletContext sc = getServletConfig().getServletContext();


	            HashMap<String, Integer> items = shoppingCart.getCartItems();
	            RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
	            for(String key: items.keySet()){
		            sc.setAttribute("cartI", items);
	                request.setAttribute("items", items);
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
