package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SequentialStatistics {

	public static String[] calculate(Collection<?> data, boolean mean,
			boolean median, boolean max, boolean min, boolean stdDev,
			boolean intQuartRange, boolean skewness, boolean corrCoef){
		
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
			deviations.add(meanSquare * meanSquare);
		}

		return calculateMean(deviations);
	}
	
	public static Double calculateStdDevWithMean(Collection<?> data, Double mean){
		double meanSquare = 0;
		Collection<Double> deviations = new ArrayList<Double>();

		for (Object i : data){
			meanSquare = ((Double) i) - mean;
			deviations.add(meanSquare * meanSquare);
		}

		return calculateMean(deviations);
	}
	
	public static Collection<Double> sequentialSort(Collection<?> data) {
		List<Double> listToSort = new ArrayList<Double>();
		Iterator<?> it = data.iterator();
		while (it.hasNext()) {
			listToSort.add((Double)it.next());
		}
		Collections.sort(listToSort);
		return listToSort;
	}
}
