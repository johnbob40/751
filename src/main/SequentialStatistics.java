package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SequentialStatistics {

	public static String[] calculate(Collection<?> data, boolean mean,
			boolean median, boolean max, boolean min, boolean stdDev,
			boolean intQuartRange, boolean skewness){
		
		if (data == null){
			return null;
		} else if (data.size() == 0){
			return null;
		}


		return null;
	}

	public static Double calculateMean(Collection<?> data){
		Double sum = new Double(0);
		Double value = new Double(0);

		for (Object i : data){
			value = (double) i;
			sum += value;
		}
		return sum/data.size();
	}

	public static Double calculateMaxUnsorted(Collection<?> data){
		Iterator<?> it = data.iterator();

		//Getting the first element to use as the reference max
		Double max = (Double) it.next();

		while (it.hasNext()){	
			Double temp = (Double) it.next();
			if (temp > max){
				max = temp;
			}
		}	
		return max;
	}

	public static Double calculateMaxSorted(Collection<?> data) {
		//TODO this should not iterate. THis should be const time
		Iterator<?> it = data.iterator();
		return (Double) it.next();

	}

	public static Double calculateMinUnsorted(Collection<?> data){
		Iterator<?> it = data.iterator();

		//Getting the first element to use as the reference min
		Double min = (Double) it.next();

		while (it.hasNext()){	
			Double temp = (Double) it.next();
			if (temp < min){
				min = temp;
			}
		}	
		return min;
	}
	public static Double calculateMinSorted(Collection<?> data) {
		Iterator<?> it = data.iterator();
		return (Double) it.next();
	}

	public static Double calculateStdDevWithoutMean(Collection<?> data){
		double mean = calculateMean(data);
		double meanSquare = 0;
		Collection<Double> deviations = new ArrayList<Double>();
		for (Object i : data){
			meanSquare = ((Double)i ) - mean;
			deviations.add(Math.pow(meanSquare, 2));
		}
		return Math.sqrt(calculateMean(deviations));
	}
	
	public static Double calculateStdDevWithMean(Collection<?> data, Double mean){
		double meanSquare = 0;
		Collection<Double> deviations = new ArrayList<Double>();

		for (Object i : data){
			meanSquare = ((Double) i) - mean;
			deviations.add(Math.pow(meanSquare, 2.0));
		}

		return Math.sqrt(calculateMean(deviations));
	}

	
	public static Double calculateSkewWithoutMean(Collection<?> data){
		System.out.println(data);
		Double mean = calculateMean(data);
		Double stdDev = calculateStdDevWithMean(data, mean);
		System.out.println("mean = " + mean);
		System.out.println("stdDev = " + stdDev + "\n\n");
		Double sum = new Double(0);
		Iterator<?> it = data.iterator();

		while (it.hasNext()){	
			Double temp = (Double) it.next();
			temp -= mean;
			//raising to power of 3
			temp = Math.pow(temp, 3);
			sum += temp;
		}	
		Double denominator = (data.size() - 1) * Math.pow(stdDev, 3);
		return sum/denominator;
	}
	
	public static List<Double> sequentialSort(Collection<?> data) {
		List<Double> listToSort = new ArrayList<Double>();
		Iterator<?> it = data.iterator();
		while (it.hasNext()) {
			listToSort.add((Double)it.next());
		}
		Collections.sort(listToSort); // Using java native sort function
		return listToSort;
	}
	
	public static Double calculateMedian(Collection<?> data) {
		List<Double> sortedCollection = sequentialSort(data);
		int size = sortedCollection.size();
		if (size % 2 == 0) {
			double medianLeft = sortedCollection.get((size / 2) - 1);
			double medianRight = sortedCollection.get(size / 2);
			double diff = Math.abs(medianLeft - medianRight);
			return Math.min(medianLeft, medianRight) + (diff / 2);
		} else {
			return sortedCollection.get((size - 1) / 2);
		}
	}
}
