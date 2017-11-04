package com.bridgeLabzs.program;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageProgram {
		public static void main(String[] args) {
			System.out.println("Program Started ");
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			String query="insert into program1.image values(?,?) ";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection=DriverManager.getConnection("jdbc:mysql://localhost/program1", "root", "101023");
				preparedStatement=connection.prepareStatement(query);
				preparedStatement.setString(1, "Rakesh");
				FileInputStream fin=new FileInputStream("/home/brideit/Downloads/images.jpeg");
				preparedStatement.setBinaryStream(2, fin, fin.available());
				int i=preparedStatement.executeUpdate();
				System.out.println(i+" query Excuite");
				connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			System.out.println("Program Ended");
		
		}
}
