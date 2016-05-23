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

	public static Double compute(Collection<?> data) throws InterruptedException, ExecutionException{
		if(Values.mean.equals(null)){
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
		//Arrays.pa
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
		
		if(Values.stdDev == null){
			double finalDenom = StdDev.compute(data);
			finalDenom = Math.pow(finalDenom, 3);
			double finalSkewness = finalNum/(finalDenom*(data.size()));
			
			Values.skewness = finalSkewness;
			return finalSkewness;

		}

		/*
		 * reduce threads 
		 */

		double finalSkewness = finalNum/(data.size()*Values.stdDev);
		Values.skewness = finalSkewness;
		return finalSkewness;
	}
}
