import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		System.out.println("Driver is registered");
	}
	
	public static Connection getDBConnection() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/virajdb";
		String usernameString ="root";
		String passString = "";
		
		Connection connection = DriverManager.getConnection(url, usernameString, passString);
		return connection;
		
	}
	
	public static void close(AutoCloseable... resources) {
		for (AutoCloseable resource : resources) {
			if (resource != null) {
				try {
					resource.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
