import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Model {
	private String unameString;
	private String upassString;
	private String ucityString;
	private String uemString;
	private Connection connection;
	private PreparedStatement pStatement;
	private int row;

	public String getUnameString() {
		return unameString;
	}
	public void setUnameString(String unameString) {
		this.unameString = unameString;
	}
	public String getUpassString() {
		return upassString;
	}
	public void setUpassString(String upassString) {
		this.upassString = upassString;
	}
	public String getUcityString() {
		return ucityString;
	}
	public void setUcityString(String ucityString) {
		this.ucityString = ucityString;
	}
	public String getUemString() {
		return uemString;
	}
	public void setUemString(String uemString) {
		this.uemString = uemString;
	}
	
	public int register() {
		try {
			connection = JdbcUtil.getDBConnection();
			String sql = "INSERT INTO register (uname, email, upassword, city) VALUES (?, ?, ?, ?)";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, unameString);
			pStatement.setString(2, uemString);
			pStatement.setString(3, upassString);
			pStatement.setString(4, ucityString);
			
			row = pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// FIXED: Pass connection and statement into close method
			JdbcUtil.close(connection, pStatement);
		}
		return row;
	}
}