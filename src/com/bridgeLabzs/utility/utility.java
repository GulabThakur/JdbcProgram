package com.bridgeLabzs.utility;

import java.util.Scanner;

public class utility {
				Scanner scanner=new Scanner(System.in);
				/**
				 * @return
				 * @ THIS METHOD is using for delete 
				 */
				public String delete()
				{
					System.out.println("Please Enter the Id Which you want to delete");
					int id=scanner.nextInt();
					String query="delete from program1.student where StudentId="+id+"";
					System.out.println(query);
					return query;
				}
				/**
				 * @return
				 * @ this method using for insert data
				 */
				public String insertData()
				{
					System.out.println("Plese Enter The Id ");
					int id=scanner.nextInt();
					System.out.println("Please Enter the Name ");
					String name=scanner.next();
					System.out.println("Please Enter the email Id");
					String Email=scanner.next();
					System.out.println("Please Entre the Number ");
					long number=scanner.nextLong();
					System.out.println("Please Enter the Gender");
					String gender=scanner.next();
					String query="insert into program1.Student values ("+id+",'"+name+"','"+Email+"',"+number+",'"+gender+"')";
					System.out.println(query);
					return query;
				}
}
