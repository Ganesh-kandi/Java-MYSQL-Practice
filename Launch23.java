package thirdProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Driver;
public class Launch23 {

	public static void main(String[] args) throws SQLException {
		
		String url="jdbc:mysql://localhost:3306/ganesh";
		String user="root";
		String password="root123";
		Connection connection=DriverManager.getConnection(url, user, password);
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select * from employee");
		
//		insert into SQL
//		int resultSet=statement.executeUpdate("insert into student(`stdId`,`stdName`,`Marks`) values (34,'kandiganesh',45)");
//		System.out.println("the number of rows effected: "+resultSet);
		
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("idEmployee")+"\t"+ resultSet.getString("EmployeeName")+ "\t"+ resultSet.getString("EmployeeLang"));
		}	
	}
}
