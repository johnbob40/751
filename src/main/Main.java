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
		int size = 5000000;
		data= Data.generateRandomList(size);
		System.out.println("List created");

		Thread.sleep(2000);

		startTime = System.currentTimeMillis();
//		List<?> d2 = SequentialStatistics.sequentialSort(data);
		System.out.println(SequentialStatistics.calculateStdDevWithoutMean(data));
		endTime = System.currentTimeMillis();
		System.out.println("Sequential time = " + (endTime - startTime));
		
		startTime = System.currentTimeMillis();
		System.out.println(StdDev.compute(data));
		endTime = System.currentTimeMillis();
		System.out.println("parallel time = " + (endTime - startTime));

		
	}
}
