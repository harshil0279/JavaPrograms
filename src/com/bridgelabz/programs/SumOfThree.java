package com.bridgelabz.programs;

import java.util.Scanner;

/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 9/08/2017
 * Purpose   : A program with cubic running time. Read in N integers
 * 			   and counts the   number of triples that sum to exactly 0.

 *             
 **/
import com.bridgelabz.utility.Utility;

public class SumOfThree
{
	// Driver program to test above functions
	public static void main(String[] args) 
	{
		int choice = 0;
		do{		
		Utility utility = new Utility();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements that u want in array");
		int n = scanner.nextInt();
		int A[] = new int[n];
		System.out.println("Enter all the elements");
		for(int i =0;i<n;i++)
		{
		  A[i] = scanner.nextInt();
		}
		System.out.println("enter the sum that you want to check");
			
			int arr_size = A.length;
			int sum = scanner.nextInt();
			
			boolean b = utility.find3Numbers(A, arr_size, sum);
			if(!b )
			{
				System.out.println("triplet not found");
			}
			System.out.println("press 1 for continue");
			choice = utility.inputInteger();
			
		}while(choice == 1);
	}
}
