package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employees {
	public static void Table_Employees() {
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
				String query1 = "select Employees.ID_staff, Employees.F_name, Employees.L_name, Employees.Staff,\n"
								+ "Worktime.Time_start, Departments.Name, Worktime.Time_end\r\n"
								+ "from Employees\r\n"
								+ "join Departments on ID_depart=Employees.fk_depart\r\n"
								+ "join Worktime on ID_work=Employees.fk_work;";

				ResultSet rs1 = _statement.executeQuery(query1);


				while(rs1.next()){
					System.out.println("| "+rs1.getString(1)+" | "+rs1.getString(2)+" | "+rs1.getString(3)+" |"+ rs1.getString(4)+" |"+ rs1.getString(5)+" |"
										+ rs1.getString(6)+" |"+ rs1.getString(7)+" |");
				}

				connection.close();
		}
			catch (SQLException e) {
				System.out.println("Error");
				e.printStackTrace();
			}
			System.out.println("\n\t1) Press to update table Employees\n \t2) Press to add to table Employees \n\t"
								+ "3) Press to remove from table Employees\n\t4) Press to close\n\t0) Press to Back") ;
			System.out.print( "\n(@user)--> ");
			call =scan.nextInt();
			if ( call ==1){
				
				try {
					Connection connection = DriverManager.getConnection(URL,name,password);
					System.out.println("Connect ");

					String query = "update Employees set F_name = ? , L_name = ? , Staff = ?, fk_depart = ?, fk_work = ? where ID_staff = ?  ";
					PreparedStatement _statement = connection.prepareStatement(query);

					String _string1;
					String _string2;
					String _string3;
					String _string4;
					String _string5;
					int _int1;
					
					System.out.print("Enter F_name (@user)--> ");
					_string1 =scan.next();
					_statement.setString(1,_string1);
					
					System.out.print("Enter L_name (@user)--> ");
					_string2 =scan.next();
					_statement.setString(2,_string2);
				
					System.out.print("Enter Staff (@user)--> ");
					_string3 =scan.next();
					_statement.setString(3,_string3);
					
					System.out.print("Enter fk_depart (@user)--> ");
					_string4 =scan.next();
					_statement.setString(4,_string4);
				
					System.out.print("Enter fk_work (@user)--> ");
					_string5 =scan.next();
					_statement.setString(5,_string5);
					
					System.out.print("Enter ID_staff (@user)--> ");
					_int1 =scan.nextInt();
					_statement.setInt(6,_int1);
					
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
					String query = "INSERT INTO Employees (ID_staff, F_name, L_name, Staff, fk_depart, fk_work)VALUES(?,?,?,?,?,?)" ;
					PreparedStatement _statement = connection.prepareStatement(query);

					int _int1;
					String _string1;
					String _string2;
					String _string3;
					String _string4;
					String _string5;

					System.out.print("Enter ID_staff (@user)--> ");
					_int1 =scan.nextInt();
					_statement.setInt(1,_int1);

					System.out.print("Enter F_name (@user)--> ");
					_string1 =scan.next();
					_statement.setString(2,_string1);

					System.out.print("Enter L_name (@user)--> ");
					_string2 =scan.next();
					_statement.setString(3,_string2);

					System.out.print("Enter Staff (@user)--> ");
					_string3 =scan.next();
					_statement.setString(4,_string3);
					 
					System.out.print("Enter fk_depart (@user)--> ");
					_string4 =scan.next();
					_statement.setString(5,_string4);

					System.out.print("Enter fk_work (@user)--> ");
					_string5 =scan.next();
					_statement.setString(6,_string5);
					
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

					String query = " delete from Employees where ID_staff = ?" ;

					PreparedStatement _statement = connection.prepareStatement(query);

					int _int1;
					System.out.print("Enter ID_staff (@user)--> ");
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
			
			else if(call == 4){System.exit(1);}
			
			else if(call == 0){ Main.Menu(); }

			else{System.out.print("(@user)-->\n"); }
		}
			while (call !=4);
	  }
}
