package config;
import java.sql.*;
public class JDBCConnection {
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
		String url="jdbc:sqlserver://DESKTOP-R1KFKCE\\DHILIP:1433;databaseName=pcsdb;user=sa;password=dhilipan";
		String username="sa";
		String password="dhilipan";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(url);
		
		if(conn!=null)
			System.out.println("Connected");
		else
			System.out.println("Not Connected");
		return conn;

	}
}