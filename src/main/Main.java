package main;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

import parallel.*;
import util.Data;

//@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		Collection<?> data; 
		System.out.println("Creating List");
		int size = 5000000;
//		data= Data.generateReverse(size);
		data= Data.generateRandomList(size);
		System.out.println("List created");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		Sorting.iQR(data);
	
	}
}
