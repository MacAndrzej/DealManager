package info.deal.TestConnectionDb;

import java.sql.Connection;
import java.sql.DriverManager;

/*This class tests connection to the Database.*/

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl="jdbc:postgresql://localhost:5432/DealCollection?useSSL=false";
		String user="postgres";
		String password="@ndrzej";
		
		
		try {
			
			System.out.println("Connecting to database: "+jdbcUrl);
			
			Connection myConn=DriverManager.getConnection(jdbcUrl,user,password);
			
			System.out.println("Connection successful.");
			
		}
		catch(Exception e) {
			System.out.println("Connection doesn't set.");
			e.printStackTrace();
		}
		
	}

}
