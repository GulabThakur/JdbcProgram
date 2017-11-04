package com.bridgeLabzs.program;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bridgeLabzs.utility.utility;
import com.mysql.jdbc.ResultSet;

public class JdbcPreparedStatment {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Program Started");
		String query;
		Connection connection = null;
		Statement statement=null;
		PreparedStatement preparedStatement = null;
		System.out
				.println("Please Enter the number for Operation \n1: Insert value into dataBase \n2: Delete Value from dataBase "
						+ "\n3: Show Data From DataBase \n4: Update inside database");
		int option = scanner.nextInt();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/program1", "root", "101023");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch (option) {
		case 1: {
			query = "insert into program1.Student values(?,?,?,?,?);";
			try {
				preparedStatement=connection.prepareStatement(query);
				System.out.println("Please Enter the Name ");
				String name=scanner.next();
				System.out.println("Please Enter The id");
				int id=scanner.nextInt();
				System.out.println("Please Enter the Email");
				String Email=scanner.next();
				System.out.println("Please Enter the Number");
				long number=scanner.nextLong();
				System.out.println("Please Enter The gender");
				String gender=scanner.next();
				preparedStatement=connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, name);
				preparedStatement.setString(3, Email);
				preparedStatement.setLong(4, number);
				preparedStatement.setString(5, gender);
				preparedStatement.execute();
				System.out.println("Second Will we excuted");
				//preparedStatement=connection.prepareStatement(query);
				preparedStatement.execute();
				System.out.println("Data stored");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case 2: { 
					System.out.println("Please Enter the Id");
					int id=scanner.nextInt();
					query="delete from program1.Student where StudentId=?";
					try {
						preparedStatement=connection.prepareStatement(query);
						preparedStatement.setInt(1,id);
						preparedStatement.execute();
						System.out.println("Data Delete");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			break;
		}
		case 4: {
					System.out.println("Please Enter the name you want to chage");
					String name=scanner.next();
					System.out.println("Enter the Id ");
					int id=scanner.nextInt();
					query="update from program1.Student set StudentName=? where StudentId=?";
					try {
						preparedStatement=connection.prepareStatement(query);
						preparedStatement.setString(1, name);
						preparedStatement.setInt(2, id);
						preparedStatement.execute();
						System.out.println("Upadte is done");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			break;
		}
		case 3: {
					query="select * from program1.Student";
					try {
						statement=connection.createStatement();
						statement.execute(query);
						ResultSet resultSet=(ResultSet) statement.getResultSet();
						while(resultSet.next())
						{
							String name=resultSet.getString(2);
							int id=resultSet.getInt(1);
							String email=resultSet.getString(3);
							long number=resultSet.getLong(4);
							String gender=resultSet.getString(5);
							System.out.println("Name Of Candidate :"+name+" candidate Id :"+id+" Email"+email+"Number :"+number+"Gemder :"+gender);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			break;
		}
		
		}
  
		System.out.println("Program Ended");
	}

}
