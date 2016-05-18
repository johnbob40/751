package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Data {

	public static Collection<Double> generate(int length){
		Collection<Double> data = new ArrayList<Double>();
		for (int i = 0; i < length; i++){
			data.add((double) i);
		}
		return data;
	}
	public static Collection<Double> generateReverse(int length) {
		Collection<Double> data = new ArrayList<Double>();
		for (int i = 0; i < length; i++){
			data.add((double) length - i);
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
	
	public static List<Double> generateRandomList(int length) {
		List<Double> data = new ArrayList<Double>(length);
		Random r = new Random();
		for (int i = 0; i < length; i++) {
			data.add(r.nextDouble() * 1000);
		}
		return data;
	}
	
	public static List<Double> generateConsecutiveList(int length, double start, int shift) {
		Double[] data = new Double[length];
		for (int i = 0; i < length; i++) {
			int index = (shift + i) % length;
			double value = start + i;
			data[index] = value;
		}
		List<Double> dataList = new ArrayList<Double>();
		for (int i = 0; i < data.length; i++) {
			dataList.add(data[i]);
		}
		return dataList;
	}
}
