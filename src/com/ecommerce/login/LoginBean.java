package com.ecommerce.login;
import java.io.Serializable;
/**
 * <h3>LoginBean</h3>
 * <p>Bean holds all fields which may be requested by a servlet</p>
 * 
 * @author Mac
 *
 */
public class LoginBean implements Serializable {
	private String username;
	private String firstname;
	private String lastname;
	private String password;
	private String type;
	private String address;
	private String postcode;
	private String telephone;
	private String email;
	private int id;
	public LoginBean() {
		
	}
	public LoginBean(String usernam, String firstnam, String lastnam, String passwor, String typ,
			String addres, String postcod, String telephon, String emai, int unid) {
		username = usernam;
		firstname = firstnam;
		lastname = lastnam;
		password = passwor;
		type = typ;
		address = addres;
		postcode = postcod;
		telephone = telephon;
		email = emai;
		id = unid;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getFirstName() {
		return firstname;
	}
	public String getLastName() {
		return lastname;
	}
	public String getAddress() {
		return address;
	}
	public String getPostCode() {
		return postcode;
	}
	public String getType() {
		return type;
	}
	public String getEmail() {
		return email;
	}
	public String getTelephone() {
		return telephone;
	}
	public int getId(){
		return id;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setId(int id){
		this.id = id;
	}
	public String toString() {
		return "[Login " + username + password + firstname + lastname + address
				+ postcode + email + telephone + id + "]";
	}
}
