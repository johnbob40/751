package main;

public class CalculateMean {

	public static void mean(){
		long startTime = System.nanoTime();
		//#omp parallel for
		for (int i = 0; i <2000000000; i++){
			int sum = i + 1;
		}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime)/1000000;
		System.out.println(duration);
		startTime = System.nanoTime();
		for (int i = 0; i <2000000000; i++){
			int sum = i + 1;
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println(duration);
	}
}
