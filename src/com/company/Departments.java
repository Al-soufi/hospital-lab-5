package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Departments {
	public static void Table_Departments() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		int call;

		String URL ="jdbc:postgresql://127.0.0.1:5432/hospital";
		String name ="postgres";
		String password ="1369"; 

		do{
			try {
				Connection connection = DriverManager.getConnection(URL,name,password);
				System.out.println("Connect ");
				Statement _statement = connection.createStatement();
				String query1 = "select * from Departments";

				ResultSet rs1 = _statement.executeQuery(query1);


				while(rs1.next()){
					System.out.println("| "+rs1.getString(1)+" | "+rs1.getString(2)+" |");
				}

				connection.close();
		}
			catch (SQLException e) {
				System.out.println("Error");
				e.printStackTrace();
			}
			System.out.println("\n\t1) Press to update table Departments\n \t2) Press to add to table Departments \n\t"
								+ "3) Press to remove from table Departments\n\t4) Press to close\n\t0) Press to Back") ;
			System.out.print( "\n(@user)--> ");
			call =scan.nextInt();
			if ( call ==1){
				
				try {
					Connection connection = DriverManager.getConnection(URL,name,password);
					System.out.println("Connect ");

					String query = "update Departments set Name = ? where ID_depart = ?  ";
					PreparedStatement _statement = connection.prepareStatement(query);

					String _string1;
					
					System.out.print("Enter Name (@user)--> ");
					_string1 =scan.next();
					_statement.setString(1,_string1);
					int _int1;
					System.out.print("Enter ID_depart (@user)--> ");
					_int1 =scan.nextInt();
					_statement.setInt(2,_int1);
					
					int rowAffected = _statement.executeUpdate();
					System.out.println(String.format("Row affected %d", rowAffected));
					connection.close();
				}
				catch (SQLException e) {
					System.out.println("Error");
					e.printStackTrace();
				}
		}
			else if (call == 2){
				try {
					Connection connection = DriverManager.getConnection(URL,name,password);
					System.out.println("Connect ");
					String query = "INSERT INTO Departments (ID_depart,Name)VALUES(?,?)" ;
					PreparedStatement _statement = connection.prepareStatement(query);

					int _int1;
					String _string1;

					
					System.out.print("Enter ID_depart (@user)--> ");
					_int1 =scan.nextInt();
					_statement.setInt(1,_int1);

					System.out.print("Enter Name (@user)--> ");
					_string1 =scan.next();
					_statement.setString(2,_string1);

					 
					int rowAffected = _statement.executeUpdate();
					System.out.println(String.format("Row affected %d", rowAffected));

					connection.close();
					
				} 
				catch (SQLException e) {
					System.out.println("Error");
					e.printStackTrace();
				}
			}
		
			else if(call == 3){
				
				try {
					Connection connection = DriverManager.getConnection(URL,name,password);
					System.out.println("Connect ");

					String query = " delete from Departments where ID_depart = ?" ;

					PreparedStatement _statement = connection.prepareStatement(query);

					int _int1;
					System.out.print("Enter ID_depart (@user)--> ");
					_int1 =scan.nextInt();
					_statement.setInt(1,_int1);

					int rowAffected = _statement.executeUpdate();
					System.out.println(String.format("Row affected %d", rowAffected));

					connection.close();
					
					} catch (SQLException e) {
					System.out.println("Error");
					e.printStackTrace();
					}
			}
			
			
			else if(call == 4){ System.exit(1); }
			
			else if(call == 0){ Main.Menu(); }

			else{System.out.print("(@user)-->\n"); }
		}
			while (call !=4);
	  }
}
