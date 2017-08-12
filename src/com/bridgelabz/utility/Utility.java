package com.bridgelabz.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.utility.UserDetails;
import com.bridgelabz.programs.*;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;

public class Utility 
{

	static Scanner scanner = new Scanner(System.in);
	static Utility utility = new Utility();
    static HashFunction myHashMap = new HashFunction();
	static BufferedReader br;
	//constructor to initialize bufferedReader

	private final String REGEX_NAME = "<<name>>";
	private final String REGEX_FULLNAME = "<<full name>> ";
	private final String REGEX_MOBILE_NO = "xxxxxxxxxx";
	private final String REGEX_DATE = "27/07/2017";

	public Utility(){
		br = new BufferedReader(new InputStreamReader(System.in));
	}
    
	
	
	//take input word
	public static String inputString(){
		try{
			return br.readLine();
		}
		catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		return "";
	}

	//Take Integer Input
	public int inputInteger(){
		try{
			try{	
				return Integer.parseInt(br.readLine());
			}
			catch(NumberFormatException nfe){
				System.out.println(nfe.getMessage());	
			}
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		return 0;
	}

	//Take Double Input
	public double inputDouble(){
		try{
			try{	
				return Double.parseDouble(br.readLine());
			}
			catch(NumberFormatException nfe){
				System.out.println(nfe.getMessage());	
			}
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		return 0.0;
	}


	//declare variables
	static double flip;
	static int count = 0;
	static int countHeads = 0;
	static int countTails = 0;
	static int percentHeads = 0;
	static int percentTails = 0;
	
	/**
	 * @param   - integer input
	 * @returns nothing
	 */
	
	public static void flipcoin(int n)
	{

		for(int x = 0; x <=n;x = x++)
		{
			x = x + 1;
			//flip
			flip = Math.random();
			//if statement
			if( flip <= .5)
			{   
				flip = countHeads;
				countHeads = countHeads + 1;
				percentHeads = countHeads * 10;
			}
			else
			{           
				flip = countTails;
				countTails = countTails + 1;
				percentTails = countTails * 10;
				System.out.println("Heads was flipped " + percentHeads + " percent of the time.");
				System.out.println("Tails was flipped " + percentTails + " percent of the time.");


			}

			count = count +1;



		}//End Loop*/
	}

	public boolean leapYear(int a)
	{
		if(a>1000)
		{
			if(a % 400 == 0)
			{
				return true;
			}
			else if(a % 4 == 0)
			{
				return true;
			}
			else if(a % 100== 0)
			{
				return false;
			}
			else
			{
				return false;
			}
		}
		return false;
	}	

	public static void powerOfTwo(int n)
	{		
		int i = 0;
		int power = 1;
		System.out.println("Powers of 2 that are less than 2^"+n);
		if(n>0)
		{
			while (i <= n)
			{
				System.out.println("2^"+i+" = " + power);
				power = power * 2;
				i++;
			}
		}
		else
		{
			while (i >= n)
			{
				System.out.println("2^"+i+" = " + power);
				power = power * 2;
				i--;
			}
		}
	}

	/*
	 * Method to generate hormonic sum
	 * @param: integer number
	 * 
	 */
	
	public static void harmonicGenerator(int n)
	{
		double sum = 0.0;
		for(int i = 1 ; i<=n ; i++)
		{
			sum = sum + 1.0 / i;	
		}

		System.out.println("The "+n+"th Harmonic number is "+sum);
	} // end of harmonicGenerator method


	/*
	 * Method to generate prime factors
	 * @param: integer number
	 */
	public static void primeFactors(int n)
	{

		while (n%2==0)
		{
			System.out.print(2 + " ");
			n /= 2;
		}

		for (int i = 3; i*i<= n; i+= 2)
		{
			while (n%i == 0)
			{
				System.out.print(i + " ");
				n /= i;
			}
		}
		System.out.println("");

		if (n > 2)
			System.out.print(n);

	}

	/**
	 * @param input of stack and goal
	 */
	public static void gamble(int stake, int goal)
	{
		int win = 0;
		int loss = 0;
		float totalGambles = 0;
		int gamble = 0;
		Random random = new Random();
		do
		{
			gamble = random.nextInt(2);
			System.out.println(gamble);
			totalGambles++;
			if(gamble == 0)
			{
				stake++;
				System.out.println("Yay you won! You now have "+stake+". Your goal:"+goal);
				win++;
			}
			else
			{
				stake--;
				System.out.println("Bad luck!You lost! You now have "+stake+". Your goal:"+goal);
				loss++;
			}			
		}
		while(!(stake == 0 || stake == goal));

		System.out.println("You won "+win+" times");
		float winp = (win/totalGambles)*100;
		System.out.println("Win percent%"+winp);
		float lossp = (loss/totalGambles)*100;
		System.out.println("Loss percent%"+lossp);

	}

	// Method to generate coupan code

	public static void processCoupons(int n) 
	{

		// create the necessary stuff
		Random random = new Random();

		// this is used to count to the random no's we will need
		int randomCounter = 0;

		// this is a counter for generating n no of coupons
		int couponCount = 0;

		// we will use this variable to add elements to our Set
		int coupon = 0;

		// this will be used to store our unique coupons
		HashSet<Integer> coupons = new HashSet<>();

		//start generating random no's and add them until we have the desired no of coupons
		while(couponCount <n)
		{
			coupon = random.nextInt(1001);

			// check if our newly generated coupon no is not present in the set			
			if(!(coupons.contains(coupon)))
			{
				coupons.add(coupon);
				couponCount++;
			}

			randomCounter++;

		}

		display(coupons, randomCounter);
	}

	// method to display our final output
	private static void display(HashSet<Integer> coupons, int randomCounter)
	{

		for (Integer coupon : coupons) 
		{
			System.out.print(coupon+ " ");
		}

		System.out.println("");

		System.out.println("Total no of random nos needed to generate the coupons were "+randomCounter);

	}

	// Method to take integer array input
	public static int[][] arrayInt(int m,int n)
	{
		int a[][]=new int[m][n];
		//Utility u=new Utility();    
		System.out.println();
		System.out.println("Integer Array");

		for(int i = 0; i<m; i++)
		{
			for (int j = 0; j<n; j++)
			{
				a[i][j] = scanner.nextInt();
			}   
		}
		return a;
	}

	//Method to take doubole array input
	public static double[][] arrayDouble(int m,int n)
	{
		double b[][]=new double[m][n];
		//Utility =new Utility();    
		System.out.println();
		System.out.println("Double Array");

		for(int i = 0; i<m; i++)
		{
			for (int j = 0; j<n; j++)
			{
				b[i][j] = utility.inputDouble();
			}   
		}
		return b;
	}

	//Method to take double array input
	public static String[][] arrayBoolean(int m,int n)
	{
		String c[][]=new String[m][n];
		//Utility u=new Utility();    
		System.out.println();
		System.out.println("Boolean Array");

		for(int i = 0; i<m; i++)
		{
			for (int j = 0; j<n; j++)
			{
				c[i][j] = utility.inputString();
			}   
		}
		return c;
	}

	//display method
	public static void display(int[][]a,double[][]b,String[][]c,int m,int n)
	{
		PrintWriter pw=new PrintWriter(System.out,true);

		//display integers
		System.out.println();
		pw.println("2D ARRAY INTEGER");

		for(int i = 0; i<m; i++)
		{
			for (int j = 0; j<n; j++)
			{
				pw.print("\t"+a[i][j]+" ");
			} 
			pw.println("\t");
		}


		//display double
		System.out.println();
		pw.println("2D ARRAY DOUBLE");

		for(int i = 0; i<m; i++)
		{
			for (int j = 0; j<n; j++)
			{
				pw.print("\t"+b[i][j]+" ");
			} 
			pw.println("\t");
		}

		//display boolean
		System.out.println();
		pw.println("2D ARRAY BOOLEAN");

		for(int i = 0; i<m; i++)
		{
			for (int j = 0; j<n; j++)
			{
				pw.print("\t"+c[i][j]+" ");
			} 
			pw.println("\t");
		}
	}

	//Method to find the 3 number
	public boolean find3Numbers(int A[], int arr_size, int sum) 
	{
		int l, r;

		// Fix the first element as A[i]
		for (int i = 0; i < arr_size - 2; i++) 
		{
			// Fix the second element as A[j]
			for (int j = i + 1; j < arr_size - 1; j++) 
			{
				// Now look for the third number
				for (int k = j + 1; k < arr_size; k++) 
				{
					if (A[i] + A[j] + A[k] == sum) 
					{
						System.out.print("Triplet is " + A[i] + " ," + A[j] 
								+" ," + A[k]);
						return true;
					}
				}
			}
		}

		// If we reach here, then no triplet was found
		return false;
	}

	//Take a variable to store the time
	public long startTimer=0;
	public long stopTimer=0;
	public long elapsed;

	//to start timer
	public void start()
	{
		startTimer=System.currentTimeMillis();
		System.out.println("Start Time is: "+startTimer);
	}

	// to stop timer
	public void stop()
	{
		stopTimer=System.currentTimeMillis();
		System.out.println("Stop Time is: "+stopTimer);
	}

	public long getElapsedTime()
	{
		elapsed=stopTimer-startTimer;
		return elapsed;
	}
	private char [][] gameBoard;
	private boolean gameOnGoing = true;
	/***
	 * Thsi is the constructor for Gameboard class
	 */
	public void GameBoard()
	{
		gameBoard = new char[3][3];
		for (int row = 0; row < gameBoard.length; row++) 
		{
			Arrays.fill(gameBoard[row],' '); 
		}
	}//end of constructor

	/**
	 * This method will display the gameBoard to the screen
	 */

	public void dispalyBoard()
	{
		for (int row = 0; row < gameBoard.length; row++) 
		{
			for(int col = 0; col < gameBoard.length; col++)
			{
				System.out.print("\t"+gameBoard[row][col]);
				if(col == 0 || col == 1)
				{
					System.out.print("|");
				}
			}
			if(row == 0 || row == 1)
			{
				System.out.print("\n---------------------------\n");
			}

		}
		System.out.println();
	}//End of display method

	/*
	 * This method will return true if the game is still active
	 */

	public boolean gameActive()
	{
		return gameOnGoing;
	}

	/*
	 * This method will ask the user to pick a row and column. validate
	 * the input and call the method move
	 */

	public void askPlayer(char player)
	{
		Scanner keyboard = new Scanner(System.in);
		int row,col; 
		do
		{
			System.out.printf("Please %s enter a row from 1-3",player);
			row = keyboard.nextInt();

			System.out.printf("Plese %s col from 1-3",player);
			col = keyboard.nextInt();

		}while(notValid(row,col));
		makeMove(player, row-1, col-1);
	}//end of ask player method

	/*
	 * This method will chack to see if there are 3 O's or 3 X's in a row
	 * return true if there is a winner otherwise false
	 */

	public boolean checkForWinner()
	{
		//loop over each row and check for a winner

		for (int row = 0; row < gameBoard.length; row++) 
		{
			if(gameBoard[row][0] == gameBoard[row][1] && gameBoard[row][1] == gameBoard[row][2] && gameBoard[row][0] != ' ')

			{
				System.out.println("The winner is "+gameBoard[row][0]);
				gameOnGoing = false;
			}

		}
		// loop over for each column and check for a winner
		for (int col = 0; col < gameBoard.length; col++) 
		{
			if(gameBoard[0][col] == gameBoard[1][col] && gameBoard[1][col] == gameBoard[2][col] && gameBoard[0][col] != ' ')
			{
				System.out.println("The winner is "+gameBoard[0][col]);
				gameOnGoing = false;
			}

		}

		// check for cross

		if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != ' ')
		{
			System.out.println("The winner is"+gameBoard[0][0]);
			gameOnGoing = false;
		}
		if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[0][2] && gameBoard[0][2] != ' ')
		{
			System.out.println("The winner is"+gameBoard[1][1]);
			gameOnGoing = false;
		}
		return false;

	}

