package com.ecommerce.shop;

import java.util.HashMap;

public class Cart {
	
	HashMap<String, Integer> cartItems;
	
	public Cart() {
	     cartItems = new HashMap<>();
	}
	public HashMap getCartItems(){
	       return cartItems;
	}
	public void addToCart(String title,int recordId) {	
		cartItems.put(title, recordId);
	}
	public void deleteFromCart(String recordId){
        cartItems.remove(recordId);
    }
}