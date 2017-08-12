package com.bridgelabz.programs;
/**
 * 
 * @author   : Harshil Gandhi
 * Date      : 9/08/2017
 * Purpose   :  Stopwatch Program for measuring the time that
 * 				 elapses between the start and end clicks
 *             
 **/
import com.bridgelabz.utility.Utility;
public class StopWatch 
{
	public static void main(String[] args)
	{
		
		Utility u=new Utility();
		System.out.println("Press '1' to Start Time: ");
		u.inputInteger();
		u.start();

		System.out.println();
		System.out.println("Press '2' to Stop Time: ");
		u.inputInteger();
		u.stop();

		long l=u.getElapsedTime();
		System.out.println();
		System.out.println("Total Time Elapsed(in millisec) is:"+l);
		System.out.println();
		System.out.println("Converting millisec to seconds: "+(l/1000)+" sec");
	}

}