	/*
	 * This method will validate if row and column are between 1-3
	 * and if position is currently empty 
	 */

	public boolean notValid(int row,int col)
	{
		if(row > 3 || row < 1 || col >3 || col <1 || !isEmpty(row, col))
			return true;
		else
			return false;
	}
	/*
	 * This method will check if a position is empty
	 * return true if position is empty othewise false
	 */ 

	public boolean isEmpty(int row, int col)
	{
		if(gameBoard[row-1][col-1] == ' ')
			return true;
		else
		{
			System.out.println("That position is taken\n");
			return false;
		}
	}

	/* This method will validate if a player move is alloed and return true
	 * if the move was completed
	 */

	public boolean makeMove(char player, int row, int col)
	{
		if(row >= 0 && row <= 2 && col >= 0 && col <=2)
		{
			if(gameBoard[row][col] != ' ')
			{
				return false;
			}
			else
			{
				gameBoard[row][col] = player;
				return true;
			}
		}
		else
		{
			return false;
		}
	}

	public static boolean anagramCheck(String str1,String str2)
	{
		char[] charString1 = str1.toCharArray();
		StringBuilder sb = new StringBuilder(str2);
		for(char c : charString1)
		{
			int index = sb.indexOf(String.valueOf(c));
			if(index != -1)
			{
				sb.deleteCharAt(index);

			}
			else
			{
				return false;
			}
		}
		return sb.length() ==  0;
	}

