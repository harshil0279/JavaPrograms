package com.bridgelabz.programs;

/**
 * @author Ajit Shikalgar
 *
 */
import java.io.IOException;
import java.util.Scanner;
import com.bridgelabz.utility.CliniqueManager;
public class CliniqueManagerDemo {

	public static void main(String[] args) throws IOException {

		System.out.println("This is a an app to demonstrate Clinique Management");

		CliniqueManager cManager = new CliniqueManager();

		String choice = "n";

		int option;

		// Run Till User wants to Exit
		try (Scanner sc = new Scanner(System.in)) {
			// keep running until user selects No
			do {
				System.out.println("Enter your User Type");
				System.out.println("1. Clinique Manager");
				System.out.println("2. Patient");

				option = sc.nextInt();

				outer: switch (option) {
				case 1:
					System.out.println("What do you want to see");
					System.out.println("1. Doctor List");
					System.out.println("2. Patient List");//Manager can see lists and appointments
					System.out.println("3. Appointments for the week");
					int no = sc.nextInt();
					if (no == 1)
						cManager.displayDoctors();
					if (no == 2)
						cManager.displayPatients();
					if (no == 3)
						cManager.displayReport();
					System.out.println("Enter 'y' to continue or 'n' no exit");
					choice = sc.next();
						break outer;

				case 2:
					System.out.println("What do you want to see");
					System.out.println("1. Doctor List");
					System.out.println("2. Appointments for the week");//whereas patients can view only doctors and
					System.out.println("3. Make an Appointment");//make appointments
					int n = sc.nextInt();
					if (n == 1)
						cManager.displayReport();
					if (n == 2)
						cManager.displayPatients();
					if (n == 3) {
						boolean booked = false;
						while (!booked) {
							System.out.println("Enter your patientId");
							int pId = sc.nextInt();
							System.out.println("Enter the day to book appointment");
							int day = sc.nextInt();
							cManager.showDailyDoctors(day);
							System.out.println("Enter the doctor id");
							int docId = sc.nextInt();
							booked = cManager.makeAppointment(day, pId, docId);
						}
					}
					System.out.println("Enter 'y' to continue or 'n' no exit");
					choice = sc.next();
					break outer;

				default:
					System.out.println("Incorrect input. Please enter a correct input.");
					break outer;
				}

			} while (choice.equalsIgnoreCase("y"));

		}

		cManager.saveAppointments();

	}

}