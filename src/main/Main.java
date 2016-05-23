package main;

import java.util.Collection;
import java.util.List;

import parallel.*;
import sequential.SequentialStatistics;
import util.Data;

public class Main {

	public static void main(String[] args) throws Exception{
		long startTime = 0;
		long endTime = 0;
		Collection<?> data; 
		System.out.println("Creating List");
		int size = 10000;
		data= Data.generateRandomList(size);
		System.out.println("List created");
		/*

		List<?> d2 = SequentialStatistics.sequentialSort(data);
		startTime = System.currentTimeMillis();
		System.out.println(SequentialStatistics.calculateQuartileRange(d2));
		endTime = System.currentTimeMillis();
		System.out.println("Sequential time = " + (endTime - startTime));
		
		Values.sortedArray = d2.toArray(new Double[size]);
		startTime = System.currentTimeMillis();
		IQR.compute();
//		System.out.println(Min.compute(data));
		endTime = System.currentTimeMillis();
		System.out.println("parallel time = " + (endTime - startTime));
*/
//		int[] data = {1,2,3,4,5,6,7,8,9};
//		double[] data = {1,2,3,4,5,6,7,8,9};
//		long[] data = {1,2,3,4,5,6,7,8,9};
//		short[] data = {1,2,3,4,5,6,7,8,9};
//		float[] data = {1,2,3,4,5,6,7,8,9};
		
		System.out.println(OptimisedStatistics.calculate(data, true, true, true, true, true, true, true));
		
	}
}