package com.bridgelabz.programs;

/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 9/08/2017
 * Purpose   : write a logic that check that the string is anagram or nor.
 *             
 **/

import java.util.Scanner;
import com.bridgelabz.utility.Utility;

public class StringAnagram 
{
	public static void main(String[] anagram)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a  string1");
		String str1  = sc.nextLine();
		System.out.println("Enter a string2");
		String str2 = sc.nextLine();
		System.out.println(Utility.anagramCheck(str1,str2));
	}



}
