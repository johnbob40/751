package parallel;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

import pu.RedLib.DoubleSum;
import pu.RedLib.Reducible;
import pu.pi.ParIterator;
import pu.pi.ParIteratorFactory;
import util.WorkerThread;
import util.WorkerThread.CalculationType;

public class Mean {

	private static long startTime;
	private static long endTime;
	private static long duration;
	private static double mean;

	public static Double compute(Collection<?> data)throws InterruptedException, ExecutionException{
		/*startTime = System.currentTimeMillis();
		double x = 0;
		Double temp;
		for(Object d : data){
			temp = (Double) d;
			x += temp;
			//System.out.println(Thread.currentThread().getId());
		}

		double mean = x/data.size();
		endTime = System.currentTimeMillis();
		duration = (endTime - startTime);
		System.out.println("mean sequential time = " + duration);
		System.out.println("mean result is: " + mean);

		//Thread.sleep(2000);*/


		startTime = System.currentTimeMillis();

		/*
		 * create parallel iterator, reduction agent and thread pool
		 */
		int threadCount = Runtime.getRuntime().availableProcessors();
		ParIterator<?> pi = ParIteratorFactory.createParIterator(data, threadCount, ParIterator.Schedule.STATIC);
		Reducible<Double> localSum = new Reducible<Double>();
		Thread[] threadPool = new WorkerThread[threadCount];

		/*
		 * start threads
		 */
		for (int i = 0; i < threadCount; i++) {
			threadPool[i] = new WorkerThread(pi, localSum, CalculationType.MEAN);
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
		double finalAverage = localSum.reduce(new DoubleSum());
		mean = 0;
		mean = finalAverage/data.size();
		endTime = System.currentTimeMillis();
		duration = endTime - startTime;
		System.out.println("mean parallel duration = " + duration);
		System.out.println("mean parallel result is: " + mean);
		return mean;
	}

}