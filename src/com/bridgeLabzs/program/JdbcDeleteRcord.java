package com.bridgeLabzs.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDeleteRcord {
			public static void main(String[] args) {
				System.out.println("Program Started");
				Statement statement=null;
				Connection connection=null;
				String qurey=" delete from program1.Student where StudentId=124";
				//String qurey ="update program1.Student set StudentName='tekchand' where StudentId=14";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Classs Loaded");
				  	try {
						connection=DriverManager.getConnection("jdbc:mysql://localhost/program1", "root", "101023");
						System.out.println("Established Connection");
						statement=connection.createStatement();
						System.out.println("PlatForm Created ");
						statement.execute(qurey);
						System.out.println("Data Deleted");
						System.out.println("PlatForm Created ");
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					if(statement!=null)
					{
						try {
							statement.close();
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
