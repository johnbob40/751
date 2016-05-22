package parallel;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

import main.SequentialStatistics;
import pu.RedLib.DoubleSum;
import pu.RedLib.Reducible;
import pu.pi.ParIterator;
import pu.pi.ParIteratorFactory;
import util.WorkerThread;
import util.WorkerThread.CalculationType;

public class Skewness {
	private static long startTime;
	private static long endTime;
	private static long duration;

	public static Double compute(Collection<?> data)throws InterruptedException, ExecutionException{

		
		startTime = System.currentTimeMillis();
		Double stdDev = SequentialStatistics.calculateSkewWithoutMeanWithoutStdDev(data);

		endTime = System.currentTimeMillis();
		duration = (endTime - startTime);
		System.out.println("Skew sequential time = " + duration);
		System.out.println("Skew result is: " + stdDev);

		startTime = System.currentTimeMillis();
		if(Values.mean == -99999993){
			double mean = Mean.compute(data);
			Values.mean = mean;
		}
		/*
		 * create parallel iterator, reduction agent and thread pool
		 */
		int threadCount = Runtime.getRuntime().availableProcessors();
		//int threadCount = 1;
		ParIterator<?> pi = ParIteratorFactory.createParIterator(data, threadCount, ParIterator.Schedule.STATIC);
		Reducible<Double> localNum = new Reducible<Double>();
		Thread[] threadPool = new WorkerThread[threadCount];

		/*
		 * start threads
		 */
		for (int i = 0; i < threadCount; i++) {
			threadPool[i] = new WorkerThread(pi, localNum, CalculationType.SKEWNESSNUM, Values.mean);
			threadPool[i].start();
		}

		/*
		 * wait for threads
		 */
		for (int i = 0; i < threadCount; i++) {
			try {
				threadPool[i].join();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		
		}
		double finalNum = localNum.reduce(new DoubleSum());
		System.out.println(finalNum);

		
		if(Values.stdDev == -99999993){
			
			
			double finalDenom = StdDev.compute(data);
			finalDenom = Math.pow(finalDenom, 3);
			double finalSkewness = finalNum/(finalDenom*(data.size()));
			
			Values.skewness = finalSkewness;
			
			endTime = System.currentTimeMillis();
			duration = (endTime - startTime);
			System.out.println("Skew parallel duration = " + duration);
			System.out.println("Skew parallel result is: " + finalSkewness);
			return finalSkewness;

		}

		/*
		 * reduce threads 
		 */

		double finalSkewness = finalNum/(data.size()*Values.stdDev);

		endTime = System.currentTimeMillis();
		duration = (endTime - startTime);
		System.out.println("stddev parallel duration = " + duration);
		System.out.println("stddev parallel result is: " + finalSkewness);
		
		Values.skewness = finalSkewness;
		return finalSkewness;
	}
}
