package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SequentialStatistics {

	public static HashMap<String, Double> calculate(Collection<?> inputData, boolean mean,
			boolean median, boolean max, boolean min, boolean stdDev,
			boolean intQuartRange, boolean skewness){

		HashMap<String, Double> results = new HashMap<String, Double>();

		if (inputData == null || inputData.size() == 0){
			return results;
		}

		List<?> sortedData;

		if (mean){
			results.put("mean", calculateMean(inputData));
		}
		if (median){
			sortedData = sequentialSort(inputData);
			results.put("median", calculateMedian(sortedData));
			if (intQuartRange) {
				results.put("interquartile range", calculateQuartileRange(sortedData));
			}
			if (max){
				results.put("max", calculateMaxSorted(sortedData));
			}
			if (min){
				results.put("min",calculateMinSorted(sortedData));
			}
		} else {
			if (intQuartRange) {
				sortedData = sequentialSort(inputData);
				results.put("interquartile range", calculateQuartileRange(sortedData));
				if (max){
					results.put("max", calculateMaxSorted(sortedData));
				}
				if (min){
					results.put("min",calculateMinSorted(sortedData));
				}
			} else {
				if (max){
					results.put("max", calculateMaxUnsorted(inputData));
				}
				if (min){
					results.put("min",calculateMinUnsorted(inputData));
				}
			}
		}
		if (stdDev){
			if (mean){
				results.put("stdDev", calculateStdDevWithMean(inputData, results.get("mean")));
			} else {
				results.put("stdDev", calculateStdDevWithoutMean(inputData));
			}
		}
		if (skewness){
			if (mean){
				if (stdDev){
					//have both
					results.put("skewness", calculateSkewWithMeanWithStdDev(inputData, results.get("mean"), results.get("stdDev")));
				} else {
					//have mean but not stdDev
					results.put("skewness", calculateSkewWithMeanWithoutStdDev(inputData, results.get("mean")));
				}
			} else {
				if (stdDev){
					//dont have mean, but have std Dev
					results.put("skewness", calculateSkewWithoutMeanWithStdDev(inputData, results.get("stdDev")));
				} else { 
					//dont have mean or std dev
					results.put("skewness", calculateSkewWithoutMeanWithoutStdDev(inputData));
				}
			}

		}
		return results;
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

	public static Double calculateMaxSorted(List<?> data) {
		return (Double) data.get(data.size() - 1);

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


	public static Double calculateSkewWithoutMeanWithoutStdDev(Collection<?> data){
		Double mean = calculateMean(data);
		Double stdDev = calculateStdDevWithMean(data, mean);
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
	public static Double calculateSkewWithMeanWithoutStdDev(Collection<?> data, Double mean){
		Double stdDev = calculateStdDevWithMean(data, mean);
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
	public static Double calculateSkewWithMeanWithStdDev(Collection<?> data, Double mean, Double stdDev){
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
	public static Double calculateSkewWithoutMeanWithStdDev(Collection<?> data, Double stdDev){
		Double mean = calculateMean(data);
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

		//creating copy of collection and converting to list for data integrity
		Iterator<?> it = data.iterator();
		while (it.hasNext()) {
			listToSort.add((Double)it.next());
		}
		
		Collections.sort(listToSort); // Using java native sort function
		return listToSort;
	}

	public static double calculateMedian(List<?> data) {
		int size = data.size();
		if (size % 2 == 0) {
			double medianLeft = (double) data.get((size / 2) - 1);
			double medianRight = (double) data.get(size / 2);
			double diff = Math.abs(medianLeft - medianRight);
			return Math.min(medianLeft, medianRight) + (diff / 2);
		} else {
			return (double) data.get((size - 1) / 2);
		}
	}

	public static List<?> sort(Collection<?> data){
		return sequentialSort(data);
	}

	public static Double calculateQuartileRange(List<?> data) {
		double leftQuartile;
		double rightQuartile;
		int size = data.size();
		if (size < 4) {
			return null;
		} 
		if (size % 2 == 0) {
			int halfSize = size / 2;
			if (halfSize % 2 == 0) {
				double leftQuartileLeft = (double) data.get((halfSize / 2) - 1);
				double leftQuartileRight = (double) data.get(halfSize / 2);
				double diff = Math.abs(leftQuartileLeft - leftQuartileRight);
				leftQuartile = Math.min(leftQuartileLeft, leftQuartileRight) + (diff / 2);
				double rightQuartileLeft = (double) data.get(halfSize + (halfSize / 2) - 1);
				double rightQuartileRight = (double) data.get(halfSize + (halfSize / 2));
				diff = Math.abs(rightQuartileLeft - rightQuartileRight);
				rightQuartile = Math.min(rightQuartileLeft, rightQuartileRight) + (diff / 2);
			} else {
				leftQuartile = (double)data.get((halfSize - 1) / 2);
				rightQuartile = (double)data.get(halfSize + (halfSize - 1) / 2);
			}
		} else {
			int halfSize = (size - 1) / 2;
			if (halfSize % 2 == 0) {
				double leftQuartileLeft = (double) data.get((halfSize / 2) - 1);
				double leftQuartileRight = (double) data.get(halfSize / 2);
				double diff = Math.abs(leftQuartileLeft - leftQuartileRight);
				leftQuartile = Math.min(leftQuartileLeft, leftQuartileRight) + (diff / 2);
				double rightQuartileLeft = (double) data.get(halfSize + (halfSize / 2));
				double rightQuartileRight = (double) data.get(halfSize + (halfSize / 2) + 1);
				diff = Math.abs(rightQuartileLeft - rightQuartileRight);
				rightQuartile = Math.min(rightQuartileLeft, rightQuartileRight) + (diff / 2);
			} else {
				leftQuartile = (double)data.get((halfSize - 1) / 2);
				rightQuartile = (double)data.get(halfSize + ((halfSize - 1) / 2) + 1);
			}
		}
		return rightQuartile - leftQuartile;
	}
}
