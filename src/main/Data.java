package main;

import java.util.ArrayList;
import java.util.Collection;

public class Data {

	public static Collection<Double> generate(int length){
		Collection<Double> data = new ArrayList<Double>();
		for (int i = 0; i < length; i++){
			data.add((double) i);
		}
		return data;
	}
	public static Collection<Double> generateConstant(int length, double number){
		Collection<Double> data = new ArrayList<Double>();
		for (int i = 0; i < length; i++){
			data.add((double)number);
		}
		return data;
	}
	
	public static Collection<Double> sort(Collection<Double> data){
		return null;
	}
}
