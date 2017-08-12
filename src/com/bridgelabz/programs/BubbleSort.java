package com.bridgelabz.programs;
/*
* Created by: BridgeLabz
* Date      : 9/08/2017
* Purpose   : Ask the user to sort the integers using BubbleSort program.
*             
**/

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of integers to sort: ");
		int count = scanner.nextInt();
		int[] array = new int[count];
		System.out.print("Enter integers to sort: ");
		for(int i = 0; i < count; i++) {
			array[i] = scanner.nextInt();
		}
		
		Utility utility = new Utility();
		array = utility.bubbleSort(array);
		System.out.println("The elements in sorted list are  ");
		
		for(int element : array) {
			System.out.println(element);
		}
		scanner.close();
	}

}