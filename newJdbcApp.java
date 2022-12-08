package thirdProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;

import jdbcConnection.jdbconnectionn;

public class newJdbcApp {

	public static void main(String[] args) throws IOException  {
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		FileWriter writer=null;
		String name="ganesh";
		String SqlQuery="select name,text from textsql where name=?";
		
		try {
			connection= jdbconnectionn.getJdbcConnection();			
			if(connection!=null) {
				
				pstmt= connection.prepareStatement(SqlQuery);
				if(pstmt!=null) {
					pstmt.setString(1, name);
					resultSet= pstmt.executeQuery();
					if(resultSet!=null) {
						if(resultSet.next()) {
							
							String username= resultSet.getString(1);
							Reader reader= resultSet.getCharacterStream(2);
							File file =new File("ganesh.txt");
							writer = new FileWriter(file);	
							int noofbytes=IOUtils.copy(reader, writer);
							writer.flush();
							System.out.println("successfully inserted.....");
							
						}
					}
				}
				
			}
			} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			jdbconnectionn.closeConnection(null, pstmt, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			jdbconnectionn.closeConnection(null, pstmt, connection);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void Imagesetter() throws FileNotFoundException {
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		String SqlQuery="insert into photlab(`name`,`image`) values(?,?)";
		try {
		connection=jdbconnectionn.getJdbcConnection();
			if(connection!=null) {
				pstmt=connection.prepareStatement(SqlQuery);
				
				if(pstmt!=null) {
					pstmt.setString(1, "ganesh");
					
					File file=new File("ganesh.jpg");
					FileInputStream fis=new FileInputStream(file);
					pstmt.setBlob(2, fis);
					
					System.out.println("inserting image from :: "+file.getAbsolutePath());
					int nofoRows=pstmt.executeUpdate();
					System.out.println("no of rows affected :: "+nofoRows);
				}
			}
		
		}catch(SQLException se) {
			se.printStackTrace();
		}
		try {
			jdbconnectionn.closeConnection(null, pstmt, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void blobRetrival() throws IOException {
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		String name="ganesh";
		String SqlQuery="select name,image from photlab where name=?";
		try {
		connection=jdbconnectionn.getJdbcConnection();
			if(connection!=null) {
				pstmt=connection.prepareStatement(SqlQuery);
					if(pstmt!=null) {
						pstmt.setString(1, name);
						
						resultSet= pstmt.executeQuery();
						if(resultSet!=null) {
							if(resultSet.next()) {
							String Username=resultSet.getString(1);
							
							InputStream is= resultSet.getBinaryStream(2);
							FileOutputStream fos=new FileOutputStream("ganesh.jpg");
							
							byte[] b=new byte[2048];
							while(is.read(b)>0) {
								fos.write(b);
							}
							fos.flush();
							
						}
						}else
							System.out.println("no record found with that name...");
						
					}
			}
		
		}catch(SQLException se) {
			se.printStackTrace();
		}
		try {
			jdbconnectionn.closeConnection(resultSet, pstmt, connection);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void fileRetrival() throws IOException {
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		FileWriter writer=null;
		String name="ganesh";
		String SqlQuery="select name,text from textsql where name=?";
		
		try {
			connection= jdbconnectionn.getJdbcConnection();			
			if(connection!=null) {
				
				pstmt= connection.prepareStatement(SqlQuery);
				if(pstmt!=null) {
					pstmt.setString(1, name);
					resultSet= pstmt.executeQuery();
					if(resultSet!=null) {
						if(resultSet.next()) {
							
							String username= resultSet.getString(1);
							Reader reader= resultSet.getCharacterStream(2);
							File file =new File("ganesh.txt");
							writer = new FileWriter(file);	
							int noofbytes=IOUtils.copy(reader, writer);
							writer.flush();
							System.out.println("successfully inserted.....");
							
						}
					}
				}
				
			}
			} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			jdbconnectionn.closeConnection(null, pstmt, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			jdbconnectionn.closeConnection(null, pstmt, connection);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
