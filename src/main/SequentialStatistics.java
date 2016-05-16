package main;

import java.util.Collection;
import java.util.Iterator;

public class SequentialStatistics {

	public static String[] calculate(Collection<Integer> data, boolean mean,
							boolean median, boolean max, boolean min, boolean stdDev,
							boolean intQuartRange, boolean skewness, boolean corrCoef){
		return null;
	}
	
	public static float calculateMean(Collection<Integer> data){
		//BigInteger sum = new BigInteger("0");
		Long sum = new Long(0);
		for (Integer i : data){
			sum += i;
		}
		return sum/data.size();
	}
	
	public static Integer calculateMaxUnsorted(Collection<Integer> data){
		Iterator<Integer> it = data.iterator();
		
		//Getting the first element to use as the reference max
		Integer max = it.next();

		while (it.hasNext()){	
			Integer temp = it.next();
			if (temp > max){
				max = temp;
			}
		}	
		return max;
	}
	
	public static Integer calculateMinUnsorted(Collection<Integer> data){
		Iterator<Integer> it = data.iterator();
		
		//Getting the first element to use as the reference min
		Integer min = it.next();
		
		while (it.hasNext()){	
			Integer temp = it.next();
			if (temp < min){
				min = temp;
			}
		}	
		return min;
	}
}
