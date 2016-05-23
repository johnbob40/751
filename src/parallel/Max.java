package parallel;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

import main.SequentialStatistics;
import pu.RedLib.DoubleMaximum;
import pu.RedLib.Reducible;
import pu.pi.ParIterator;
import pu.pi.ParIteratorFactory;
import util.WorkerThread;
import util.WorkerThread.CalculationType;

public class Max {

	//public static double compute()

	public static Double compute(Collection<?> data)throws InterruptedException, ExecutionException{
		long startTime = System.currentTimeMillis();
		Double max = SequentialStatistics.calculateMaxUnsorted(data);

		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println("sequential time = " + duration);
		System.out.println("result is: " + max);


		startTime = System.currentTimeMillis();

		/*
		 * create parallel iterator, reduction agent and thread pool
		 */
		int threadCount = Runtime.getRuntime().availableProcessors();
		ParIterator<?> pi = ParIteratorFactory.createParIterator(data, threadCount, ParIterator.Schedule.STATIC);
		Reducible<Double> localMax = new Reducible<Double>();
		Thread[] threadPool = new WorkerThread[threadCount];

		/*
		 * start threads
		 */
		for (int i = 0; i < threadCount; i++) {
			threadPool[i] = new WorkerThread(pi, localMax, CalculationType.MAX);
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
		double finalMax = localMax.reduce(new DoubleMaximum());

		endTime = System.currentTimeMillis();
		duration = (endTime - startTime);
		System.out.println("paralel duration = " + duration);
		System.out.println("parallel result is: " + finalMax);
		
		
		Values.max = finalMax;
		return finalMax;
	}

}