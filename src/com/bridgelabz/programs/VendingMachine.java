package com.bridgelabz.programs;
/*

 * created by: Bridge Labz
 * Date 09/05/2016
 *
 * Perpose: There is 1, 2, 5, 10, 50, 100, 500 and 1000 Rs Notes which
 * 		   can be returned by Vending Machine. Write a Program to 
 * 		   calculate the minimum number of Notes as well as the Notes 
 *          to be returned by the Vending Machine as a Change

 */
import com.bridgelabz.utility.Utility;

public class VendingMachine 
{
	public static void main(String[] args)
	{
		Utility utility=new Utility();
		int choice = 0;
		do
		{
			int[] notes = { 1000,500,100,50,10,5,2,1};


			//Utility utility=new Utility();

			//ask the user enter the money
			System.out.print("Enter the Amount:");
			int money = utility.inputInteger();

			// call the calculate method of utility class
			Utility.calculate(money,notes,0);
			
			System.out.println("Total Number of Notes are :"+Utility.total);
			System.out.println("press 1 for continue");
			choice = utility.inputInteger();
		}while(choice == 1);
	}

}
