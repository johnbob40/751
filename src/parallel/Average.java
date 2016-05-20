package parallel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;

import pu.RedLib.DoubleSum;
import pu.RedLib.Reducible;
import pu.pi.ParIterator;
import pu.pi.ParIteratorFactory;
import util.WorkerThread;

public class Average {

	//public static double compute()

	public void compute(Collection<?> data)throws InterruptedException, ExecutionException{
		long startTime = System.currentTimeMillis();
		double x = 0;
		Double temp;
		for(Object d : data){
			temp = (Double) d;
			x += temp;
			//System.out.println(Thread.currentThread().getId());
		}

		double mean = x/data.size();
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println("sequential time = " + duration);
		System.out.println("result is: " + mean);

		Thread.sleep(2000);


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
			threadPool[i] = new WorkerThread(pi, localSum);
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
		double finalSum = localSum.reduce(new DoubleSum());

		mean = finalSum/data.size();
		endTime = System.currentTimeMillis();
		duration = (endTime - startTime);
		System.out.println("paralel duration = " + duration);
		System.out.println("parallel result is: " + mean);
	}

}