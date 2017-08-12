package com.bridgelabz.programs;
/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 9/08/2017
 * Purpose   : To replace "UserName" with actual user name.
 *             
 **/
import java.util.Scanner;

import com.bridgelabz.utility.Utility;
public class StringTemplate
{

	public static void main(String[] args)
	{
		String s1 ="" ;
		Scanner scan = new Scanner(System.in);
		Utility utility = new Utility();
				
		int choice = 0;
		do
		{
			System.out.println("Enter the username");
			s1 = scan.nextLine();
			System.out.println("Hello"+" "+s1+" "+"How are you");
			System.out.println("press 1 for continue");
			choice = utility.inputInteger();
		}while(choice == 1);
	}

}