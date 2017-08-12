package com.bridgelabz.utility;

public class Customer {

	int bal;
	boolean deposit, withdraw, j, temp;

	/**
	 * @param n
	 * @param action
	 *            Setter constructor for customer
	 */
	public Customer(int n, boolean action) {
		bal = n;
		if (action == true) {
			deposit = true;
			withdraw = false;
		} else {
			deposit = false;
			withdraw = true;
		}
	}

	public void setBal(int n) {
		bal = n;
	}

	public int getBal() {
		return bal;
	}

}