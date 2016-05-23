package parallel;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Sorting {
	
	public static Double[] parallelSort(Collection<?> data){
		Double[] array = data.toArray(new Double[data.size()]);

		Arrays.parallelSort(array);
		Values.sortedArray = array;
		return array;
	}
	
	public static Double median(Collection<?> data){
		if(Values.sortedArray == null){
			parallelSort(data);
			
		}
		return Median.compute();
	}

	public static Double iQR(Collection<?> data){
		if(Values.sortedArray == null){
			parallelSort(data);
			
		}
		return IQR.compute();
	}
}
