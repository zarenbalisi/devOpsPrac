package zeePizza;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnect {
	private static Connection conn = null;
	
	public static Connection Connect() throws ClassNotFoundException, SQLException{
		
		if(conn!=null){
			return conn;
		}else{

			String driver = "oracle.jdbc.oracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String username = "ZeePizza";
			String password = "admin";
			
			

			conn = DriverManager.getConnection(url, username, password);
			
			return conn;
		}
	}
}
