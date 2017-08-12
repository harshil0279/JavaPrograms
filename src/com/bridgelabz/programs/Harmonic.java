package com.bridgelabz.programs;
/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 9/08/2017
 * Purpose   :Prints the Nth harmonic number: 1/1 + 1/2 + ... + 1/N
 *             
 **/
import java.util.Scanner;
import com.bridgelabz.utility.Utility;

public class Harmonic
{

	public static void main(String args[])
	{
		int choice = 0;
		do
		{			
				Utility utility = new Utility();
				System.out.println("Enter N upto which the Harmonic no is to be calculated.");				
				int n =utility.inputInteger();
				Utility.harmonicGenerator(n);
				System.out.println("press 1 for continue");
				choice = utility.inputInteger();
		
		}	while(choice == 1);
	}
}
