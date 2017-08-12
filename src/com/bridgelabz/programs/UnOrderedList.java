package com.bridgelabz.programs;

/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 9/08/2017
 * Purpose   :  Read the Text from a file, split it into words and arrange it as Linked List. 
 * 				Take a user input to search a Word in the List.If the Word is not found then 
 * 				add it to the list, and if it found then remove the word from the List.
 * 				In the end save the list into a file

 *             
 **/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.bridgelabz.utility.MyLinkedList;
import com.bridgelabz.utility.Utility; 

public class UnOrderedList
{
    
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Utility utility = new Utility();
		int choice = 0;
		Scanner scanner = new Scanner(System.in);
		do{
		MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
		String[] strings;
		BufferedReader bufferedReader = null;
		try 
		{
			FileReader fileReader = new FileReader("/home/bridgeit/Desktop/harshil.txt");
			bufferedReader = new BufferedReader(fileReader);
			String line;
			while((line = bufferedReader.readLine()) != null)
			{
				line = line.replaceAll("\\.", "");
				strings = line.split(" ");
				for(String s: strings) 
				{
					myLinkedList.add(s);
				}
			}			
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File Not Found");		
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				bufferedReader.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		myLinkedList.list();
		
		System.out.print("Enter a word to search: ");
		String search = scanner.next();
		int pos;
		
		if((pos = myLinkedList.index(search)) == -1)
		{
			System.out.println("This word is not in the file. Adding it to the list.");
			myLinkedList.add(search);
		}
		else
		{
			System.out.println("Word is at " + pos + ". Removing it from list.");
			myLinkedList.remove(search);
		}
		try {
			int size = myLinkedList.size();
			PrintWriter printWriter = new PrintWriter("/home/bridgeit/Desktop/harshil.txt");
			for(int i = 0; i < size; i++)
			{
				String st = myLinkedList.pop(0);
				printWriter.write(st + " ");
			}
			printWriter.close();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		System.out.println("press 1 for continue");
		choice = scanner.nextInt();
	}while(choice == 1);
	}
}