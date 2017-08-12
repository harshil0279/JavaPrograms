package com.bridgelabz.programs;

/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 9/08/2017
 * Purpose   :Create a Ordered Linked List having Numbers in ascending order. 
 *             
 **/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.bridgelabz.utility.MyOrderedList;
import com.bridgelabz.utility.Utility;

public class OrderedList {

	public static void main(String[] args) {

		int choice = 0;

		Scanner scan = new Scanner(System.in);
		do {
			// TODO Auto-generated method stub

			// Utility utility = new Utility();
			MyOrderedList<Integer> orderedList = new MyOrderedList<Integer>();
			String[] strings;
			BufferedReader bufferedReader = null;
			try {
				FileReader fileReader = new FileReader("/home/bridgeit/Desktop/oLinkedListFeeder.txt");
				bufferedReader = new BufferedReader(fileReader);
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					line = line.replaceAll("\\.", "");
					strings = line.split(" ");
					for (String integer : strings) {
						orderedList.add(Integer.parseInt(integer));
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("File Not Found");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			orderedList.list();
			// Scanner scanner = new Scanner(System.in);
			System.out.print("Enter a number to search: ");
			int search = scan.nextInt();
			// scan.close();
			int pos;

			if ((pos = orderedList.index(search)) == -1) {
				System.out.println("This word is not in the file. Adding it to the list.");
				orderedList.add(search);
			} else {
				System.out.println("Word is at " + pos + ". Removing it from list.");
				orderedList.remove(search);
			}
			try {
				int size = orderedList.size();
				PrintWriter printWriter = new PrintWriter("/home/bridgeit/Desktop/oLinkedListFeeder.txt");
				for (int i = 0; i < size; i++) {
					int integer = orderedList.pop(0);
					printWriter.write(integer + " ");
				}
				printWriter.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("press 1 for continue");
			choice = scan.nextInt();
		} while (choice == 1);
	}

}