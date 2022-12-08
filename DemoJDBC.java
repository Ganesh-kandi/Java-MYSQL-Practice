package thirdProject;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import jdbcConnection.jdbconnectionn;

public class DemoJDBC {
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] a) throws SQLException 
	{
//		System.out.print("Enter the name of the Table:: ");
//		TableName=sc.next();
		System.out.print("Enter the SId:: ");
		String SId=sc.next();
		System.out.print("Enter the SName:: ");
		String SName=sc.next();
		System.out.print("Enter the SRollNo:: ");
		String SRollNo=sc.next();
		System.out.print("Enter the SGrade:: ");
		String SGrade=sc.next();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		String SqlQuery="insert into student1(`SId`,`SName`,`SRollNo`,`SGrade`) values(?,?,?,?)";
		try {
			connection= jdbconnectionn.getJdbcConnection();
			if(connection!=null) 
				pstmt=connection.prepareStatement(SqlQuery);
			if(pstmt!=null) {
				pstmt.setString(1, SId);
				pstmt.setString(2, SName);
				pstmt.setString(3, SRollNo);
				pstmt.setString(4, SGrade);
				
				int noOfRows=pstmt.executeUpdate();
				System.out.println("no of rows affected:: "+noOfRows);
			}
		
		}catch(SQLException se) {
			se.printStackTrace();
		
		}finally {
			jdbconnectionn.closeConnection(null, pstmt, connection);
		}
		
	}	
	
	
	
	
//	public void read() {
//		String url="jdbc:mysql://localhost:3306/ganesh";
//		String user="root";
//		String password="root123";
//		try {
//		Connection connection=DriverManager.getConnection(url, user, password);
//			if(connection!=null) {
//				Statement statement=connection.createStatement();
//					if(statement!=null) {
//					String createSQLquary=("select * from "+TableName+"");               
//					//create table student1()
//						ResultSet resultSet=statement.executeQuery(createSQLquary);
//						if(resultSet!=null) {
//							System.out.println( SId+"\t"+ SName +"\t"+ SRollNo +"\t"+ SGrade);
//						while (resultSet.next()) {
//							System.out.println(resultSet.getInt(SId)+"\t"+ resultSet.getString(SName)+ "\t"+ resultSet.getString(SRollNo)+"\t" + resultSet.getString(SGrade));
//						}
//					}
//			}
//		}
//	}
//		catch(SQLException se) {
//			se.printStackTrace();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	//,(3,'Mohith','17a51a0323','O'),(4,'Leela','17a51a0324','B')
//	//(`+SId`,`SName`,`SRollNo`,`SGrade`)
//	
//	public void update() {
//		String url="jdbc:mysql://localhost:3306/ganesh";
//		String user="root";
//		String password="root123";
//		
//		System.out.print("Enter "+SId+" of the student:: ");
//		String SId=sc.next();
//		System.out.print("Enter "+SName+" of the student:: ");
//		String SName=sc.next();
//		System.out.print("Enter "+SRollNo+" of the student:: ");
//		String SRollNo=sc.next();
//		System.out.print("Enter "+SGrade+" of the student:: ");
//		String SGrade=sc.next();
//		
//		try {
//		Connection connection=DriverManager.getConnection(url, user, password);
//			if(connection!=null) {
//				Statement statement=connection.createStatement();
//					if(statement!=null) {
//					//String createSQLquary=("insert into student1(`SId`,`SName`,`SRollNo`,`SGrade`) values(4,'Leela','17a51a0324','B')"); 
//						String createSQLquary=String.format("insert into "+TableName+" values('%s','%s','%s','%s')", SId,SName,SRollNo,SGrade);
//					//create table student1()
//						int resultSet=statement.executeUpdate(createSQLquary);
//						System.out.print("No of rows Affected: "+resultSet);
//					}
//			}
//		}
//		catch(SQLException se) {
//			se.printStackTrace();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	public void delete() {
//		String url="jdbc:mysql://localhost:3306/ganesh";
//		String user="root";
//		String password="root123";
//		System.out.print("Enter the "+SId+" to delete::");
//		int removeID=sc.nextInt();
//		try {
//		Connection connection=DriverManager.getConnection(url, user, password);
//			if(connection!=null) {
//				Statement statement=connection.createStatement();
//					if(statement!=null) {
//					//String createSQLquary=("delete from student1 where SId=4"); 
//						String SqlQuary= String.format("delete from "+TableName+" where SId='%s'", removeID);
//					//create table student1()
//						int resultSet=statement.executeUpdate(SqlQuary);
//						System.out.print("no of rows effected: "+resultSet);
//					}
//			}
//		}
//		catch(SQLException se) {
//			se.printStackTrace();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
//
//public class LaunchJdbc1 {
//	static Scanner sc=new Scanner(System.in);
//	static JdbcAssignment com=new JdbcAssignment();
//	public static void main(String[] args) throws SQLException {
//		
//		System.out.println("welcome to Sql Application.....");
//		System.out.println("-------------------------------");
//		printActions();
//		boolean temp=true;
//		while(temp) {
//		int option=sc.nextInt();
//		switch(option) {
//		case 1:
//			LaunchJdbc1.printActions();
//			break;
//		case 2:
//			com.create();
//			break;
//		case 3:
//			com.update();
//			break;
//		case 4:
//			com.delete();
//			break;
//		case 5:
//			com.update();
//			break;
//		case 6:
//			com.read();
//			break;
//		case 7:
//			temp =false;
//			System.out.println("THANK YOU");
//		}
//	}
//	}
//	public static void printActions() {
//		System.out.println(""
//				+ "1: To know the options what we have there.\n"
//				+ "2: Create table.\n"
//				+ "3: Insert data to the table.\n"
//				+ "4: Delete data from the table.\n"
//				+ "5: Update data to table\n"
//				+ "6: Show the table.\n"
//				+ "7: exit from the Application.");
//	}
	

}
