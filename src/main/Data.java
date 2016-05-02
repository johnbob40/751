package main;

import java.util.ArrayList;
import java.util.Collection;

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
}
