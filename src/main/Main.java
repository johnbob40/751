package main;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Collection<?> data; 
		System.out.println("Creating List");
		data = Data.generateReverse(100000000);
		
		/*
		List<Double> dummyData = (List<Double>) Data.generateReverse(5);
		System.out.println(dummyData.get(0));
		meh(dummyData);
		System.out.println(dummyData.get(0));
		 */
		
//		timeSequential(data);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Creating List");
		Collection<?> data = Data.generateReverse(50000000);

		int size = 5000000;
		Collection<Double> elements = Data.generateRandomList(size);
		new Average1().compute(elements, size);
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

	private static void meh(List<Double> data){
		Double temp = data.get(0);
		data.set(0, data.get(data.size() - 1));
		data.set(data.size() - 1, temp);
	}
}
