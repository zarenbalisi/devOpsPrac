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
public class loginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn; 
		try {
			//connect to database, and checks if customer exists, and if password matches
			conn = zeePizza.dbConnect.Connect();
			Statement st = conn.createStatement();
			ResultSet rs;
			rs = st.executeQuery("select * from Customer where UPPER(email) = '" + request.getParameter("Email").toUpperCase()
					+ "' and password = '" + request.getParameter("Password") + "'");
		    if (rs.next()) {
		    	HttpSession session=request.getSession(true);
		    	session.setAttribute("customerID", rs.getInt(1));
		        session.setAttribute("firstName", rs.getRowId(2));
		        session.setAttribute("lastName", rs.getRowId(3));
		        session.setAttribute("email", request.getParameter("Email"));
		        session.setAttribute("password", request.getParameter("Password"));
		        response.sendRedirect("pizzaHome.jsp");
		        
		    }
		    else{
		    	HttpSession session = request.getSession(false);
		    	response.sendRedirect("pizzaHome.jsp");
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
