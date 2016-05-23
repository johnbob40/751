package parallel;

public class Median {

	public static Double compute(){

		int size = Values.sortedArray.length;
		double median = 0.0;
		if (size % 2 == 0) {
			double medianLeft =  Values.sortedArray[size / 2 - 1];
			double medianRight = (double) Values.sortedArray[size / 2];
			double diff = Math.abs(medianLeft - medianRight);
			median =  Math.min(medianLeft, medianRight) + (diff / 2);
		} else {
			median = (double) Values.sortedArray[size - 1 / 2];
		}


		Values.median = median;
		return median;
	}
}
