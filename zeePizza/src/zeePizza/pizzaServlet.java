package zeePizza;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class pizzaServlet
 */
public class pizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pizzaServlet() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn; 
		
		try {
			conn = zeePizza.dbConnect.Connect();//connect
			HttpSession session=request.getSession();//gets session variable
			String query = "insert into Orders (CustomerID, ProductID, Quantity, ServerID, DriverID, CookID) values (?, ?, ?, 4, 3, 2)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			//prepared statement to insert into order
			
			pstmt.setInt(1, (Integer)session.getAttribute("customerID"));
			pstmt.setInt(2, Integer.parseInt(request.getParameter("Pizza1")));
			pstmt.setInt(3, Integer.parseInt(request.getParameter("quantity")));
			pstmt.executeUpdate();
			pstmt.close();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter(); //writer object
			//gives link to return to order
			out.print("<!Doctype html>\n" +
					"<html>\n" + "<head><title>Success</title></head>\n"
					+ "<body>\n" + "<h1>Order Success!  To order more, go to order</h1>\n" + 
					"</body>\n" + 
					"<ul>" + 
					"<h1>Thank you "+ session.getAttribute("firstName") +  " " + session.getAttribute("lastName")+ "</br>" +
					"<a href='order.jsp'>Return to order</a>" + 
					"</body>\n" + 
					"</html>"
					);
		}
		catch (ClassNotFoundException | SQLException e){
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
