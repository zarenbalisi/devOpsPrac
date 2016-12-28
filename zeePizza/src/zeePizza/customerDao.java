package zeePizza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class customerDao {
	static Connection conn; 
	
	public customerDao() throws ClassNotFoundException, SQLException {
		conn = zeePizza.dbConnect.Connect();

		
	}
	public static void insertIntoCustomer(customerPojo cust) throws SQLException{
		
		try{
			String query = "insert into Customer (firstName, lastName, address, locationID, phone, password, email) values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			 pstmt.setString(1,cust.getFirstName());
			 pstmt.setString(2,cust.getLastName());
			 pstmt.setString(3,cust.getAddress());
			 pstmt.setInt(4,cust.getLocationID());
			 pstmt.setString(5,cust.getPhone());
			 pstmt.setString(6,cust.getPassword());
			 pstmt.setString(7,cust.getEmail());
			 pstmt.executeUpdate(); // execute insert statement
			 //takes a customer object and insert into database
			 pstmt.close();
		}
		catch (Exception e) {
		      e.printStackTrace();
		    } 
		//finally {
		      //pstmt.close();
			//if(conn!=null)
		      //conn.close();
		 //   }
	}
}
