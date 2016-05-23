package parallel;

public class IQR {
	public static Double compute(){
		
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

		Values.IQR = IQR;
		return IQR;

	}
}
