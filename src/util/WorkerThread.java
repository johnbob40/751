package util;

import pu.RedLib.Reducible;
import pu.pi.ParIterator;

public class WorkerThread extends Thread {

	public static enum CalculationType{MEAN, MEDIAN, MAX, MIN, STDDEV, SKEWNESSNUM, SKEWNESSDENOM}
	private ParIterator<?> pi = null;
	private Reducible<Double> localSum = null;
	private CalculationType calculationType;
	private Double mean = null;

	public WorkerThread(ParIterator<?> pi, Reducible<Double> localSum, CalculationType type) {
		//this.id = id;
		this.pi = pi;
		this.localSum = localSum;
		this.calculationType = type;
	}

	public WorkerThread(ParIterator<?> pi, Reducible<Double> localSum, CalculationType type, double mean) {
		//this.id = id;
		this.pi = pi;
		this.localSum = localSum;
		this.calculationType = type;
		this.mean = mean;

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

		case SKEWNESSDENOM:
			calculateSkewnessDenom();
			break;

		case SKEWNESSNUM:
			calculateSkewnessNum();
			break;
		default:
			break;
		}


	}

	private void calculateSkewnessNum() {
		double mean = this.mean;
		double meanSquare = 0;
		double deviations = 0;

		while (pi.hasNext()){
			meanSquare = 0;
			meanSquare = (Double)pi.next() - mean;
			meanSquare = Math.pow(meanSquare, 3.00);
			deviations += meanSquare;
		}

		//deviations = Math.pow(deviations, 3.00);
		//deviations = Math.sqrt(deviations);

		localSum.set(deviations);

	}

	private void calculateSkewnessDenom() {
		double mean = this.mean;
		double meanSquare = 0;
		double deviations = 0;

		while (pi.hasNext()){
			meanSquare = 0;
			meanSquare = (Double)pi.next() - mean;
			meanSquare = Math.pow(meanSquare, 3.000);
			deviations += meanSquare;
		}

		localSum.set(deviations);
	}


	private void calculateStdDev() {

		//double mean = Mean.compute(data);
		double mean = this.mean;
		double meanSquare = 0;
		double deviations = 0;

		while (pi.hasNext()){
			meanSquare = 0;
			meanSquare = (Double)pi.next() - mean;
			meanSquare = Math.pow(meanSquare, 2.000);
			deviations += meanSquare;
		}

		localSum.set(deviations);

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
