package com.bridgelabz.programs;
/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 9/08/2017
 * Purpose   : Given N distinct Coupon Numbers,how many random numbers 
 *             do you need to generate that distinct coupon number?
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.bridgelabz.utility.Utility;

public class CoupanCode
{
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		int choice = 0;
		do
		{
			//create the object of utility
			Utility utility = new Utility();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Let's play with coupons");
			System.out.println("Enter the no of coupons you want to generate");
			int n = Integer.parseInt(br.readLine());
			Utility.processCoupons(n);
			System.out.println("press 1 for continue");
			choice = utility.inputInteger();

		}while(choice == 1);
	}

}
