package parallel;

import java.util.Arrays;
import java.util.Collection;

public class Median {

	public static Double compute(Collection<?> data){
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

		Values.median = median;
		return median;
	}
}
