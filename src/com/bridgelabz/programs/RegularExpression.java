package com.bridgelabz.programs;
/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 9/08/2017
 * Purpose   :Read the message from file Use Regex to replace name,
 *            full name, Mobile#, and Date with proper value.
 *             
 **/

import java.util.Date;

import com.bridgelabz.utility.UserDetails;
import com.bridgelabz.utility.Utility;
public class RegularExpression
{
	public static void main(String[] args)
	{
		Utility u=new Utility();

		UserDetails user=new UserDetails();
		System.out.println();
	
		//asking user to enter his data
		System.out.println("Enter FirstName:");
		user.setfName(u.inputString());
		System.out.println();
	
		System.out.println("Enter LastName:");
		user.setlName(u.inputString());
		System.out.println();
	
		System.out.println("Enter Mobile Number:");
		user.setmobileNo(u.inputString());
		System.out.println();	
		
		//Setting current date
		user.setdate(u.getFormatedDate(new Date()));
		System.out.println(u.convertString(user,u.getFileText("/home/bridgeit/Desktop/newfile")));	
	}
}