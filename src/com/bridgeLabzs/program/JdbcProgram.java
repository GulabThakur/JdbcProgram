package com.bridgeLabzs.program;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcProgram {
	public static void main(String[] args) {
		System.out.println("Program Started");
	    Scanner scanner=new Scanner(System.in);
	    System.out.println("Please Enter the id");
	    int id=scanner.nextInt();
	    System.out.println("Please Enter the name");
	    String name=scanner.next();
	    System.out.println("Please Enter the EmailId ");
	    String emial=scanner.next();
	    System.out.println("Please Enter the Number ");
	    long number=scanner.nextLong();
	    System.out.println("Please Enter the Gender");
	    String gender=scanner.next();
		try {
			Statement statement = null;
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			try {
				String query = "insert into program1.Student values('"+id+"','"+name+"','"+emial+"','"+number+"','"+gender+"')";
				con = DriverManager.getConnection("jdbc:mysql://localhost/program1", "root", "101023");
				statement = con.createStatement();
				System.out.println("PlatForm created");
				System.out.println("Connection Established");
				statement.execute(query);
				System.out.println("Data store");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Program Ended");
	}
}
