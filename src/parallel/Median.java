package parallel;

public class Median {

	private static long startTime;
	private static long endTime;
	private static long duration;

	public static Double compute(){
		
		startTime = System.currentTimeMillis();
		
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
		endTime = System.currentTimeMillis();
		duration = endTime - startTime;
		System.out.println("parallel duration = " + duration);
		System.out.println("parallel median = "+median);
		Values.median = median;
		
		//startTime = System.currentTimeMillis();

		//System.out.println(SequentialStatistics.calculateMedian(SequentialStatistics.sequentialSort(data)));
		//endTime = System.currentTimeMillis();
		//duration = endTime - startTime;
		//System.out.println("sequential duration = " + duration);
		return median;
	}
}
