package util;

import pu.RedLib.Reducible;
import pu.pi.ParIterator;

public class WorkerThread extends Thread {

	public enum CalculationType{MEAN, MEDIAN, MAX, MIN, STDDEV, INTERQUARTILERANGE, SKEWNESS}
	private ParIterator<?> pi = null;
	private Reducible<Double> localSum = null;
	private CalculationType calculationType;

	public WorkerThread(ParIterator<?> pi2, Reducible<Double> localSum, CalculationType mean) {
		//this.id = id;
		this.pi = pi2;
		this.localSum = localSum;
		this.calculationType = mean;
	}



	public void run() {
		//long startTime = System.currentTimeMillis();
		switch (calculationType){
		case MEAN:
			calculateMean();
		break;

		case MEDIAN:
			calculateMedian();
		break;

		case MAX:
			calculateMax();
		break;

		case MIN:
			calculateMin();
		break;

		case STDDEV:
			calculateStdDev();
		break;

		case INTERQUARTILERANGE:
			calculateInterQuartileRange();
		break;

		case SKEWNESS:
			calculateSkewness();
		break;

		default:
			break;
		}


	}

	private void calculateInterQuartileRange() {
		// TODO Auto-generated method stub

	}



	private void calculateSkewness() {
		// TODO Auto-generated method stub

	}



	private void calculateStdDev() {
		// TODO Auto-generated method stub

	}



	private void calculateMin() {
		Double min = new Double(0);
		if (pi.hasNext()){
			min = (Double) pi.next();
		}
		//use parallel iterator to work through and add elements
		while (pi.hasNext()) {
			Double element = (Double) pi.next();
			if (min > element){
				min = element;
			}
		}

		//add local min to reduction agent
		localSum.set(min);
	}



	private void calculateMax() {
		Double max = new Double(0);
		
		if (pi.hasNext()){
			max = (double) pi.next();
		}
		//use parallel iterator to work through and add elements
		while (pi.hasNext()) {
			Double element = (Double) pi.next();
			if (max < element){
				max = element;
			}
		}

		//add local max to reduction agent
		localSum.set(max);
	}



	private void calculateMedian() {
		// TODO Auto-generated method stub

	}


	private void calculateMean(){
		double sum = 0;
		//use parallel iterator to work through and add elements
		while (pi.hasNext()) {
			Double element = (Double) pi.next();
			sum += element;
		}

		//add local sum to reduction agent
		localSum.set(sum);
	}
}
