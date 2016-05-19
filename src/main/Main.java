package main;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

public class Main {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		// TODO Auto-generated method stub
		/*System.out.println("Creating List");
		Collection<?> data = Data.generateReverse(50000000);

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

		System.out.println("time taken without median = " + timeTaken/1000.0 + " seconds");*/
		//Average.average();
		
		
		/*
		 * Create new list and start process (PARCutils-1.1.0.jar needs to be on build path)
		 */
		int size = 5000000;
		Collection<Double> elements = Data.generateRandomList(size);
		new Average1().compute(elements, size);
	}

}
