package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;

import pu.RedLib.DoubleSum;
import pu.RedLib.Reducible;
import pu.pi.ParIterator;
import pu.pi.ParIteratorFactory;

public class Average1 {
	
	//public static double compute()

	public void compute(Collection<?> data, int size)throws InterruptedException, ExecutionException{
		//Collection<Double> elements = Data.generateRandomList(size);
		long startTime = System.currentTimeMillis();
		double x = 0;
		Double temp;
		for(Object d : data){
			temp = (Double) d;
			x += temp;
			//System.out.println(Thread.currentThread().getId());
		}

		long endTime = System.currentTimeMillis();
		double mean = x/size;
		long duration = (endTime - startTime);
		System.out.println(duration);
		System.out.println(mean);
		
		
		
		
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
		
		
		//endTime = System.currentTimeMillis();
		
		
		mean = 0;
		mean = finalSum/size;
		endTime = System.currentTimeMillis();
		duration = (endTime - startTime);
		System.out.println(duration);
		System.out.println(mean);
		}
	
}