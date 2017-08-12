package com.bridgelabz.programs;
/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 9/08/2017
 * Purpose   :Determine if it is a Leap Year.
 *             
 **/
import com.bridgelabz.utility.Utility;
public class LeapYear
{
	public static void main(String[] args)
	{
		Utility utility = new Utility();
		int choice = 0;
		do{
			System.out.println("Enter a Year : ");
			int inputyear=utility.inputInteger();
			boolean leap = utility.leapYear(inputyear);
			if(leap)
			{
				System.out.println("Year "+inputyear+" is leap year : ");
			}
			else
			{
				System.out.println("Year "+inputyear+" is not leap year : ");
			}
			System.out.println("for continue press 1 ");
			choice = utility.inputInteger();
		}while(choice == 1);
	}
}
