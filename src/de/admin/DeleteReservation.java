/**
 * Sara Viktoria Miller
 */
package de.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/deletereservation")
public class DeleteReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup="jdbc/MyTHIPool")
	private DataSource ds;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.valueOf(request.getParameter("ReservierungID"));
		if(id != 0) {
			loeschen(id);
		}
		final RequestDispatcher dispatcher = request.getRequestDispatcher("/adminreserveservlet");
		dispatcher.forward(request, response);
	}
       
	private void loeschen(int id) throws ServletException {
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("DELETE FROM thidb.platzreservierung WHERE ReservierungID = ?")){
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}