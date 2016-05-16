package main;

import java.util.Collection;

public class ParallelStatistics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world");
	}

	public static String[] calculate(Collection<?> data, boolean mean,
			boolean median, boolean max, boolean min, boolean stdDev,
			boolean intQuartRange, boolean skewness, boolean corrCoef){
		
		if (data == null){
			return null;
		} else if (data.size() == 0){
			return null;
		}


		return null;
	}
}
