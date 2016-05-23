package parallel;

import java.util.Arrays;
import java.util.Collection;

import main.SequentialStatistics;

public class Median {

	private static long startTime;
	private static long endTime;
	private static long duration;

	public static Double compute(Collection<?> data){
		
		startTime = System.currentTimeMillis();
		Double[] array = (Double[]) data.toArray(new Double[data.size()]);
		Arrays.parallelSort(array);
		int size = data.size();
		double median = 0.0;
		if (size % 2 == 0) {
			double medianLeft =  array[size / 2 - 1];
			double medianRight = (double) array[size / 2];
			double diff = Math.abs(medianLeft - medianRight);
			median =  Math.min(medianLeft, medianRight) + (diff / 2);
		} else {
			median = (double) array[size - 1 / 2];
		}
		endTime = System.currentTimeMillis();
		duration = endTime - startTime;
		System.out.println("parallel duration = " + duration);
		System.out.println("parallel median = "+median);
		Values.median = median;
		
		startTime = System.currentTimeMillis();

		System.out.println(SequentialStatistics.calculateMedian(SequentialStatistics.sequentialSort(data)));
		endTime = System.currentTimeMillis();
		duration = endTime - startTime;
		System.out.println("sequential duration = " + duration);
		return median;
	}
}
