package parallel;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

import pu.RedLib.DoubleMinimum;
import pu.RedLib.Reducible;
import pu.pi.ParIterator;
import pu.pi.ParIteratorFactory;
import util.WorkerThread;
import util.WorkerThread.CalculationType;

public class Min {

	//public static double compute()

	public static Double compute(Collection<?> data)throws InterruptedException, ExecutionException{
		long startTime = System.currentTimeMillis();
		Double temp, min;
		Iterator<?> it = data.iterator();

		//Getting the first element to use as the reference max
		min = (Double) it.next();

		while (it.hasNext()){	
			temp = (Double) it.next();
			if (temp < min){
				min = temp;
			}
		}	

		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println("sequential time = " + duration);
		System.out.println("result is: " + min);

		/*
		//TODO take out
		Thread.sleep(2000);
		 */

		startTime = System.currentTimeMillis();

		/*
		 * create parallel iterator, reduction agent and thread pool
		 */
		int threadCount = Runtime.getRuntime().availableProcessors();
		ParIterator<?> pi = ParIteratorFactory.createParIterator(data, threadCount, ParIterator.Schedule.STATIC);
		Reducible<Double> localMin = new Reducible<Double>();
		Thread[] threadPool = new WorkerThread[threadCount];

		/*
		 * start threads
		 */
		for (int i = 0; i < threadCount; i++) {
			threadPool[i] = new WorkerThread(pi, localMin, CalculationType.MIN);
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
		double finalMin = localMin.reduce(new DoubleMinimum());

		endTime = System.currentTimeMillis();
		duration = (endTime - startTime);
		System.out.println("paralel duration = " + duration);
		System.out.println("parallel result is: " + finalMin);
		return finalMin;
	}

}
