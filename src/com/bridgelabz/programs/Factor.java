package com.bridgelabz.programs;

/* 
 * @author   : Harshil Gandhi
 * Date      : 9/08/2017
 * Purpose   : Computes the prime factorization for given number.
 **/
import com.bridgelabz.utility.Utility;
import java.util.Scanner;

public class Factor {
	public static void main(String[] args) {
		int choice = 0;
		do {
			// take the variable to store the number
			int number;
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter a number");
			number = scanner.nextInt();
			Utility.primeFactors(number);
			System.out.println("press 1 for continue");
			choice = scanner.nextInt();
		} while (choice == 1);

	}
}
