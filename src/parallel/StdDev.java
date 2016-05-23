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

public class StdDev {

	private static long startTime;
	private static long endTime;
	private static long duration;

	public static Double compute(Collection<?> data)throws InterruptedException, ExecutionException{


		startTime = System.currentTimeMillis();
		if(Values.mean == null){
			double mean = Mean.compute(data);
			Values.mean = mean;
		}
		/*
		 * create parallel iterator, reduction agent and thread pool
		 */
		int threadCount = Runtime.getRuntime().availableProcessors();
		//int threadCount = 1;
		ParIterator<?> pi = ParIteratorFactory.createParIterator(data, threadCount, ParIterator.Schedule.STATIC);
		Reducible<Double> localSum = new Reducible<Double>();
		Thread[] threadPool = new WorkerThread[threadCount];

		/*
		 * start threads
		 */
		for (int i = 0; i < threadCount; i++) {
			threadPool[i] = new WorkerThread(pi, localSum, CalculationType.STDDEV, Values.mean);
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

		/*
		 * reduce threads 
		 */
		double finalDev = localSum.reduce(new DoubleSum());

		finalDev = finalDev/data.size();
		finalDev = Math.sqrt(finalDev);
		endTime = System.currentTimeMillis();
		duration = (endTime - startTime);
		System.out.println("stddev parallel duration = " + duration);
		System.out.println("stddev parallel result is: " + finalDev);






		startTime = System.currentTimeMillis();
		Double stdDev = SequentialStatistics.calculateStdDevWithoutMean(data);

		endTime = System.currentTimeMillis();
		duration = (endTime - startTime);
		System.out.println("stddev sequential time = " + duration);
		System.out.println("stddev result is: " + stdDev);

		/*
		//TODO take out
		Thread.sleep(2000);
		 */




		Values.stdDev = stdDev;
		return stdDev;
	}

}
