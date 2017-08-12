package com.bridgelabz.programs;
/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 9/08/2017
 * Purpose   : asks the user to think of a number between 0 and N-1,
 *             where N = 2^n, and print the number 
 *             
 **/
import com.bridgelabz.utility.Utility;
public class GuessNumber 
{
	public static void main(String args[])
	{
		int choice = 0;
		do{
			System.out.println("Enter the Range  (N) :");
			Utility utility = new Utility();
			int num =utility.inputInteger();
			utility.find(0,num-1);
			System.out.println("press 1 to continue");
			choice = utility.inputInteger();
		}while(choice == 1);
	}

}
