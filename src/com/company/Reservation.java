package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Reservation {
	public static void Table_Reservation() {
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
				String query1 = "select Reservation.ID_Reservation, Patients.F_name, Reservation.Data_Reservtion,\n"
								+ "Reservation.Time_Reservation, Employees.L_name, Employees.Staff\r\n"
								+ "from Reservation\r\n"
								+ "join Employees on ID_staff=Reservation.fk_staff\r\n"
								+ "join Patients on ID_patient=Reservation.fk_patient;";

				ResultSet rs1 = _statement.executeQuery(query1);


				while(rs1.next()){
					System.out.println("| "+rs1.getString(1)+" | "+rs1.getString(2)+" | "+rs1.getString(3)+" |"+ rs1.getString(4)+" |"+ rs1.getString(5)+" |"+ rs1.getString(6)+" |");
				}

				connection.close();
		}
			catch (SQLException e) {
				System.out.println("Error");
				e.printStackTrace();
			}
			System.out.println("\n\t1) Press to update table Reservation\n \t2) Press to add to table Reservation \n\t"
								+ "3) Press to remove from table Reservation\n\t4) Press to close\n\t0) Press to Back") ;
			System.out.print( "\n(@user)--> ");
			call =scan.nextInt();
			if ( call ==1){
				
				try {
					Connection connection = DriverManager.getConnection(URL,name,password);
					System.out.println("Connect ");

					String query = "update Reservation set Data_Reservtion = ?, Time_Reservation = ?, fk_patient = ?, fk_staff = ? where ID_Reservation = ? ";
					PreparedStatement _statement = connection.prepareStatement(query);

					String _string1;
					String _string2;
					String _string3;
					String _string4;
					int _int1;
					
					System.out.print("Enter Data_Reservtion (@user)--> ");
					_string1 =scan.next();
					_statement.setString(1,_string1);
					
					System.out.print("Enter Time_Reservation (@user)--> ");
					_string2 =scan.next();
					_statement.setString(2,_string2);
					
					System.out.print("Enter fk_patient (@user)--> ");
					_string3 =scan.next();
					_statement.setString(3,_string3);
					
					System.out.print("Enter fk_staff (@user)--> ");
					_string4 =scan.next();
					_statement.setString(4,_string4);
					
					System.out.print("Enter ID_Reservation (@user)--> ");
					_int1 =scan.nextInt();
					_statement.setInt(5,_int1);
					
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
					String query = "INSERT INTO Reservation (ID_Reservation, Data_Reservtion, Time_Reservation, fk_patient, fk_staff)VALUES(?,?,?,?,?)" ;
					PreparedStatement _statement = connection.prepareStatement(query);
					
					int _int1;
					String _string1;
					String _string2;
					String _string3;
					String _string4;
					
					System.out.print("Enter ID_Reservation (@user)--> ");
					_int1 =scan.nextInt();
					_statement.setInt(1,_int1);

					System.out.print("Enter Data_Reservtion (@user)--> ");
					_string1 =scan.next();
					_statement.setString(2,_string1);

					System.out.print("Enter Time_Reservation (@user)--> ");
					_string2 =scan.next();
					_statement.setString(3,_string2);

					System.out.print("Enter fk_patient (@user)--> ");
					_string3 =scan.next();
					_statement.setString(4,_string3);
					 
					System.out.print("Enter fk_staff (@user)--> ");
					_string4 =scan.next();
					_statement.setString(5,_string4);
					
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

					String query = " delete from Reservation where ID_Reservation = ?" ;

					PreparedStatement _statement = connection.prepareStatement(query);

					int _int1;
					System.out.print("Enter ID_Reservation (@user)--> ");
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
