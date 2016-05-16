package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Data {

	public static Collection<Integer> generate(int length){
		Collection<Integer> data = new ArrayList<Integer>();
		for (int i = 0; i < length; i++){
			data.add(i);
		}
		return data;
	}
	public static Collection<Integer> generateConstant(int length, int number){
		Collection<Integer> data = new ArrayList<Integer>();
		for (int i = 0; i < length; i++){
			data.add(number);
		}
		return data;
	}
	
	public static Collection<Integer> sort(Collection<Integer> data){
		return null;
	}
	
	public static List<Double> generateRandomList(int length) {
		List<Double> data = new ArrayList<Double>(length);
		Random r = new Random();
		for (int i = 0; i < length; i++) {
			data.add(r.nextDouble() * 1000);
		}
		return data;
	}
}
