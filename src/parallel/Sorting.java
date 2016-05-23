package parallel;

import java.util.Arrays;
import java.util.Collection;

public class Sorting {
	
	public static void parallelSort(Collection<?> data){
		Double[] array = (Double[]) data.toArray(new Double[data.size()]);
		Arrays.parallelSort(array);
		Values.sortedArray = array;
	}
	
	public static void median(Collection<?> data){
		if(Values.sortedArray == null){
			parallelSort(data);
			
		}
		Median.compute();
	}

	public static void iQR(Collection<?> data){
		if(Values.sortedArray == null){
			parallelSort(data);
			
		}
		IQR.compute();
	}
}
