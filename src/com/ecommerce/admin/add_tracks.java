package com.ecommerce.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.DataBean;
import com.ecommerce.dao.DataDAO;

/**
 * Servlet implementation class add_tracks
 */
@WebServlet("/add_tracks")
public class add_tracks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_tracks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * <h2>Add new track</h2>
	 * <p>One of many functions introduced for admin panel,
	 * this one allows user to add new track.</p>
	 * <p>Database layout was left intact, so unfortunately user has to specify
	 * both ID and Recording_Id</p>
	 * <h4>Way of operation</h4>
	 * <ul>
	 * <li>Parameters are exctracted from the url</li>
	 * <li>String(ID, Recording Id and Duration) variables are converted into INT</li>
	 * <li>New bean is called</li>
	 * <li>Data DAO is called</li>
	 * <li>Bean is populated with the variables</li>
	 * <li>DAO function "addTracks" is called and Bean object is passed</li>
	 * <li>Request Dispatcher returns successful message "?m=s"</li>
	 * </ul>
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		int id_tr = Integer.parseInt(id);
		String recording_id = request.getParameter("recording_id");
		int re_tr = Integer.parseInt(recording_id);

		String title = request.getParameter("title");
		
		String duration = request.getParameter("duration");
		int du_tr = Integer.parseInt(duration);
		DataBean bean = new DataBean();
		DataDAO dao = new DataDAO();
		bean.setRecordId(re_tr);
		bean.setTitle(title);
		bean.setDuration(du_tr);
		bean.setSingleId(id_tr);
		dao.addTracks(bean);
		 RequestDispatcher rd = request
                 .getRequestDispatcher("/add_new_track.jsp?m=s");
         rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
