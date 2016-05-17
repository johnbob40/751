package main;

import main.SequentialStatistics;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test; 


public class TestSequentialStatistics {
	private Collection<Double> data;
	
	public TestSequentialStatistics() {
		data = Data.generateConstant(10, 5);
	}


	@Test
	public void testNullInputs() {
		assertNull(SequentialStatistics.calculate(null, false, false, false, false, false, false, false, false));
	}

	@Test
	public void testMean() {
		if (SequentialStatistics.calculateMean(data) != 5.0f){
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
	public void testMaxSorted() {
		//TODO
		assertEquals(1, 1);
	}
	
	@Test
	public void testMinUnsorted() {
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
		assertEquals(new Double(5), SequentialStatistics.calculateMinSorted(data));
		
		data = Data.generate(100);
		assertEquals(new Double(0), SequentialStatistics.calculateMinSorted(data));
	}


	@Test
	public void testStdDevWithoutMean(){
		
		assertEquals(new Double(0.0), SequentialStatistics.calculateStdDevWithoutMean(data));
		
		data.clear();
		data.add(5.0);
		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		
		assertEquals(new Double(5.59), SequentialStatistics.calculateStdDevWithoutMean(data), 0.1);

		data.add(25.0);
		data.add(60.0);
		
		assertEquals(new Double(17.96), SequentialStatistics.calculateStdDevWithoutMean(data), 0.1);

		 
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
		assertEquals(new Double(2.983), SequentialStatistics.calculateStdDevWithoutMean(data), 0.1);

	}

	@Test
	public void testStdDevWithMean(){
		assertEquals(new Double(0.0), SequentialStatistics.calculateStdDevWithMean(data, 5.0));
		
		data.clear();
		data.add(5.0);
		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		
		assertEquals(new Double(5.59), SequentialStatistics.calculateStdDevWithMean(data, 12.5), 0.1);
		
		data.add(25.0);
		data.add(60.0);
		
		assertEquals(new Double(17.96), SequentialStatistics.calculateStdDevWithMean(data, 22.5), 0.1);
		
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
		assertEquals(new Double(2.983), SequentialStatistics.calculateStdDevWithMean(data, 7.0), 0.1);

	
	}
	@Test
	public void testSkewWithoutMean(){
		assertTrue(Double.isNaN(SequentialStatistics.calculateSkewWithoutMean(data)));
		data.clear();
		data.add(5.0);
		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		assertEquals(new Double(0),SequentialStatistics.calculateSkewWithoutMean(data), 0.1);

		data.add(-50.0);
		
		assertEquals(new Double(-1.395),SequentialStatistics.calculateSkewWithoutMean(data), 0.1);

		data.clear();
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);
		data.add(5.0);
		
		data.add(10.0);
		data.add(15.0);
		data.add(20.0);
		data.add(25.0);
		assertEquals(new Double(0.6776),SequentialStatistics.calculateSkewWithoutMean(data), 0.1);
		
	}
}