package com.bridgelabz.programs;
/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 9/08/2017
 * Purpose   :to demostrate the functionality of merge sort
 *             
 **/
import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Utility utility = new Utility();
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do{
		System.out.print("Enter number of strings: ");
		int numberOfStrings = scanner.nextInt();
		String[] strings = new String[numberOfStrings];
		
		for(int i = 0; i < numberOfStrings; i++) {
			strings[i] = scanner.next();
		}
		
		
		Utility utility = new Utility();
		strings = utility.mergeSort(strings);
		
		System.out.println("Sorted list:");
		
		for(String string : strings)
		{
			System.out.println(string);
		}
		System.out.println("press 1 for continue");
		choice = scanner.nextInt();
		}while(choice == 1);
	}

}