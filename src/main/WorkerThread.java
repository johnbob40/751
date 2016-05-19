package main;

import pu.RedLib.Reducible;
import pu.pi.ParIterator;

public class WorkerThread extends Thread {

	private ParIterator<Double> pi = null;
	//private int id = -1;
	private Reducible<Double> localSum = null;

	public WorkerThread(ParIterator<Double> pi, Reducible<Double> localSum) {
		//this.id = id;
		this.pi = pi;
		this.localSum = localSum;
	}
	
	
	
	public void run() {
		//long startTime = System.currentTimeMillis();
		double sum = 0;
		/*
		 * use parallel iterator to work through and add elements
		 */
		while (pi.hasNext()) {
			Double element = pi.next();
			sum += element;
		}
		//long endTime = System.currentTimeMillis();

		//long duration = (endTime - startTime);
		//System.out.println(duration);
		
		/*
		 * add local sum to reduction agent
		 */
		localSum.set(sum);

	}

}
