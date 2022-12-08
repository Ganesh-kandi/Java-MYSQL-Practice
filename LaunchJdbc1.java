package thirdProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class JdbcAssignment{
	static Scanner sc=new Scanner(System.in);
	String TableName;
	String SId;
	String SName;
	String SRollNo;
	String SGrade;
	public void create() throws SQLException 
	{
		
		String url="jdbc:mysql://localhost:3306/ganesh";
		String user="root";
		String password="root123";
		
		System.out.print("Enter the name of the Table:: ");
		TableName=sc.next();
		System.out.print("Enter the Name of the first column:: ");
		SId=sc.next();
		System.out.print("Enter the Name of the second column:: ");
		SName=sc.next();
		System.out.print("Enter the name of the third column:: ");
		SRollNo=sc.next();
		System.out.print("Enter the name of the Fourth column:: ");
		SGrade=sc.next();
		
		try {
		Connection connection=DriverManager.getConnection(url, user, password);
			if(connection!=null) {
				Statement statement=connection.createStatement();
					if(statement!=null) {
					String createSQLquary=String.format("create table `%s` (`%s` INT,`%s` VARCHAR(20),`%s` VARCHAR(10),`%s` VARCHAR(10))",TableName,SId,SName,SRollNo,SGrade);               
					//create table student1()
						//String createSQLquary="create table "+TableName+" (SId INT,SName VARCHAR(20),SRollNo VARCHAR(10),SGrade VARCHAR(2))";
						int resultSet=statement.executeUpdate(createSQLquary);
						System.out.println("No of rows Affected: "+resultSet);
					}
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}	
	
	public void read() {
		String url="jdbc:mysql://localhost:3306/ganesh";
		String user="root";
		String password="root123";
		try {
		Connection connection=DriverManager.getConnection(url, user, password);
			if(connection!=null) {
				Statement statement=connection.createStatement();
					if(statement!=null) {
					String createSQLquary=("select * from "+TableName+"");               
					//create table student1()
						ResultSet resultSet=statement.executeQuery(createSQLquary);
						if(resultSet!=null) {
							System.out.println( SId+"\t"+ SName +"\t"+ SRollNo +"\t"+ SGrade);
						while (resultSet.next()) {
							System.out.println(resultSet.getInt(SId)+"\t"+ resultSet.getString(SName)+ "\t"+ resultSet.getString(SRollNo)+"\t" + resultSet.getString(SGrade));
						}
					}
			}
		}
	}
		catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//,(3,'Mohith','17a51a0323','O'),(4,'Leela','17a51a0324','B')
	//(`+SId`,`SName`,`SRollNo`,`SGrade`)
	
	public void update() {
		String url="jdbc:mysql://localhost:3306/ganesh";
		String user="root";
		String password="root123";
		
		System.out.print("Enter "+SId+" of the student:: ");
		String SId=sc.next();
		System.out.print("Enter "+SName+" of the student:: ");
		String SName=sc.next();
		System.out.print("Enter "+SRollNo+" of the student:: ");
		String SRollNo=sc.next();
		System.out.print("Enter "+SGrade+" of the student:: ");
		String SGrade=sc.next();
		
		try {
		Connection connection=DriverManager.getConnection(url, user, password);
			if(connection!=null) {
				Statement statement=connection.createStatement();
					if(statement!=null) {
					//String createSQLquary=("insert into student1(`SId`,`SName`,`SRollNo`,`SGrade`) values(4,'Leela','17a51a0324','B')"); 
						String createSQLquary=String.format("insert into "+TableName+" values('%s','%s','%s','%s')", SId,SName,SRollNo,SGrade);
					//create table student1()
						int resultSet=statement.executeUpdate(createSQLquary);
						System.out.print("No of rows Affected: "+resultSet);
					}
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void delete() {
		String url="jdbc:mysql://localhost:3306/ganesh";
		String user="root";
		String password="root123";
		System.out.print("Enter the "+SId+" to delete::");
		int removeID=sc.nextInt();
		try {
		Connection connection=DriverManager.getConnection(url, user, password);
			if(connection!=null) {
				Statement statement=connection.createStatement();
					if(statement!=null) {
					//String createSQLquary=("delete from student1 where SId=4"); 
						String SqlQuary= String.format("delete from "+TableName+" where SId='%s'", removeID);
					//create table student1()
						int resultSet=statement.executeUpdate(SqlQuary);
						System.out.print("no of rows effected: "+resultSet);
					}
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

public class LaunchJdbc1 {
	static Scanner sc=new Scanner(System.in);
	static JdbcAssignment com=new JdbcAssignment();
	public static void main(String[] args) throws SQLException {
		
		System.out.println("welcome to Sql Application.....");
		System.out.println("-------------------------------");
		printActions();
		boolean temp=true;
		while(temp) {
		int option=sc.nextInt();
		switch(option) {
		case 1:
			LaunchJdbc1.printActions();
			break;
		case 2:
			com.create();
			break;
		case 3:
			com.update();
			break;
		case 4:
			com.delete();
			break;
		case 5:
			com.update();
			break;
		case 6:
			com.read();
			break;
		case 7:
			temp =false;
			System.out.println("THANK YOU");
		}
	}
	}
	public static void printActions() {
		System.out.println(""
				+ "1: To know the options what we have there.\n"
				+ "2: Create table.\n"
				+ "3: Insert data to the table.\n"
				+ "4: Delete data from the table.\n"
				+ "5: Update data to table\n"
				+ "6: Show the table.\n"
				+ "7: exit from the Application.");
	}
	

}
