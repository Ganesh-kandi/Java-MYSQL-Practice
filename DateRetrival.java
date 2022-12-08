package thirdProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import jdbcConnection.jdbconnectionn;

public class DateRetrival {

	public static void main(String[] args) throws SQLException {
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the Name::");
		String SID=sc.next();
		
		try {
			connection= jdbconnectionn.getJdbcConnection();
			
			if(connection!=null) {
				String SqlQuery="select SID,DOB from userdata where SID = ?";
				pstmt=connection.prepareStatement(SqlQuery);
				
				if(pstmt!=null) {
					pstmt.setString(1, SID);
					resultSet= pstmt.executeQuery();
					
					if(resultSet!=null) {
						if(resultSet.next()) {
						String userName=resultSet.getString(1);
						java.sql.Date sdate= resultSet.getDate(2);
						
							SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
							String date=sdf.format(sdate);
							
							System.out.println("User name::"+userName);
							System.out.println("DOB      :: "+date);
							
					}
					}else
						System.out.println("no record found..");
					
				}
				
				
			}
			
			
			
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		jdbconnectionn.closeConnection(resultSet, pstmt, connection);

	}

}
