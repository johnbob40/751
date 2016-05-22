package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Data {
	
	public enum DataType{INT, FLOAT, DOUBLE, LONG}
	public enum CollectionType{ARRAY_LIST, LINKED_LIST, HASH_MAP, TREE_MAP}
	
	private static Random stringGen = new Random();

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
	
	public static Collection<Double> generateRandomList(int length) {
		Collection<Double> data = new ArrayList<Double>(length);
		Random r = new Random();
		for (int i = 0; i < length; i++) {
			data.add(r.nextDouble() * 1000);
		}
		return data;
	}
	
	public static Object generateRandomData(long length, DataType dataType, CollectionType colType) {
		Object data;
		if (colType == CollectionType.ARRAY_LIST) {
			if (dataType == DataType.DOUBLE) {
				data = new ArrayList<Double>();
			} else if (dataType == DataType.INT) {
				data = new ArrayList<Integer>();
			} else if (dataType == DataType.FLOAT) {
				data = new ArrayList<Float>();
			} else if (dataType == DataType.LONG) {
				data = new ArrayList<Long>();
			} else {
				data = null;
			}
		} else if (colType == CollectionType.LINKED_LIST) {
			if (dataType == DataType.DOUBLE) {
				data = new LinkedList<Double>();
			} else if (dataType == DataType.INT) {
				data = new LinkedList<Integer>();
			} else if (dataType == DataType.FLOAT) {
				data = new LinkedList<Float>();
			} else if (dataType == DataType.LONG) {
				data = new LinkedList<Long>();
			} else {
				data = null;
			}
		} else if (colType == CollectionType.HASH_MAP) {
			if (dataType == DataType.DOUBLE) {
				data = new HashMap<String, Double>();
			} else if (dataType == DataType.INT) {
				data = new HashMap<String, Integer>();
			} else if (dataType == DataType.FLOAT) {
				data = new HashMap<String, Float>();
			} else if (dataType == DataType.LONG) {
				data = new HashMap<String, Long>();
			} else {
				data = null;
			}
		} else if (colType == CollectionType.TREE_MAP) {
			if (dataType == DataType.DOUBLE) {
				data = new TreeMap<String, Double>();
			} else if (dataType == DataType.INT) {
				data = new TreeMap<String, Integer>();
			} else if (dataType == DataType.FLOAT) {
				data = new TreeMap<String, Float>();
			} else if (dataType == DataType.LONG) {
				data = new TreeMap<String, Long>();
			} else {
				data = null;
			}
		} else {
			data = null;
		}
		
		Random r = new Random();
		if (data instanceof List) {
			for (int i = 0; i < length; i++) {
				if (dataType == DataType.DOUBLE) {
					((List)data).add(r.nextDouble() * 100);
				} else if (dataType == DataType.INT) {
					((List)data).add(r.nextInt());
				} else if (dataType == DataType.FLOAT) {
					((List)data).add(r.nextFloat() * 100);
				} else if (dataType == DataType.LONG) {
					((List)data).add(r.nextLong());
				} 
			}
		} else if (data instanceof Map) {
			for (int i = 0; i < length; i++) {
				if (dataType == DataType.DOUBLE) {
					((Map)data).put(generateRandomString(), r.nextDouble() * 100);
				} else if (dataType == DataType.INT) {
					((Map)data).put(generateRandomString(), r.nextInt());
				} else if (dataType == DataType.FLOAT) {
					((Map)data).put(generateRandomString(), r.nextFloat() * 100);
				} else if (dataType == DataType.LONG) {
					((Map)data).put(generateRandomString(), r.nextLong());
				} 
			}
		}
		return data;		
	}
	
	private static String generateRandomString() {
		String keyset = "abcdefghijklmnopqrstuvwxyz";
		String randomString = "";
		for (int i = 0; i < 10; i++) {
			randomString = randomString + keyset.charAt(stringGen.nextInt(26));
		}
		return randomString;
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
