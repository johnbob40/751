package main;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

import parallel.Average;
import util.Data;

public class Main {

	public static void main(String[] args) {
		Collection<?> data; 
		System.out.println("Creating List");
		int size = 100000000;
		data= Data.generateRandomList(size);
		System.out.println("List created");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		timeSequential(data);


		try {
			new Average().compute(data);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	private static void timeSequential(Collection<?> data){
		long timeStart = System.currentTimeMillis();
		System.out.println("List created, starting  \t " + timeStart);
		SequentialStatistics.calculate(data, true, true, true, true, true, true, true);

		long timeEnd = System.currentTimeMillis();
		System.out.println("calculation done \t " + timeEnd);

		long timeTaken = timeEnd - timeStart;

		System.out.println("time taken with median = " + timeTaken/1000.0 + " seconds");

		timeStart = System.currentTimeMillis();
		System.out.println("starting second round");
		SequentialStatistics.calculate(data, true, false, true, true, true, false, true);

		timeEnd = System.currentTimeMillis();
		System.out.println("calculation done");

		timeTaken = timeEnd - timeStart;

		System.out.println("time taken without median = " + timeTaken/1000.0 + " seconds");
		
		/*
		 * Create new list and start process (PARCutils-1.1.0.jar needs to be on build path)
		 */

	}
}
