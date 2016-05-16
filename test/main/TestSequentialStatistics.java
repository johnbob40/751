package main;

import main.SequentialStatistics;
import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Test; 


public class TestSequentialStatistics {
	private Collection<Double> data;
	
	
	@Test
	public void testNullInputs() {
		assertNull(SequentialStatistics.calculate(null, false, false, false, false, false, false, false, false));
	}

	@Test
	public void testMean() {
		data = Data.generateConstant(100, 10);
		if (SequentialStatistics.calculateMean(data) != 10.0f){
			fail();
		}
		//Can't really test that it works with a random set, as nothing to compare it to. so using another premade set
		data.clear();
		data.add(5.0);
		data.add(15.0);
		data.add(25.0);
		data.add(35.0);
		data.add(45.0);
		data.add(55.0);
		
		if (SequentialStatistics.calculateMean(data) != 30.0f){
			fail();
		} 
	}
	
	@Test
	public void testCalculateMaxUnsorted() {
		data = Data.generateConstant(10, 5);
		assertEquals(new Double(5), SequentialStatistics.calculateMaxUnsorted(data));
		
		data.clear();
		data.add(65.0);
		data.add(15.0);
		data.add(75.0);
		data.add(35.0);
		data.add(45.0);
		data.add(55.0);
		
		assertEquals(new Double(75), SequentialStatistics.calculateMaxUnsorted(data));
	}
	
	@Test
	public void testMaxWithMedian() {
		assertEquals(1, 1);
	}
	
	@Test
	public void testMinUnsorted() {
		data = Data.generateConstant(10, 5.0);
		assertEquals(new Double(5.0), SequentialStatistics.calculateMinUnsorted(data));
		
		data.clear();
		data.add(65.0);
		data.add(15.0);
		data.add(75.0);
		data.add(35.0);
		data.add(45.0);
		data.add(55.0);
		
		assertEquals(new Double(15.0), SequentialStatistics.calculateMinUnsorted(data));
	}

	@Test
	public void testMinSorted() {
		data = Data.generateConstant(10, 5);
		assertEquals(new Double(5), SequentialStatistics.calculateMinSorted(data));
		
		data = Data.generate(100);
		assertEquals(new Double(0), SequentialStatistics.calculateMinSorted(data));
	}

	@Test
	public void testStdDevWithoutMean(){
		data = Data.generateConstant(10, 5);
		assertEquals(new Double(0.0), SequentialStatistics.calculateStdDevWithoutMean(data));
		
		data.clear();
		data.add(5.0);
		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		
		assertEquals(new Double(50), SequentialStatistics.calculateStdDevWithoutMean(data));
	}
	
	@Test
	public void testStdDevWithMean(){
		data = Data.generateConstant(10, 5);
		assertEquals(new Double(0.0), SequentialStatistics.calculateStdDevWithMean(data, 5.0));
		
		data.clear();
		data.add(5.0);
		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		
		assertEquals(new Double(50), SequentialStatistics.calculateStdDevWithMean(data, 15.0));
	}
	
	@Test
	public void testSortOnUnsorted() {
		Collection<Double> dataCollection = SequentialStatistics.sequentialSort(Data.generateRandomList(100000));
		Iterator<Double> it = dataCollection.iterator();
		Double prevDataPoint = Double.MIN_VALUE;
		Double nextDataPoint;
		while (it.hasNext()) {
			nextDataPoint = (Double)it.next();
			assertTrue(nextDataPoint >= prevDataPoint);
			prevDataPoint = nextDataPoint;
		}
	}
	
	@Test
	public void testSortOnSorted() {
		Collection<Double> dataCollection = SequentialStatistics.sequentialSort(Data.generateConstant(100000, 999));
		Iterator<Double> it = dataCollection.iterator();
		Double prevDataPoint = Double.MIN_VALUE;
		Double nextDataPoint;
		while (it.hasNext()) {
			nextDataPoint = (Double)it.next();
			assertTrue(nextDataPoint >= prevDataPoint);
			prevDataPoint = nextDataPoint;
		}
	}
}