	StringTokenizer st;
	//Take 1D Array Input
	public int[] input1DArray(int arraySize){
		int array[]=new int[arraySize];
		for(int i=0;i<arraySize;i++){
			System.out.println("Enter array["+i+"] : ");
			array[i] = scanner.nextInt();
		}
		return array;
	}

	//Take 1D String Array Input
	public String[] input1DStringArray(int arraySize){
		String array[]=new String[arraySize];
		for(int i=0;i<arraySize;i++){
			System.out.println("Enter array["+i+"] : ");
			array[i]=Utility.inputString();
		}
		return array;
	}

	//Print 1D array
	public void print1DArray(int array[]){
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}

	//print 1D array String
	public void print1DStringArray(String array[]){
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}

	//Binary Search
	public int binarySearch(int[] inputArr, int key) {
		int start = 0;
		int end = inputArr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == inputArr[mid]) {
				return mid;
			}
			if (key < inputArr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	//Binary Search for String
	public int binarySearchString(String[] names, String key) {
		int first = 0;
		int last  = names.length;

		while (first < last) {
			int mid = (first + last) / 2;
			if (key.compareTo(names[mid]) < 0) {
				last = mid;
			} else if (key.compareTo(names[mid]) > 0) {
				first = mid + 1;
			} else {
				return mid;
			}
		}		
		return -1;
	}

	/**
	 * @param binaryIntArray - integer array to sort
	 * @returns sorted integer array in descending order
	 */
	public int[] bubbleSort(int numbers[])
	{
		int temp;
		for(int i = 0; i < numbers.length; i++)
		{
			for(int j = 1; j < (numbers.length -i); j++)
			{
				//if numbers[j-1] > numbers[j], swap the elements
				if(numbers[j-1] > numbers[j])
				{
					temp = numbers[j-1];
					numbers[j-1]=numbers[j];
					numbers[j]=temp;
				}
			}
		}
		return numbers;
	}




	//Bubble Sort for String
	public String[] bubbleSortString(String numbers[])
	{
		String temp;
		for(int i = 0; i < numbers.length; i++)
		{
			for(int j = 1; j < (numbers.length -i); j++)
			{
				//if numbers[j-1] > numbers[j], swap the elements
				if(numbers[j-1].compareTo(numbers[j])<0)
				{
					temp = numbers[j-1];
					numbers[j-1]=numbers[j];
					numbers[j]=temp;
				}
			}
		}
		return numbers;
	}

	//Insertion sort
	public int[] insertionSort(int words[]){
		int temp;
		for(int i=1;i<words.length;i++){
			for(int j=i;j>0;j--){
				if((words[j]-words[j-1])<0){
					temp=words[j];
					words[j]=words[j-1];
					words[j-1]=temp;
				}
				else
					break;
			}
		}
		return words;
	}

	//Insertion sort for String
	public String[] insertionSortString(String words[])
	{
		String temp;
		for(int i=1;i<words.length;i++)
		{
			for(int j=i;j>0;j--)
			{
				if(words[j].compareTo(words[j-1])<0)
				{
					temp=words[j];
					words[j]=words[j-1];
					words[j-1]=temp;
				}
				else
					break;
			}
		}
		return words;
	}
	//Take Statement And return Array of words
	public String[] wordsArrayFromStatement(String statement)
	{	
		st=new StringTokenizer(statement," ");
		String words[]=new String[st.countTokens()];
		int i=0;
		while(st.hasMoreTokens())
		{
			words[i]=st.nextToken();
			i++;
		}
		return words;
	}

	/*	 
	 *  Method to find the guessing number
	 *  @param range of two number
	 */
	
	public static void find(int low,int up)
	{
		//Displaying the value
		if(low==up)
		{
			System.out.println("Your number is : "+low);
			System.out.println("Intermediary numbers is "+(low-1)+" and "+(low+1));
			return;
		}
		//Finding middle value between range low and up
		int mid=(low+up)/2;
		int ch;
		System.out.println("Press 1 : "+low+" - "+mid);
		System.out.println("Press 2 : "+(mid+1)+" - "+up);
		ch=new Utility().inputInteger();
		//Number is in first half
		if(ch==1)
		{
			find(low,mid);
		}
		//Number is in second half
		else
		{

			find(mid+1,up);
		}



	}
	private int[] array;
	private int[] tempMergArr;
	private int length;

	public void sort(int inputArr[]) 
	{
		this.array = inputArr;
		this.length = inputArr.length;
		this.tempMergArr = new int[length];
		doMergeSort(0, length - 1);
	}

	//method for merge sort
	private void doMergeSort(int lowerIndex, int higherIndex) 
	{

		if (lowerIndex < higherIndex)
		{
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	private void mergeParts(int lowerIndex, int middle, int higherIndex) 
	{

		for (int i = lowerIndex; i <= higherIndex; i++) 
		{
			tempMergArr[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex)
		{
			if (tempMergArr[i] <= tempMergArr[j]) 
			{
				array[k] = tempMergArr[i];
				i++;
			} else 
			{
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergArr[i];
			k++;
			i++;
		}

	}

	// Static Variables i for indexing the array and total for calculating the total Notes
	static int i=0;
	public static int total=0;

	//Initialization of New Array
	static int[] notes = { 1000,500,100,50,10,5,2,1};
	static int money;

	// Function for Calculating the notes
	public static  int calculate(int money,int[]notes, int i)
	{
		
		int rem;
		if(money==0)
		{
			return -1 ;
		}
		else
		{
			if(money>=notes[i])
			{
				// logic for Calculating The notes
				int calNotes =money/notes[i];
				rem = money%notes[i];
				money =rem;
				total += calNotes;
				System.out.println(notes[i]+   " Notes ---> " +calNotes );
			}
			i++;

			return calculate(money, notes, i);

		}
	}
	//end of method

	
	/*
	 * method to take input from user for continue the program
	 */
	public static boolean query(Scanner input, String prompt)
	{
		String answer;

		System.out.print(prompt + " [Y or N]: ");
		answer = input.nextLine( ).toUpperCase( );
		while (!answer.startsWith("Y") && !answer.startsWith("N"))
		{
			System.out.print("Invalid response. Please type Y or N: ");
			answer = input.nextLine( ).toUpperCase( );
		}

		return answer.startsWith("Y");
	}

	public static boolean isBalanced(String expression)
	// Postcondition: A true return value indicates that the parentheses in the
	// given expression are balanced. Otherwise the return value is false.
	// Note that characters other than ( ) { } and [ ] are ignored.
	{
		// Meaningful names for characters
		final char LEFT_NORMAL  = '(';
		final char RIGHT_NORMAL = ')';
		final char LEFT_CURLY   = '{';
		final char RIGHT_CURLY  = '}';
		final char LEFT_SQUARE  = '[';
		final char RIGHT_SQUARE = ']';

		
		//create the stack object to store the parenthesis
		Stack<Character> store = new Stack<Character>( ); // Stores parens
		int i;                              // An index into the string
		boolean failed = false;             // Change to true for a mismatch

		for (i = 0; !failed && (i < expression.length( )); i++)
		{
			switch (expression.charAt(i))
			{
			case LEFT_NORMAL:
			case LEFT_CURLY:
			case LEFT_SQUARE: 
				store.push(expression.charAt(i));
				break;
			case RIGHT_NORMAL:
				if (store.isEmpty( ) || (store.pop( ) != LEFT_NORMAL))
					failed = true;
				break;
			case RIGHT_CURLY:
				if (store.isEmpty( ) || (store.pop( ) != LEFT_CURLY))
					failed = true;
				break;
			case RIGHT_SQUARE:
				if (store.isEmpty( ) || (store.pop( ) != LEFT_SQUARE))
					failed = true;
				break;
			}
		}

		return (store.isEmpty( ) && !failed);
	}

	/**
	 * @param array - String array to be sorted
	 * @returns sorted array in ascending order
	 */
	public String[] mergeSort(String[] array){
		if(array.length == 1){
			return array;
		}
		String first[] = new String[array.length / 2];
		String last[] = new String[array.length - (array.length / 2)];
		for(int i = 0; i < first.length; i++){
			first[i] = array[i];
		}
		int j = 0;
		for(int i = first.length; i < array.length; i++){
			last[j] = array[i];
			j++;
		}
		first = mergeSort(first);
		last = mergeSort(last);

		String[] returnArray = new String[array.length];
		int firstPos = 0, lastPos = 0;
		for(int i = 0; i < returnArray.length; i++){
			if(lastPos == last.length){
				returnArray[i] = first[firstPos];
				firstPos++;
			}
			else if(firstPos == first.length){
				returnArray[i] = last[lastPos];
				lastPos++;
			}
			else if(first[firstPos].compareTo(last[lastPos]) > 0){
				returnArray[i] = last[lastPos];
				lastPos++;
			}
			else{
				returnArray[i] = first[firstPos];
				firstPos++;
			}
		}
		return returnArray;
	}


	//format date object in this format 07/08/2017 
	public String getFormatedDate(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
		return sdf.format(date);
	}
 
	
	//Take file name as input and return string of file text
		public String getFileText(String fileName){
			try{
				br=new BufferedReader(new FileReader(fileName));
				StringBuilder sb=new StringBuilder();
				String line=br.readLine();
				while(line!=null){
					sb.append(line);
					sb.append(System.lineSeparator());
					line=br.readLine();
				}
				return sb.toString();
			 }
			catch(Exception e){
				return null;
			}
			finally{
				try{
					br.close();
				}
				catch(IOException ioe){
				}	
			}
		}
		

		//Regex pattern matcher match the string and replace the regex pattern with user details.
		public String convertString(UserDetails userDetails,String message){
			Pattern p = Pattern.compile(REGEX_NAME);
			Matcher m = p.matcher(message); 
			message = m.replaceAll(userDetails.getfName());

			p = Pattern.compile(REGEX_FULLNAME);
			m = p.matcher(message); 
			message = m.replaceAll(userDetails.getfName()+" "+userDetails.getlName());

			p = Pattern.compile(REGEX_MOBILE_NO);
			m = p.matcher(message); 
			message = m.replaceAll(userDetails.mobileNo());

			p = Pattern.compile(REGEX_DATE);
			m = p.matcher(message); 
			message = m.replaceAll(userDetails.date());

			return message;
		}
		
		/**
		 * Takes user input and writes data to json objcet and object to file
		 */
		public void writeData() {
			Scanner scanner = new Scanner(System.in);
			String[] names = new String[] {"Rice" , "Wheat" , "Pulses"};
			JSONObject finalObject = new JSONObject();
			for (String name : names) {
				System.out.print("Enter number number of types of " + name + " : ");
				int count = scanner.nextInt();
				JSONArray array = new JSONArray();
				
				for(int i = 0; i < count; i++) {
					JSONObject jsonObject  = new JSONObject();
					System.out.print("Enter name, weight and price: ");
					jsonObject.put("name", scanner.next());
					jsonObject.put("weight", scanner.nextInt());
					jsonObject.put("price", scanner.nextInt());
					array.add(jsonObject);
				}			
				finalObject.put(name , array);
			}
			
			PrintWriter printWriter = null;
			try {
				printWriter = new PrintWriter("/home/bridgeit/Desktop/Inventort.txt");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			printWriter.write(finalObject.toJSONString());
			printWriter.close();
		}

		/**
		 * reads data from json file and 
		 * prints inventory value of Rice, Pulses and Wheat
		 */
		public void readData() {
			JSONArray array = new JSONArray();
			JSONParser parser = new JSONParser();
			JSONObject object;
			
			try {
				object = (JSONObject) parser.parse(new FileReader("/home/bridgeit/Desktop/Inventort.txt"));
				array = (JSONArray) object.get("Rice");
				System.out.println("Rice inventory value: " + getValue(array));
				array = (JSONArray) object.get("Pulses");
				System.out.println("Pulses inventory value: " + getValue(array));
				array = (JSONArray) object.get("Wheat");
				System.out.println("Wheat inventory value: " + getValue(array));
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (org.json.simple.parser.ParseException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * @param array - json array
		 * @returns value of given inventory array
		 */
		long getValue(JSONArray array){
			Iterator<?> iterator = array.iterator();
			long value = 0;
			while(iterator.hasNext()) {
				JSONObject obj = (JSONObject)iterator.next();
				long weight = (long)obj.get("weight");
				long price = (long)obj.get("price");
				value = value + weight * price;
			}
			return value;
		}
		
		static MyLinkedList<Stock> list;
		
		 /*
		  * method to take the stock data
		  */
			public static void getStockData() {
				Scanner scanner = new Scanner(System.in);
				System.out.print("Enter number of stocks: ");
				int count = scanner.nextInt();
				list = new MyLinkedList<Stock>();
				
				for(int i = 0; i < count; i++) {
					System.out.print("Enter stock name, number of shares and share price: ");
					String name = scanner.next();
					int numberOfShares = scanner.nextInt();
					int price = scanner.nextInt();
					Stock stock = new Stock(name, numberOfShares, price);
					list.add(stock);
				}
				scanner.close();
			}
			/*
			 * method to print the stock report
			 */
			
			public static void printReport() {
				int totalValue = 0;
				System.out.println("\nName\tShares\tPrice\tValue");
				while(!list.isEmpty()) {
					Stock folio = list.pop(0);
					totalValue += folio.getValue();
					System.out.println(folio.getName() + "\t" + folio.getNumberOfShares()
							+ "\t" + folio.getPrice() + " \t" + folio.getValue());
				}
				System.out.println("\nTotal value is: " + totalValue);
			}
			BufferedReader bufferedReader = null;
						
		
}




