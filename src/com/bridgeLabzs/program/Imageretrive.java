package com.bridgeLabzs.program;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Blob;

/**
 * @author Gulab Thakur
 * @ this class using store image into 
 *
 */
public class Imageretrive {
				public static void main(String[] args) {
					System.out.println("Program Started");
					PreparedStatement preparedStatement=null;
					Connection connection=null;
					String query="select * from program1.image";
					try {
						Class.forName("com.mysql.jdbc.Driver");
						connection=DriverManager.getConnection("jdbc:mysql://localhost/program1", "root", "101023");
						preparedStatement=connection.prepareStatement(query);
						ResultSet resultSet=preparedStatement.executeQuery();
						if(resultSet.next())
						{
							Blob b=(Blob) resultSet.getBlob(2);
							byte brr[] =b.getBytes(1,(int) b.length());
							FileOutputStream fout=new FileOutputStream("/home/brideit/Gulab Thakur/sonoo.jpg");
							fout.write(brr);
							fout.close();
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					finally
					{
						if(preparedStatement!=null)
						{
							try {
								preparedStatement.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(connection!=null)
						{
							try {
								connection.close();
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					System.out.println("Program Ended ");
				}
}
