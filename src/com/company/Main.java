package com.company;
import java.util.Scanner;

public class Main {
	@SuppressWarnings("resource")
	
	public static void Menu() {
		Scanner scan = new Scanner(System.in);
		int Switch;
do{
			
			System.out.print("\t\t***Please choose one of the tables from the database***");
			System.out.println("\n\t1) Press to Modification table Departments\n\t2) Press to Modification table Worktime\n\t"
								+ "3) Press to Modification table patients\n\t4) Press to Modification table Employees\n\t"
								+ "5) Press to Modification table Reservation\n\t6) Press to close") ;
			System.out.print( "\n(@user)--> ");
			
			Switch =scan.nextInt();
			
			if ( Switch ==1){ Departments.Table_Departments(); }
			
			else if (Switch == 2){ Worktime.Table_Worktime(); }

			else if(Switch == 3){ Patients.Table_Patients(); }
			
			else if(Switch == 4){ Employees.Table_Employees(); }
			
			else if(Switch == 5){ Reservation.Table_Reservation(); }
			
			else if(Switch == 6){System.exit(1);}
			
			else{System.out.print("(@user)-->\n"); }
		}
			while (Switch !=6);
	}
	public static void main(String[] args) {
		Menu();		
	}
}
