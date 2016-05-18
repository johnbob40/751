package main;

import java.util.Collection;
import java.util.HashMap;

public class ParallelStatistics {

	public static HashMap<String, Double> calculate(Collection<?> inputData, boolean mean,
			boolean median, boolean max, boolean min, boolean stdDev,
			boolean intQuartRange, boolean skewness){
		
		HashMap<String, Double> results = new HashMap<String, Double>();

		if (inputData == null || inputData.size() == 0){
			return results;
		}


		return null;
	}
}
