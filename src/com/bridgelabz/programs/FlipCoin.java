package com.bridgelabz.programs;
/**
 * 
 * @author   : HarshilGandhi
 * Date      : 9/08/2017
 * Purpose   : Flip Coin and prints percentage of Heads and Tails. 
 *             
 **/

import java.util.*;

import com.bridgelabz.utility.Utility;

public class FlipCoin {
	public static void main(String[] args)

	{
		int choice = 0;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter a number");
			//take the input number from user
			int number = scanner.nextInt();

			Utility.flipcoin(number);
			System.out.println("press 1 to continue");
			choice = scanner.nextInt();
		} while (choice == 1);

	}// End Main
}// End Class
