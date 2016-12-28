package zeePizza;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
public class employeeLoginServlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn; 
		try {
			 
			conn = zeePizza.dbConnect.Connect();
			Statement st = conn.createStatement();
			ResultSet rs;
			//checks if person exists in database, and if the password matches
			//to incorporate a better password I would hash and salt the password
			rs = st.executeQuery("select * from Employee where UPPER(email) = '" + request.getParameter("empEmail").toUpperCase()
					+ "' and password = '" + request.getParameter("empPassword") + "'");
			//declares session variables
		    if (rs.next()) {
		    	HttpSession session=request.getSession(true);
		    	session.setAttribute("employeeID", rs.getInt(1));
		        session.setAttribute("empFirstName", rs.getRowId(2));
		        session.setAttribute("empLastName", rs.getRowId(3));
		        session.setAttribute("employeeEmail", request.getParameter("empEmail"));
		        session.setAttribute("employeePassword", request.getParameter("empPassword"));
		        response.sendRedirect("pizzaEmpPortal.jsp");
		    }
		    else{
		    	HttpSession session = request.getSession(false);
		    	response.sendRedirect("pizzaEmployeeHome.jsp");
		    }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
