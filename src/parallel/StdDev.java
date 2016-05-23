package parallel;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

import pu.RedLib.DoubleSum;
import pu.RedLib.Reducible;
import pu.pi.ParIterator;
import pu.pi.ParIteratorFactory;
import util.WorkerThread;
import util.WorkerThread.CalculationType;

public class StdDev {
	public static Double compute(Collection<?> data)throws InterruptedException, ExecutionException{
		if(Values.mean == null){
			Values.mean = Mean.compute(data);
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


		Values.stdDev = finalDev;
		return finalDev;
	}

}
