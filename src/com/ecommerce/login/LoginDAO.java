package com.ecommerce.login;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.ecommerce.connection.initConnection;
import com.ecommerce.dao.DataBean;
/**
 * <h3>LoginDAO</h3>
 * <p>Collection of all SQL queries</p>
 * 
 * @author Mac
 *
 */
public class LoginDAO {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs1 = null;
	
	public LoginDAO() {
		
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = initConnection.getInstance().getConnection();
		return conn;
	}
	@SuppressWarnings("finally")
	/**
	 * <h2>Validate user entry</h2>
	 * <p>Validate selects all user details if and only if username and password is correct</p>
	 * <p>Once everything is extracted, connection is closed</p>
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean validate(String username, String password) {
		boolean logged = false;
		int id = 0;
		try {
			String queryString = "SELECT * FROM Music_Users WHERE username=? AND password=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, username);
			ptmt.setString(2, password);
			ResultSet rs = ptmt.executeQuery();
			logged = rs.next();
			System.out.println(id);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			//System.out.println(logged);

			return logged;
		}
		
	}
	/**
	 * <h2>Login</h2>
	 * <p>This was created for profile and checkout</p>
	 * <p>Once user is logged in, all his details would be extracted</p>
	 * @param login
	 */
	public void login(LoginBean login) {
		try {
			String queryString = "SELECT * FROM Music_Users";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, login.getId());
			ptmt.setString(2, login.getUsername());
			ptmt.setString(3, login.getPassword());
			ptmt.setString(4, login.getFirstName());
			ptmt.setString(5, login.getLastName());
			ptmt.setString(6, login.getAddress());
			ptmt.setString(7, login.getPostCode());
			ptmt.setString(8, login.getEmail());
			ptmt.setString(9, login.getAddress());

			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	
//	public ArrayList<LoginBean> register(String username, String password, String firstname, String lastname,
//			String address, String postcode, String telephone, String email, String type) {
//		try {
//			String queryString = "INSERT INTO `Music_Users` (`username`, `firstname`, `lastname`, `type`,"
//					+ " `address`, `postcode`, `telephone`, `email`, `password`) "
//					+ "VALUES ('" + username +"', '" + firstname + "', '" + lastname + "', '" + type
//					+ "', '" + address + "', '" + postcode + "', '" +telephone+"', '" +email+"', '"+password+"')";
//			connection = getConnection();
//			ptmt = connection.prepareStatement(queryString);
//			ptmt.setString(1, reg.getUsername());
//			ptmt.executeUpdate();
//			reg = new ArrayList<LoginBean>();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (ptmt != null)
//					ptmt.close();
//				if (connection != null)
//					connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//		}
//		return register;
//	}
	/**
	 * <h2>Add new customer</h2>
	 * 
	 * <p>Registration form for the customers, passed parameters are then stored in the database.</p>
	 * 
	 * @param reg
	 */
	public void addCustomer(LoginBean reg) {
		try {
			String queryString = "INSERT INTO `Music_Users` (`username`, `firstname`, `lastname`, `type`,"
					+ " `address`, `postcode`, `telephone`, `email`, `password`) "
					+ "VALUES(?,?,?, ?, ?, ?, ?,?,?)";
			
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, reg.getUsername());
			ptmt.setString(2, reg.getFirstName());
			ptmt.setString(3, reg.getLastName());
			ptmt.setString(4, reg.getType());
			ptmt.setString(5, reg.getAddress());
			ptmt.setString(6, reg.getPostCode());
			ptmt.setString(7, reg.getTelephone());
			ptmt.setString(8, reg.getEmail());
			ptmt.setString(9, reg.getPassword());
			ptmt.executeUpdate();
			System.out.println(reg);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	/**
	 * <h2>Admin login</h2>
	 * 
	 * <p>Shares the same functionality as validate, but selects it's details from Music_Admin</p>
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean admin(String username, String password) {
		boolean logged = false;
		try {
			String queryString = "SELECT * FROM Music_Admin WHERE username=? AND password=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, username);
			ptmt.setString(2, password);
			ResultSet rs = ptmt.executeQuery();
			logged = rs.next();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return logged;
		
	}
	/**
	 * <h2>Logged in users</h2>
	 * <p>This function is not in use but was kept for future improvements</p>
	 * 
	 * 
	 * @return
	 */
	public ArrayList<LoginBean> getlog() {
	ArrayList<LoginBean> user = null;
		
		try {
			String queryString = "SELECT * FROM Music_Users";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			
			user = new ArrayList<LoginBean>();
			while (rs1.next()) {
				LoginBean temp= new LoginBean();
				temp.setUserName(rs1.getString("username"));
				temp.setPassword(rs1.getString("password"));
				temp.setFirstname(rs1.getString("firstname"));
				temp.setLastname(rs1.getString("lastname"));
				temp.setAddress(rs1.getString("address"));
				temp.setPostcode(rs1.getString("postcode"));
				temp.setTelephone(rs1.getString("telephone"));
				temp.setEmail(rs1.getString("email"));
				user.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		return user;
	}
}
