package com.bridgelabz.programs;
/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 9/08/2017
 * Purpose   : Write a Queue Class to enqueue and dequeue people to either 
 *             deposit or withdraw money and maintain the cash balance 
 *             
 **/



import java.util.Random;
import java.util.Scanner;

import com.bridgelabz.utility.Cash;
import com.bridgelabz.utility.Customer;

public class BankCounter 
{
	public static void main(String[] args) 
	{

		int balance = 10000000;
		String choice = "y";
		Random random;
		Scanner scanner = new Scanner(System.in);
		while (choice.equalsIgnoreCase("y")) 
		{
			System.out.println("Enter no. of People in Queue ");
			int people = scanner.nextInt();
			Cash cashCounter = new Cash(people);
			random = new Random();
			for (int i = 0; i < people; i++)
			{
				boolean action = true; // True for Deposit, False for Withdraw
				int temp = random.nextInt(100000) + 1;
				System.out.println("Enter whether Withdraw or Deposit for person " + (i + 1));
				String purpose = scanner.next();// whether to deposit or withdraw
				if (purpose.equalsIgnoreCase("deposit"))
					action = true;
				else if (purpose.equalsIgnoreCase("withdraw"))
					action = false;
				else
					System.out.println("Wrong Keyword. Try Again ");

				Customer customer = new Customer(temp, action);
				System.out.println("Enter Amount to " + purpose);
				int money = scanner.nextInt();
				cashCounter.add(money);
				if (purpose.equalsIgnoreCase("withdraw")) {

					if (money > customer.getBal()) {
						System.out.println("Action Denied ! Insufficent Balance");
						continue;
					}

					else {
						System.out.println("Your old Bal. before " + purpose + " is " + customer.getBal());
						customer.setBal(customer.getBal() - money);
						System.out.println("Your New Bal. after " + purpose + " is" + customer.getBal());
					}
				}
				if (purpose.equalsIgnoreCase("deposit")) {
					System.out.println("Your old Bal. before " + purpose + " is " + customer.getBal());
					customer.setBal(customer.getBal() + money);
					System.out.println("Your New Bal. after " + purpose + " is" + customer.getBal());
				}

				if (balance >= 0) {

					if (action == true) {
						balance = balance + money;

					} else
						balance = balance - money;

					System.out.println("Balance available " + balance);
					cashCounter.remove();
				}

				else if (balance < 10000000) {
					System.out.println("So Sorry. No more Transactions for the day");
					break;
				}
			}

			if (cashCounter.isEmpty())
				System.out.println("Transaction is carried out succesfullly !");
			System.out.println("Any more Transactions Y or N ?");
			choice = scanner.next();
		}
		scanner.close();

	}


}
