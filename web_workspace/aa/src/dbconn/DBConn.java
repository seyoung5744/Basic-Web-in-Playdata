package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; 
	static final String DB_URL = "jdbc:mysql://localhost:3306/testdb?&useSSL=false"; 
//	static final String DB_URL = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC&useSSL=false";
	private static DBConn db = new DBConn();
	
	private DBConn() {}
	
	public static DBConn getInstance() {
		return db;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, "root", "won9975744!");
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}


