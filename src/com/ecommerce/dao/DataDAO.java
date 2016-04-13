package com.ecommerce.dao;



import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ecommerce.connection.initConnection;
/**
 * <h2>DataDAO</h2>
 * <p>DataDAO collects all functions
 * that communicate with sql database. Each function serves different purpose.</p>
 * @author Mac
 *
 */
public class DataDAO {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs1 = null;

	public DataDAO() {

	}
	/**
	 * <h3>Prepare connection</h3>
	 * <p>This function prepares connection with the database</p>
	 * @return
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = initConnection.getInstance().getConnection();
		return conn;
	}
	/**
	 * <h3>Add Category</h3>
	 * <p>Firstly, function prepares query string for the database.<br/>
	 * Then connection is prepared and query is executed.</p>
	 * <p>New category is then put into the database</p>
	 * <p>Function catches any SQL Exceptions, and once everything 
	 * is completed connection is closed</p>
	 * 
	 * @param cat
	 */
	public void addCategory(DataBean cat) {
		try {
			String queryString = "INSERT INTO Music_Categories(name) VALUES(?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
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
	/**
	 * <h3>Add Tracks</h3>
	 * <p>Function prepares query string for the database which will insert values into the
	 * database</p>
	 * <p>DataBean trac populated with the Music track details is put into the database
	 * </p>
	 * <p>Function catches any SQL Exceptions, and once everything 
	 * is completed connection is closed</p>
	 * 
	 * @param trac
	 */
	public void addTracks(DataBean trac) {
		try {
			String queryString = "INSERT INTO Music_Tracks(id, recording_id, title,duration) VALUES(?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);			
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
	/**
	 * <h3>Delete</h3>
	 * <p>Function prepares the query string to remove Music_Tracks
	 * where RecordingId is equal to the one passed to the function</p>
	 * <p>Function catches any SQL Exceptions, and once everything 
	 * is completed connection is closed</p>
	 * @param recordingId
	 */
	public void delete(String recordingId) {

		try {
			String queryString = "DELETE FROM Music_Tracks WHERE recording_id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
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
	/**
	 * <h3>Retrieve names from category</h3>
	 * <p>Function prepares an empty arraylist and query string</p>
	 * <p>Query string is executed and results from database are 
	 * retrieved</p>
	 * <p>Details are exctracted into the arraylist</p>
	 * <p>Function catches any SQL Exceptions, and once everything 
	 * is completed connection is closed</p>
	 * 
	 * @param catName
	 * @return
	 */
	public ArrayList<DataBean> retrieveCatNames(String catName) {
		ArrayList<DataBean> catListings = null;
		try{
			String queryString = "SELECT * FROM Music_Recordings WHERE category LIKE '" + catName + "';";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			catListings = new ArrayList<DataBean>();
			while (rs1.next()) {
				DataBean temp= new DataBean();
				temp.setRecordId(rs1.getInt("recording_id"));
				temp.setArtist(rs1.getString("artist_name"));
				temp.setCatName(rs1.getString("category"));
				temp.setTitle(rs1.getString("title"));
				temp.setImg(rs1.getString("image_name"));
				temp.setTracks(rs1.getInt("num_tracks"));
				temp.setPrice(rs1.getFloat("price"));
				temp.setStock(rs1.getInt("stock_count"));
				catListings.add(temp);
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
		return catListings;
	}
	/**
	 * <h3>Retrieve Single track</h3>
	 * <p>Function prepares an empty arraylist and query string</p>
	 * <p>Query string is executed and Music Tracks details are
	 * exctracted from the database and saved in the arraylist</p>
	 * <p>Function catches any SQL Exceptions, and once everything 
	 * is completed connection is closed</p>
	 * @param recId
	 * @return
	 */
	public ArrayList<DataBean> retrieveSingle(String recId) {
		ArrayList<DataBean> singleList = null;
		try{
			String queryString = "SELECT * FROM Music_Tracks WHERE recording_id = " +recId + ";";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			singleList = new ArrayList<DataBean>();
			while (rs1.next()) {
				DataBean temp= new DataBean();
				temp.setSingleDuration(rs1.getInt("duration"));
				temp.setSingleId(rs1.getInt("id"));
				temp.setSingleTitle(rs1.getString("title"));
				temp.setRecordId(rs1.getInt("recording_id"));
				singleList.add(temp);
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
		return singleList;
	}
	/**
	 * <h3>Retrieve all Category names</h3>
	 * @return
	 */
	public ArrayList<DataBean> retrieveCategories() {
		ArrayList<DataBean> cat = null;
		
		try {
			String queryString = "SELECT * FROM Music_Categories";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			
			cat = new ArrayList<DataBean>();
			while (rs1.next()) {
				DataBean temp= new DataBean();
				temp.setCatName(rs1.getString("name"));
				cat.add(temp);
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
		return cat;
	}
//	/**
//	 * <h3>Retrieve cart items</h3>
//	 * 
//	 * @param sql
//	 * @return
//	 */
//	public ArrayList<DataBean> retrieveCartItems(String sql) {
//		ArrayList<DataBean> cartItems = null;
//		try {
//			//System.out.println(type);		
//			String queryString = "SELECT * FROM Music_Recordings WHERE recording_id IN" + sql;
//			connection = getConnection();
//			ptmt = connection.prepareStatement(queryString);
//			rs1 = ptmt.executeQuery();
//			
//			cartItems = new ArrayList<DataBean>();
//			while (rs1.next()) {
//				DataBean temp= new DataBean();
//				temp.setRecordId(rs1.getInt("recording_id"));
//				temp.setArtist(rs1.getString("artist_name"));
//				temp.setCatName(rs1.getString("category"));
//				temp.setTitle(rs1.getString("title"));
//				temp.setImg(rs1.getString("image_name"));
//				temp.setTracks(rs1.getInt("num_tracks"));
//				temp.setPrice(rs1.getFloat("price"));
//				temp.setStock(rs1.getInt("stock_count"));
//				cartItems.add(temp);
//								
//				}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs1 != null)
//					rs1.close();
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
//			
//		}
//		return cartItems;
//	}
	/**
	 * <h3>Find between price</h3>
	 * <p>Function prepares an empty arraylist and query string</p>
	 * <p>Query string is executed and Music Recording details are
	 * exctracted from the database and saved in the arraylist</p>
	 * <p>Function catches any SQL Exceptions, and once everything 
	 * is completed connection is closed</p>
	 * 
	 * 
	 * @param q
	 * @param type
	 * @return
	 */
	public ArrayList<DataBean> findBetweenPrice(String q, String type) {
		ArrayList<DataBean> prices = null;
		try {
			//System.out.println(type);
			
			
			String queryString = "SELECT * FROM Music_Recordings WHERE price BETWEEN " + q + " ORDER BY price " + type;
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			
			prices = new ArrayList<DataBean>();
			while (rs1.next()) {
				DataBean temp= new DataBean();
				temp.setRecordId(rs1.getInt("recording_id"));
				temp.setArtist(rs1.getString("artist_name"));
				temp.setCatName(rs1.getString("category"));
				temp.setTitle(rs1.getString("title"));
				temp.setImg(rs1.getString("image_name"));
				temp.setTracks(rs1.getInt("num_tracks"));
				temp.setPrice(rs1.getFloat("price"));
				temp.setStock(rs1.getInt("stock_count"));
				prices.add(temp);
								
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
		return prices;
	}
	/**
	 * <h3>Find all tracks</h3>
	 * <p>Empty arraylist is created and query string is prepared</p>
	 * <p>Query string joins 2 tables together and exctracts all the data
	 * into the arraylist</p>
	 * <p>Function catches any SQL Exceptions, and once everything 
	 * is completed connection is closed</p>
	 * 
	 * @return
	 */
	public ArrayList<DataBean> findAllTracks() {
		ArrayList<DataBean> music = null;
		try {
			String queryString = "SELECT * FROM Music_Tracks JOIN Music_Recordings";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			
			music = new ArrayList<DataBean>();
			while (rs1.next()) {
				DataBean temp= new DataBean();
				temp.setRecordId(rs1.getInt("recording_id"));
				temp.setDuration(rs1.getInt("duration"));
				temp.setArtist(rs1.getString("artist_name"));
				temp.setTitle(rs1.getString("title"));
				music.add(temp);
								
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
		return music;
	}
	public ArrayList<DataBean> retrieveRecordings(int recording) {
		ArrayList<DataBean> recordings = null;
		
		try {
			String queryString = "SELECT * FROM Music_Recordings WHERE recording_id =" + recording;
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			
			recordings = new ArrayList<DataBean>();
			while (rs1.next()) {
				DataBean temp= new DataBean();
				temp.setCatName(rs1.getString("name"));
				temp.setRecordId(rs1.getInt("recording_id"));
				temp.setArtist(rs1.getString("artist_name"));
				temp.setTitle(rs1.getString("title"));
				temp.setImg(rs1.getString("image_name"));
				temp.setTracks(rs1.getInt("num_tracks"));
				temp.setPrice(rs1.getFloat("price"));
				temp.setCatName(rs1.getString("name"));
				temp.setStock(rs1.getInt("stock_count"));
				recordings.add(temp);
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
		return recordings;
	}
	/**
	 * <h2>Search for</h2>
	 * <p>This function searches for string that was passed from Musicsearch and checks
	 * if any column is like the search term, if it is add to the bean.</p>
	 * 
	 * @param search
	 * @return
	 */
	public ArrayList<DataBean> searchFor(String search) {
		ArrayList<DataBean> music = null;
		try {
			String queryString = "SELECT * FROM Music_Recordings WHERE recording_id"
					+ " LIKE '%" + search + "%' OR artist_name LIKE '"+search + "%' OR title LIKE '"+search+
					"%' OR category LIKE '" + search  + "%'";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();
			
			music = new ArrayList<DataBean>();
			while (rs1.next()) {
				DataBean temp= new DataBean();
				temp.setRecordId(rs1.getInt("recording_id"));
				temp.setArtist(rs1.getString("artist_name"));
				temp.setTitle(rs1.getString("title"));
				temp.setCatName(rs1.getString("category"));
				temp.setImg(rs1.getString("image_name"));
				temp.setTracks(rs1.getInt("num_tracks"));
				temp.setPrice(rs1.getFloat("price"));
				temp.setStock(rs1.getInt("stock_count"));
				music.add(temp);
								
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
		return music;
	}
}