package com.bridgelabz.utility;

public class Cash {

	int first, array[], length, size, last;

	/**
	 * Constructor with initial values setting
	 * 
	 * @param size
	 */
	public Cash(int size) {
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

	/**
	 * @param none
	 *            Remove function to facilitate deletion from queue
	 */
	public void remove() {
		if (first > last) {
			System.out.println("Queue Empty Already");
			return;
		} else {
			length--;
			first++;
		}

	}

	public boolean isEmpty() {
		if (first > last)
			return true;
		return false;
	}



}