package com.bridgelabz.programs;

/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 9/08/2017
 * Purpose   :To demonstrate Insertion Sort functionality.	 
 *             
 **/

import java.util.Arrays;

import com.bridgelabz.utility.Utility;
public class InsertionSort
{
	public static void main(String[] args) 
	{	
		Utility utility = new Utility();
		int choice = 0;
		do
		{
		System.out.println("Enter no. of words to be printed: ");
		int n=utility.inputInteger();
		 
		//create string array
		String array[]=new String[n];
		System.out.println();	
		System.out.println("Enter the words to be printed: ");

		for(int i=0;i<array.length;i++)
		{
			array[i]=utility.inputString();
		}
		System.out.println();
	       
		//sort string array using Arrays.sort method
		System.out.println("Sorted order is: ");
		for(int i=0;i<array.length;i++)
		{
			Arrays.sort(array);
			System.out.println(array[i]);
		}
		System.out.println("press 1 for continue");
		choice = utility.inputInteger();
		}while(choice == 1);	
	}

}
