package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import sequential.SequentialStatistics;
import parallel.*;

@SuppressWarnings("unused")
public class OptimisedStatistics {

	public static HashMap<String, Double> calculate(Collection<?> inputData, boolean mean,
			boolean median, boolean max, boolean min, boolean stdDev,
			boolean intQuartRange, boolean skewness){
		HashMap<String, Double> answers = new HashMap<String, Double>();

		boolean sorted = false;
		List<Double> sortedData = null;
		if (median || intQuartRange){
			//sort
			sortedData = new ArrayList<>(Arrays.asList(Sorting.parallelSort(inputData)));
			Values.sortedArray = sortedData.toArray(new Double[sortedData.size()]);
			sorted = true;
		}
		if (mean){
			Values.mean = SequentialStatistics.calculateMean(inputData);
		}
		if (max){
			if (sorted){
				//not using method to reduce overhead of method call
				Values.max = sortedData.get(sortedData.size() - 1);
			} else {
				Values.max = SequentialStatistics.calculateMaxUnsorted(inputData);
			}
		}
		if (min){
			if (sorted){
				//not using method to reduce overhead of method call
				Values.min = sortedData.get(0);
			} else {
				Values.min = SequentialStatistics.calculateMinUnsorted(inputData);
			}
		}
		if (median){
			//Already used the parallel sort, so kinda irrelevant which 
			//algorithm is used here
			Values.median = SequentialStatistics.calculateMedian(sortedData);
		}
		if (stdDev){
			if (mean){
				Values.stdDev = SequentialStatistics.calculateStdDevWithMean(inputData, Values.mean);
			} else {
				Values.stdDev = SequentialStatistics.calculateStdDevWithoutMean(inputData);
			}
		}
		
		if (skewness){
			if (sorted){
				Values.skewness = Skewness.compute(sortedData);
			} else {
				Values.skewness = Skewness.compute(inputData);
			}
		}
		if (intQuartRange){
			Values.IQR = SequentialStatistics.calculateQuartileRange(sortedData);
		}

		//converting to the hashmap returned
		if (mean){
			answers.put("mean", Values.mean);
		}
		if (median){
			answers.put("median", Values.median);
		}
		if (max){
			answers.put("max", Values.max);
		}
		if (min){
			answers.put("min", Values.min);
		}
		if (skewness){
			answers.put("skewness", Values.skewness);
		}
		if (stdDev){
			answers.put("stdDev", Values.stdDev);
		}
		if (intQuartRange){
			answers.put("intQuartRange", Values.IQR);
		}

		return answers;


	}
}
