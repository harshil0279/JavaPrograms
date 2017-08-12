package com.bridgelabz.utility;

public class CashCounter {
	int first, array[], length, size, last;

	/**
	 * Constructor with initial values setting
	 * 
	 * @param size
	 * @return 
	 */
	public void Cashcounter(int size) {
		first = 0;

		array = new int[size];
		length = array.length;
		this.size = size;
		last = first - 1;
	}

	/**
	 * @param data
	 *            Add function to add data to queue
	 */
	public void add(int data) {
		if (last == size - 1) {
			System.out.println("Queue Full Already");
			return;
		} else {
			length++;
			last++;
			array[last] = data;
			return;
		}

	}
}