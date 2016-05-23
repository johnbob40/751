package main;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import parallel.*;
import sequential.SequentialStatistics;
import util.Data;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) throws Exception{
		long startTime = 0;
		long endTime = 0;
		/*
		Collection<?> data; 
		System.out.println("Creating List");
		int size = 85000;
		data= Data.generateRandomList(size);
		System.out.println("List created");

		startTime = System.currentTimeMillis();
		System.out.println(SequentialStatistics.calculate(data, true, true, true, true, true, true, true));
		endTime = System.currentTimeMillis();
		System.out.println("Sequential time = " + (endTime - startTime));
		
		startTime = System.currentTimeMillis();
		OptimisedStatistics.calculate(data, true, true, true, true, true, true, true);
//		System.out.println(Min.compute(data));
		endTime = System.currentTimeMillis();
		System.out.println("parallel time = " + (endTime - startTime));
		 */
		int[] data = {1,2,3,4,5,6,7,8,9};
//		double[] data = {1,2,3,4,5,6,7,8,9};
//		long[] data = {1,2,3,4,5,6,7,8,9};
//		short[] data = {1,2,3,4,5,6,7,8,9};
//		float[] data = {1,2,3,4,5,6,7,8,9};
//		TreeSet<Double> data = new TreeSet<Double>();
//		for (int i = 0; i < 10; i++){
//			data.add(new Double(i));
//		}
		System.out.println(OptimisedStatistics.calculate(data, true, true, true, true, true, true, true));
		
	}
}