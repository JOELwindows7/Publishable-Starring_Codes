import java.sql.*;


public class DB {

	Connection con;
	
	public DB() {
		//design pattern
		//singleton
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/viconbad", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
