package com.bridgelabz.programs;

/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 9/08/2017
 * Purpose   : his program takes a command-line argument N and prints a 
 *            table of the powers of 2 that are less than or equal to 2^N.
 *             
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.bridgelabz.utility.Utility;


public class PowerOfTwo 
{

	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("Let's play with the power of 2");
		System.out.println("Enter the powers upto which you want to play ( -31 < n < 31)");

		int n = Integer.parseInt(br.readLine());
		while (!(n < -31) && (n > 31))
		{
			System.out.println("Please enter a no between the specified range");
			n = Integer.parseInt(br.readLine());
		}
		Utility.powerOfTwo(n);
	
	}
}
