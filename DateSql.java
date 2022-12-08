package thirdProject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import jdbcConnection.jdbconnectionn;

public class DateSql {
	static Scanner sc=new Scanner(System.in);
	static Connection connection=null;
	static PreparedStatement pstmt=null;
	static ResultSet resultSet=null;
	public static void main(String[] args) throws SQLException, ParseException {
		
		//ResultSet resultSet=null;
		
		System.out.print("Enter your Name:: ");
		String name=sc.next();
		System.out.print("Enter your DOB::(dd-mm-yyyy) ");
		String dob=sc.next();
		
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate=sdf.parse(dob);
		long sdate=udate.getTime();
		java.sql.Date sqldate=new Date(sdate);
		try {
		connection=jdbconnectionn.getJdbcConnection();
		if(connection!=null) {
			String sqlQuery="insert into userdata(`SID`,`DOB`) values(?,?)";
			pstmt=connection.prepareStatement(sqlQuery);
			pstmt.setString(1, name);
			pstmt.setDate(2, sqldate);
			int rowsAffected=pstmt.executeUpdate();
			System.out.println("No of rows affected:: "+rowsAffected);
		}
		
		
		
		}catch(SQLException se) {
			se.printStackTrace();
		}
		jdbconnectionn.closeConnection(null, pstmt, connection);
	
		

	}

}
