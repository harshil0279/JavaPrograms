package com.bridgelabz.programs;

/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 9/08/2017
 * Purpose   : Check the inputed string is palindrome or not.
 *             
 **/
import java.util.*;

class Palindrome {
	public static void main(String args[]) {
		String original, reverse = "";
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("Enter a string to check if it is a palindrome");
			original = scan.nextLine();

			int length = original.length();

			for (int i = length - 1; i >= 0; i--)
				reverse = reverse + original.charAt(i);

			if (original.equals(reverse))
				System.out.println("Entered string is a palindrome.");
			else
				System.out.println("Entered string is not a palindrome.");
			System.out.println();
			System.out.println("press 1 for continue");
			choice = scan.nextInt();
		} while (choice == 1);
	}
}