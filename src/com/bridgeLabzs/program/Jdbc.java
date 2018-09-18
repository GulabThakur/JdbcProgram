package com.bridgeLabzs.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bridgeLabzs.utility.utility;

public class Jdbc {
				public static void main(String[] args) {
					System.out.println("Program Started");
					String query="insert into program1.Student values(?,?,?,?,?);";
				        PreparedStatement preparedStatement=null;
					Connection connection=null;
					try {
						Class.forName("com.mysql.jdbc.Driver");
						connection=DriverManager.getConnection("jdbc:mysql://localhost/program1", "root", "101023");
						preparedStatement=connection.prepareStatement(query);
						preparedStatement.setInt(1, 1201);
						preparedStatement.setString(2, "rqqqju");
						preparedStatement.setString(3, "Ghuqtu@yy.com");
						preparedStatement.setInt(4, 5500644);
						preparedStatement.setString(5, "M");
						preparedStatement.execute();
						System.out.println("Second Will we excuted");
						//preparedStatement=connection.prepareStatement(query);
						preparedStatement.execute();
						System.out.println("Data stored");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					System.out.println("Please Enter the ");
					
					System.out.println("Program Ended");
				}
}
