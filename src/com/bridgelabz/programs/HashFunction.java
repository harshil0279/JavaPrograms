package com.bridgelabz.programs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Scanner;

import com.bridgelabz.utility.MyOrderedList;

public class HashFunction {

	BufferedReader bufferedReader = null;
	HashMap<Integer, MyOrderedList<Integer>> myHashMap;
	
	public static void main(String[] args) {
		HashFunction function = new HashFunction();
		function.initialize();
		function.readFile();
		function.searchNumber();
	}

	/*
	 *  Initializes hashmap and puts orderedlists in it 
	 */
	void initialize() {
		myHashMap = new HashMap<Integer, MyOrderedList<Integer>>();
		for(int i = 0; i < 11; i++) {
			myHashMap.put(i, new MyOrderedList<Integer>());
		}
	}
	
	/**	Reads file and adds number to respective ordered list **/
	void readFile() {
		bufferedReader = null;
		try {
			FileReader fileReader = new FileReader("/home/bridgeit/Desktop/number.txt");
			bufferedReader = new BufferedReader(fileReader);
			
			String line;
			while((line = bufferedReader.readLine()) != null) {
				String[] strings = line.split(" ");
				for(String integers : strings) {
					int numberToAdd = Integer.parseInt(integers);
					MyOrderedList<Integer> list = myHashMap.get(numberToAdd % 11);
					list.add(numberToAdd);
				} 
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found...");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/** Searches for given number **/
	void searchNumber() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number to search: ");
		int search = scanner.nextInt();
		MyOrderedList<Integer> list = myHashMap.get(search % 11);
		scanner.close();
		if(list.search(search)) {
			System.out.println("File contains number. Removing it.");
			list.remove(search);
		}
		else {
			System.out.println("File does not contain the number. Adding it to the file.");
			list.add(search);
		}
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter("/home/bridgeit/Desktop/number.txt" , "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < 11; i++) {
			list = myHashMap.get(i);
			while(!list.isEmpty()) {
				printWriter.print(list.pop(0) + " ");
			}			
		}		
		printWriter.close();
	}
}