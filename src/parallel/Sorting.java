package parallel;

import java.util.Arrays;
import java.util.Collection;

public class Sorting {
	
	public static Double[] parallelSort(Collection<?> data){
		Double[] array = (Double[]) data.toArray(new Double[data.size()]);
		Arrays.parallelSort(array);
		Values.sortedArray = array;
		return array;
	}
	
	public static void median(Collection<?> data){
		if(Values.sortedArray == null){
			parallelSort(data);
			
		}
		Median.compute();
	}

	public static Double iQR(Collection<?> data){
		if(Values.sortedArray == null){
			parallelSort(data);
			
		}
		return IQR.compute();
	}
}
