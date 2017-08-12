package com.bridgelabz.programs;

/*
* 
* @author   : Harshil Gandhi
* Date      : 9/08/2017
* Purpose   : read an Arithmetic Expression such as (5+6)∗(7+8)/(4+3)(5+6)
*             Ensure parentheses must appear in a balanced or not.
**/

import com.bridgelabz.utility.Utility;

import java.util.Scanner;

public class BalancedParenthesis {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// take input from user
		String expression;

		System.out.println("Please type a string containing various kinds");
		System.out.println("of parentheses ( ) { } [ ]. I'll check whether");
		System.out.println("the parentheses are balanced or not.");

		do {
			System.out.print("Your string: ");
			expression = scanner.nextLine();
			if (Utility.isBalanced(expression))
				System.out.println("That is balanced.");
			else
				System.out.println("That is not balanced.");
		} while (Utility.query(scanner, "Another string?"));

		System.out.println("Thanks for that balancing act.");
	}

}