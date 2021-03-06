/**
 * Sara Viktoria Miller
 */
package de.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javabeans.ContactBean;

@WebServlet("/adminemailservlet") 

public class AdminEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup="jdbc/MyTHIPool")
	private DataSource ds;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		List<ContactBean> kontakte = read(); 
		request.setAttribute("kontakte", kontakte);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("/home/jsp/adminEmail.jsp");
		dispatcher.forward(request, response);	
	}

	protected List<ContactBean> read() throws ServletException{
		List<ContactBean> kontakte = new ArrayList<ContactBean>(); 
		try(Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM thidb.Kontakt ORDER BY Status, KontaktID ASC")){
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					ContactBean cb = new ContactBean(); 
					cb.setId(rs.getInt("KontaktID")); 
					cb.setBetreff(rs.getString("Betreff"));
					cb.setNachricht(rs.getString("Nachricht"));
					cb.setName(rs.getString("Name"));
					cb.setEmail(rs.getString("EMail"));
					cb.setStatus(rs.getBoolean("Status"));
					kontakte.add(cb); 
				}
				
			}
		}catch(Exception ex) {
			throw new ServletException(ex.getMessage()); 
		}
		return kontakte; 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}       
}