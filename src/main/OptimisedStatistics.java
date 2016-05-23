package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import sequential.SequentialStatistics;
import parallel.*;

public class OptimisedStatistics {

	public static HashMap<String, Double> calculate(Collection<?> inputData, boolean mean,
			boolean median, boolean max, boolean min, boolean stdDev,
			boolean intQuartRange, boolean skewness){
		
//		System.out.println("Calling top level calculate");
//		System.out.println(inputData.size());
		HashMap<String, Double> answers = new HashMap<String, Double>();

		if (inputData == null || inputData.size() == 0){
			//little bit of robustness
			return answers;
		}

		boolean sorted = false;
		List<Double> sortedData = null;
		if (median || intQuartRange){
			//sort
//			System.out.println("asdfgd  " + inputData.size());
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

	//Accounting for primitive arrays of type Double
	public static HashMap<String, Double> calculate(Double[] inputData, boolean mean,
			boolean median, boolean max, boolean min, boolean stdDev,
			boolean intQuartRange, boolean skewness){

		Collection<?> data = Arrays.asList(inputData);
		return calculate(data, mean, median, max, min, stdDev, intQuartRange, skewness);

	}
	//Accounting for primitive arrays of type Integer
	public static HashMap<String, Double> calculate(Integer[] inputData, boolean mean,
			boolean median, boolean max, boolean min, boolean stdDev,
			boolean intQuartRange, boolean skewness){

		Collection<?> data = Arrays.asList(inputData);
		return calculate(data, mean, median, max, min, stdDev, intQuartRange, skewness);

	}
	//Accounting for primitive arrays of type Float
	public static HashMap<String, Double> calculate(Float[]inputData, boolean mean,
			boolean median, boolean max, boolean min, boolean stdDev,
			boolean intQuartRange, boolean skewness){

		Collection<?> data = Arrays.asList(inputData);
		return calculate(data, mean, median, max, min, stdDev, intQuartRange, skewness);

	}
	//Accounting for primitive arrays of type Long
	public static HashMap<String, Double> calculate(Long[]inputData, boolean mean,
			boolean median, boolean max, boolean min, boolean stdDev,
			boolean intQuartRange, boolean skewness){

		Collection<?> data = Arrays.asList(inputData);
		return calculate(data, mean, median, max, min, stdDev, intQuartRange, skewness);

	}
	//Accounting for primitive arrays of type Short
	public static HashMap<String, Double> calculate(Short[]inputData, boolean mean,
			boolean median, boolean max, boolean min, boolean stdDev,
			boolean intQuartRange, boolean skewness){

		Collection<?> data = Arrays.asList(inputData);
		return calculate(data, mean, median, max, min, stdDev, intQuartRange, skewness);

	}
	
	
	//Accounting for primitive arrays of type double
	public static HashMap<String, Double> calculate(double[] inputData, boolean mean,
			boolean median, boolean max, boolean min, boolean stdDev,
			boolean intQuartRange, boolean skewness){
		List<?> data = new ArrayList<>(Arrays.stream(inputData).boxed().collect(Collectors.toList()));
		return calculate(data, mean, median, max, min, stdDev, intQuartRange, skewness);

	}
	//Accounting for primitive arrays of type int
	public static HashMap<String, Double> calculate(int[] inputData, boolean mean,
			boolean median, boolean max, boolean min, boolean stdDev,
			boolean intQuartRange, boolean skewness){

		double[] castData = new double[inputData.length];
		for (int i = 0; i < inputData.length; i++){
			castData[i] = Double.valueOf(inputData[i]);
		}
		List<?> data = new ArrayList<>(Arrays.stream(castData).boxed().collect(Collectors.toList()));
		return calculate(data, mean, median, max, min, stdDev, intQuartRange, skewness);

	}
	//Accounting for primitive arrays of type float
	public static HashMap<String, Double> calculate(float[]inputData, boolean mean,
			boolean median, boolean max, boolean min, boolean stdDev,
			boolean intQuartRange, boolean skewness){

		double[] castData = new double[inputData.length];
		for (int i = 0; i < inputData.length; i++){
			castData[i] = Double.valueOf(inputData[i]);
		}
		List<?> data = new ArrayList<>(Arrays.stream(castData).boxed().collect(Collectors.toList()));
		return calculate(data, mean, median, max, min, stdDev, intQuartRange, skewness);

	}
	//Accounting for primitive arrays of type long
	public static HashMap<String, Double> calculate(long[]inputData, boolean mean,
			boolean median, boolean max, boolean min, boolean stdDev,
			boolean intQuartRange, boolean skewness){

		double[] castData = new double[inputData.length];
		for (int i = 0; i < inputData.length; i++){
			castData[i] = Double.valueOf(inputData[i]);
		}
		List<?> data = new ArrayList<>(Arrays.stream(castData).boxed().collect(Collectors.toList()));
		return calculate(data, mean, median, max, min, stdDev, intQuartRange, skewness);

	}
	//Accounting for primitive arrays of type short
	public static HashMap<String, Double> calculate(short[]inputData, boolean mean,
			boolean median, boolean max, boolean min, boolean stdDev,
			boolean intQuartRange, boolean skewness){

		double[] castData = new double[inputData.length];
		for (int i = 0; i < inputData.length; i++){
			castData[i] = Double.valueOf(inputData[i]);
		}
		List<?> data = new ArrayList<>(Arrays.stream(castData).boxed().collect(Collectors.toList()));
		return calculate(data, mean, median, max, min, stdDev, intQuartRange, skewness);

	}
	

	public static HashMap<String, Double> calculate(TreeSet<?> inputData, boolean mean,
			boolean median, boolean max, boolean min, boolean stdDev,
			boolean intQuartRange, boolean skewness){
		Collection<?> data = Arrays.asList(inputData.toArray());
		System.out.println(data);
		return calculate(data, mean, median, max, min, stdDev, intQuartRange, skewness);

	}
}
