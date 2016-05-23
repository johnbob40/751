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

		Thread.sleep(2000);

		Sorting.iQR(data);
	
	}
}
