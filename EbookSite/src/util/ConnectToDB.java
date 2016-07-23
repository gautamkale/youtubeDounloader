package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {

//	public Connection DBConnnect() {
		public static void main(String[] args)
		{
		Connection conn = null;
		final String URL = "jdbc:mysql://localhost:3306/techlife_Ebook";
		final String USER = "techlife_ebook";
		final String PASSWORD = "samyak";
		final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
		try {
		 
			Class.forName(DRIVER_CLASS);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		}catch (SQLException e) {
		
			System.out.println("ERROR: Unable to Connect to Database.");
			e.printStackTrace();
		}

		//return conn;

	}
	//}
}
