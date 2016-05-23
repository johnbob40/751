package main;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

import parallel.*;
import util.Data;

//@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) throws Exception{
		long startTime = 0;
		long endTime = 0;
		Collection<?> data; 
		System.out.println("Creating List");
		int size = 10000000;
		data= Data.generateRandomList(size);
		System.out.println("List created");

		Thread.sleep(2000);

		
		startTime = System.currentTimeMillis();
		System.out.println(Skewness.compute(data));
		endTime = System.currentTimeMillis();
		System.out.println("parallel time = " + (endTime - startTime));

		
		startTime = System.currentTimeMillis();
//		List<?> d2 = SequentialStatistics.sequentialSort(data);
		System.out.println(SequentialStatistics.calculateSkewWithoutMeanWithoutStdDev(data));
		endTime = System.currentTimeMillis();
		System.out.println("sequential time = " + (endTime - startTime));

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
