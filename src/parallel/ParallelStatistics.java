package parallel;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import sequential.SequentialStatistics;

public class ParallelStatistics {

	public static HashMap<String, Double> calculate(Collection<?> inputData, boolean mean,
			boolean median, boolean max, boolean min, boolean stdDev,
			boolean intQuartRange, boolean skewness){

		HashMap<String, Double> results = new HashMap<String, Double>();

		if (inputData == null || inputData.size() == 0){
			return results;
		}

		if (inputData.size() < 1000){
			//to small, do sequentially
			return SequentialStatistics.calculate(inputData, mean, median, max, min, stdDev, intQuartRange, skewness);
		}
		try {
			List<?> sortedData;

			if (mean){
				results.put("mean", Mean.compute(inputData));
			}
			if (median){
				Values.sortedArray = Sorting.parallelSort(inputData);
				sortedData = Arrays.asList(Values.sortedArray);
				Double med = Median.compute();
				results.put("median", med);
				Values.median = med;
				if (intQuartRange) {
					Values.IQR = IQR.compute();
					results.put("interquartile range", Values.IQR);
				}
				if (max){
					Values.max = Max.compute(sortedData);
					results.put("max", Values.max);
				}
				if (min){
					Values.min = Min.compute(sortedData);
					results.put("min",Values.min);
				}
			} else {
				if (intQuartRange) {		
					Values.sortedArray = Sorting.parallelSort(inputData);
					sortedData = Arrays.asList(Values.sortedArray);

					results.put("interquartile range", IQR.compute());
					if (max){
						Values.max = Max.compute(sortedData);
						results.put("max", Values.max);
					}
					if (min){
						Values.min = Min.compute(sortedData);
						results.put("min",Values.min);
					}
				} else {
					if (max){
						Values.max = Max.compute(inputData);
						results.put("max", Values.max);
					}
					if (min){
						Values.min = Min.compute(inputData);
						results.put("min",Values.min);
					}
				}
			}
			if (stdDev){
				Values.stdDev = StdDev.compute(inputData);
				results.put("stdDev", Values.stdDev);
			}
			if (skewness){
				Values.skewness = Skewness.compute(inputData);
				results.put("skewness", Values.skewness);

			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return results;
	}

}
