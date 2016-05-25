package main;

import util.Data;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

import parallel.*;

import sequential.SequentialStatistics; 


public class TestParallelStatistics {
	private Collection<Double> data;

	public TestParallelStatistics() {
		data = Data.generateConstant(1000, 5);
	}


	@Test
	public synchronized void testMean() {
		data.clear();
		data = Data.generateConstant(1000, 10);
		try {
			assertEquals(new Double(10.0), Mean.compute(data));

			//Can't really test that it works with a random set, as nothing to compare it to. so using another premade set
			data.clear();
			data.add(5.0);
			data.add(15.0);
			data.add(25.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(5.0);
			data.add(15.0);
			data.add(25.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(5.0);
			data.add(15.0);
			data.add(25.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(5.0);
			data.add(15.0);
			data.add(25.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(5.0);
			data.add(15.0);
			data.add(25.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(5.0);
			data.add(15.0);
			data.add(25.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(5.0);
			data.add(15.0);
			data.add(25.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(5.0);
			data.add(15.0);
			data.add(25.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(5.0);
			data.add(15.0);
			data.add(25.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(5.0);
			data.add(15.0);
			data.add(25.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(5.0);
			data.add(15.0);
			data.add(25.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(5.0);
			data.add(15.0);
			data.add(25.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(5.0);
			data.add(15.0);
			data.add(25.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(5.0);
			data.add(15.0);
			data.add(25.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(5.0);
			data.add(15.0);
			data.add(25.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);


			assertEquals(new Double(30.0), Mean.compute(data));
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public synchronized void testCalculateMaxUnsorted() {
		try {
			assertEquals(new Double(5), Max.compute(data));

			Values.clear();
			data.clear();
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);


			assertEquals(new Double(75), Max.compute(data));
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public synchronized void testMinUnsorted() {
		try {
			assertEquals(new Double(5.0), Min.compute(data));

			Values.clear();
			data.clear();
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);
			data.add(65.0);
			data.add(15.0);
			data.add(75.0);
			data.add(35.0);
			data.add(45.0);
			data.add(55.0);


			assertEquals(new Double(15.0), Min.compute(data));
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public synchronized void testStdDevWithoutMean(){
		try {
			data.clear();
			Values.clear();
			data = Data.generateConstant(1000, 0.0);
			assertEquals(new Double(0.0), StdDev.compute(data));
			Values.clear();
			data.clear();
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);
			data.add(5.0);
			data.add(10.0);
			data.add(15.0);
			data.add(20.0);		
			assertEquals(new Double(5.59), StdDev.compute(data), 0.1);
			Values.clear();
			data.clear();
			data.add(9.0);
			data.add(2.0);
			data.add(5.0);
			data.add(4.0);
			data.add(12.0);
			data.add(7.0);
			data.add(8.0);
			data.add(11.0);
			data.add(9.0);
			data.add(3.0);
			data.add(7.0);
			data.add(4.0);
			data.add(12.0);
			data.add(5.0);
			data.add(4.0);
			data.add(10.0);
			data.add(9.0);
			data.add(6.0);
			data.add(9.0);
			data.add(4.0);
			data.add(9.0);
			data.add(2.0);
			data.add(5.0);
			data.add(4.0);
			data.add(12.0);
			data.add(7.0);
			data.add(8.0);
			data.add(11.0);
			data.add(9.0);
			data.add(3.0);
			data.add(7.0);
			data.add(4.0);
			data.add(12.0);
			data.add(5.0);
			data.add(4.0);
			data.add(10.0);
			data.add(9.0);
			data.add(6.0);
			data.add(9.0);
			data.add(4.0);
			data.add(9.0);
			data.add(2.0);
			data.add(5.0);
			data.add(4.0);
			data.add(12.0);
			data.add(7.0);
			data.add(8.0);
			data.add(11.0);
			data.add(9.0);
			data.add(3.0);
			data.add(7.0);
			data.add(4.0);
			data.add(12.0);
			data.add(5.0);
			data.add(4.0);
			data.add(10.0);
			data.add(9.0);
			data.add(6.0);
			data.add(9.0);
			data.add(4.0);
			data.add(9.0);
			data.add(2.0);
			data.add(5.0);
			data.add(4.0);
			data.add(12.0);
			data.add(7.0);
			data.add(8.0);
			data.add(11.0);
			data.add(9.0);
			data.add(3.0);
			data.add(7.0);
			data.add(4.0);
			data.add(12.0);
			data.add(5.0);
			data.add(4.0);
			data.add(10.0);
			data.add(9.0);
			data.add(6.0);
			data.add(9.0);
			data.add(4.0);
			data.add(9.0);
			data.add(2.0);
			data.add(5.0);
			data.add(4.0);
			data.add(12.0);
			data.add(7.0);
			data.add(8.0);
			data.add(11.0);
			data.add(9.0);
			data.add(3.0);
			data.add(7.0);
			data.add(4.0);
			data.add(12.0);
			data.add(5.0);
			data.add(4.0);
			data.add(10.0);
			data.add(9.0);
			data.add(6.0);
			data.add(9.0);
			data.add(4.0);
			data.add(9.0);
			data.add(2.0);
			data.add(5.0);
			data.add(4.0);
			data.add(12.0);
			data.add(7.0);
			data.add(8.0);
			data.add(11.0);
			data.add(9.0);
			data.add(3.0);
			data.add(7.0);
			data.add(4.0);
			data.add(12.0);
			data.add(5.0);
			data.add(4.0);
			data.add(10.0);
			data.add(9.0);
			data.add(6.0);
			data.add(9.0);
			data.add(4.0);
			data.add(9.0);
			data.add(2.0);
			data.add(5.0);
			data.add(4.0);
			data.add(12.0);
			data.add(7.0);
			data.add(8.0);
			data.add(11.0);
			data.add(9.0);
			data.add(3.0);
			data.add(7.0);
			data.add(4.0);
			data.add(12.0);
			data.add(5.0);
			data.add(4.0);
			data.add(10.0);
			data.add(9.0);
			data.add(6.0);
			data.add(9.0);
			data.add(4.0);
			data.add(9.0);
			data.add(2.0);
			data.add(5.0);
			data.add(4.0);
			data.add(12.0);
			data.add(7.0);
			data.add(8.0);
			data.add(11.0);
			data.add(9.0);
			data.add(3.0);
			data.add(7.0);
			data.add(4.0);
			data.add(12.0);
			data.add(5.0);
			data.add(4.0);
			data.add(10.0);
			data.add(9.0);
			data.add(6.0);
			data.add(9.0);
			data.add(4.0);

			assertEquals(new Double(2.983), StdDev.compute(data), 0.1);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	@Test
	public void testSkewWithoutMean(){
		assertTrue(Double.isNaN(SequentialStatistics.calculateSkewWithoutMeanWithoutStdDev(data)));
		data.clear();
		Values.clear();
		data.add(5.0);
		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		
		assertEquals(new Double(0),Skewness.compute(data), 0.1);

		data.clear();
		Values.clear();
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);

		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);

		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);

		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);

		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);

		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);

		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);

		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);

		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);

		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);

		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		assertEquals(new Double(0.72),Skewness.compute(data), 0.1);

	}

	@Test
	public void testSortOnUnsorted() {
		Double[] dataCollection = Sorting.parallelSort(Data.generateRandomList(100000));
		Double prevDataPoint = Double.MIN_VALUE;
		Double nextDataPoint;
		for (int i = 0; i < dataCollection.length; i++) {
			nextDataPoint = dataCollection[i];
			assertTrue(nextDataPoint >= prevDataPoint);
			prevDataPoint = nextDataPoint;
		}
	}

	@Test
	public void testSortOnSorted() {
		Double[] dataCollection = Sorting.parallelSort(Data.generateConstant(100000, 50));
		Double prevDataPoint = Double.MIN_VALUE;
		Double nextDataPoint;
		for (int i = 0; i < dataCollection.length; i++) {
			nextDataPoint = dataCollection[i];
			assertTrue(nextDataPoint >= prevDataPoint);
			prevDataPoint = nextDataPoint;
		}
	}

	@Test
	public void testMedian() {
		List<Double> data = Data.generateConsecutiveList(10, 50, 5);
		double med = Sorting.median(data);
		assertEquals(54.5, med, 0.0001);

		Values.clear();
		data.clear();
		data = Data.generateConsecutiveList(11, 50, 5);
		med = Sorting.median(data);		
		assertEquals(55.0, med, 0.0001);
	}

	@Test
	public void testQuartileRange() {
		List<Double> data = Data.generateConsecutiveList(10, 50, 5);
		assertEquals(5.0, Sorting.iQR(data), 0.0001);
		Values.clear();
		data = Data.generateConsecutiveList(11, 50, 5);
		assertEquals(6.0, Sorting.iQR(data), 0.0001);
		Values.clear();
		data = Data.generateConsecutiveList(12, 50, 5);
		assertEquals(6.0, Sorting.iQR(data), 0.0001);
		Values.clear();
		data = Data.generateConsecutiveList(13, 50, 5);
		assertEquals(7.0, Sorting.iQR(data), 0.0001);
	}
}
