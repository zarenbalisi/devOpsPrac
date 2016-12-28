package zeePizza;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registerServlet
 */
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private customerDao cd;
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			cd = new customerDao();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	try {
		customerDao.insertIntoCustomer(new customerPojo(request.getParameter("firstName"),request.getParameter("lastName"),request.getParameter("address"), 
				Integer.parseInt(request.getParameter("locationID")),
				request.getParameter("phone"), request.getParameter("password"),request.getParameter("email")));
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<!Doctype html>\n" +
				"<html>\n" + "<head><title>Success</title></head>\n"
				+ "<body>\n" + "<h1>Registration Success!  Please go to log in on home page</h1>\n" + 
				"</body>\n" + 
				"<ul>" + 
				"<h1>Thank you "+ request.getParameter("firstName") +  " " + request.getParameter("lastName")+ "</br>" +
				"<a href='pizzaHome.jsp'>Return Home</a>" + 
				"</body>\n" + 
				"</html>"
				);
	} catch (IllegalArgumentException | SQLException e) {
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
