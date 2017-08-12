package com.bridgelabz.programs;

/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 9/08/2017
 * Purpose   : Model clss for storing stock detils.
 *             
 **/
import java.util.Scanner;
import com.bridgelabz.utility.Utility;

import com.bridgelabz.utility.MyLinkedList;
import com.bridgelabz.utility.Stock;

public class StockReport {

	MyLinkedList<Stock> list;

	Utility utility = new Utility();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// StockReport report = new StockReport();
		Utility.getStockData();
		Utility.printReport();
	}

}