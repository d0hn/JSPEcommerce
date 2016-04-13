package com.ecommerce.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class removeCartItems
 */
@WebServlet("/removeCartItems")
public class removeCartItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeCartItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");		
        String title = request.getParameter("title");
        HttpSession session = request.getSession();
        Cart shoppingCart;
        shoppingCart = (Cart) session.getAttribute("cart");
        shoppingCart.deleteFromCart(title);
        session.setAttribute("cart", shoppingCart);
        shoppingCart = (Cart) session.getAttribute("cart");
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

            HashMap<String, Integer> items = shoppingCart.getCartItems();
	        ServletContext sc = getServletConfig().getServletContext();
            for(String key: items.keySet()){
	            sc.setAttribute("cartI", items);
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
