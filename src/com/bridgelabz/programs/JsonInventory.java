package com.bridgelabz.programs;
/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 9/08/2017
 * Purpose   :Create the JSON from Inventory Object and output 
 *            the JSON String
 *             
 **/

import com.bridgelabz.utility.Utility;

public class JsonInventory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice = 0;
		
		do {			

			Utility utility = new Utility();
//			JsonInventory inventory = new JsonInventory();

			utility.writeData();
			utility.readData();
			System.out.println("for continue press 1");

			
			choice = utility.inputInteger();
			
		} while (choice == 1);
		
		
	}

}