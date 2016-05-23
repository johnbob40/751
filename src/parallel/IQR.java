package parallel;

public class IQR {
	private static long startTime;
	private static long endTime;
	private static long duration;

	public static Double compute(){
		
		startTime = System.currentTimeMillis();
		
		int size = Values.sortedArray.length;
		double leftQuartile;
		double rightQuartile;
		if (size < 4) {
			return null;
		} 
		if (size % 2 == 0) {
			int halfSize = size / 2;
			if (halfSize % 2 == 0) {
				double leftQuartileLeft = (double) Values.sortedArray[(halfSize / 2) - 1];
				double leftQuartileRight = (double) Values.sortedArray[halfSize / 2];
				double diff = Math.abs(leftQuartileLeft - leftQuartileRight);
				leftQuartile = Math.min(leftQuartileLeft, leftQuartileRight) + (diff / 2);
				double rightQuartileLeft = (double) Values.sortedArray[halfSize + (halfSize / 2) - 1];
				double rightQuartileRight = (double) Values.sortedArray[halfSize + (halfSize / 2)];
				diff = Math.abs(rightQuartileLeft - rightQuartileRight);
				rightQuartile = Math.min(rightQuartileLeft, rightQuartileRight) + (diff / 2);
			} else {
				leftQuartile = (double)Values.sortedArray[(halfSize - 1) / 2];
				rightQuartile = (double)Values.sortedArray[halfSize + (halfSize - 1) / 2];
			}
		} else {
			int halfSize = (size - 1) / 2;
			if (halfSize % 2 == 0) {
				double leftQuartileLeft = (double) Values.sortedArray[(halfSize / 2) - 1];
				double leftQuartileRight = (double) Values.sortedArray[halfSize / 2];
				double diff = Math.abs(leftQuartileLeft - leftQuartileRight);
				leftQuartile = Math.min(leftQuartileLeft, leftQuartileRight) + (diff / 2);
				double rightQuartileLeft = (double) Values.sortedArray[halfSize + (halfSize / 2)];
				double rightQuartileRight = (double) Values.sortedArray[halfSize + (halfSize / 2) + 1];
				diff = Math.abs(rightQuartileLeft - rightQuartileRight);
				rightQuartile = Math.min(rightQuartileLeft, rightQuartileRight) + (diff / 2);
			} else {
				leftQuartile = (double)Values.sortedArray[(halfSize - 1) / 2];
				rightQuartile = (double)Values.sortedArray[halfSize + ((halfSize - 1) / 2) + 1];
			}
		}
		Double IQR = rightQuartile - leftQuartile;
		endTime = System.currentTimeMillis();
		duration = endTime - startTime;
		System.out.println("parallel duration = " + duration);
		System.out.println("parallel median = "+ IQR);
		Values.IQR = IQR;
		return IQR;
		//startTime = System.currentTimeMillis();

		//System.out.println(SequentialStatistics.calculateMedian(SequentialStatistics.sequentialSort(data)));
		//endTime = System.currentTimeMillis();
		//duration = endTime - startTime;
		//System.out.println("sequential duration = " + duration);
		//return median;
	}
}
