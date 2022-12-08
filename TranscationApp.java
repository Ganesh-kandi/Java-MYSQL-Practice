package thirdProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import jdbcConnection.jdbconnectionn;

public class TranscationApp {

	public static void main(String[] args) throws SQLException, IOException {
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		ResultSet resultSet1=null;
		Scanner sc= new Scanner(System.in);
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\ganes\\eclipse-workspace\\thirdProject\\src\\file1");
		prop.load(fis);
		
		String url=prop.getProperty("url");
		String user=prop.getProperty("user");
		String password=prop.getProperty("password");
		connection= DriverManager.getConnection(url, user,password);
		
		if(connection!=null) {
			
			statement=connection.createStatement();
			
			resultSet= statement.executeQuery("select * from account");
			System.out.println("Name\tBalance");
			while(resultSet.next()) {
				
				System.out.println(resultSet.getString(1)+ "\t"+ resultSet.getInt(2));
			}
			
			connection.setAutoCommit(false);
			statement.executeUpdate("update account set balance=balance-1000 where name='mohit'");
			statement.executeUpdate("update account set balance=balance+1000 where name='ganesh'");
		}
		System.out.println("enter yes for 3000 rupess transcation...");
		String option=sc.next();
		if(option.equalsIgnoreCase("yes")) {
			connection.commit();
			System.out.println("transcation successfulll....");
		}
		else {
			connection.rollback();
			System.out.println("transcation is unsuccessfull....");
		}
		
		resultSet1=statement.executeQuery("select *from account");
		System.out.println("Name\tBalance");
		while(resultSet1.next()) {
			
			System.out.println(resultSet1.getString(1)+ "\t"+ resultSet1.getInt(2));
		}

	}

}
