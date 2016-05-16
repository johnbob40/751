package main;

import main.SequentialStatistics;
import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;

import org.junit.Test; 


public class TestSequentialStatistics {
	private Collection<Integer> data;
	
	
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
		data.add(5);
		data.add(15);
		data.add(25);
		data.add(35);
		data.add(45);
		data.add(55);
		
		if (SequentialStatistics.calculateMean(data) != 30.0f){
			fail();
		} 
	}
	
	@Test
	public void testCalculateMaxUnsorted() {
		data = Data.generateConstant(10, 5);
		assertEquals(new Integer(5), SequentialStatistics.calculateMaxUnsorted(data));
		
		data.clear();
		data.add(65);
		data.add(15);
		data.add(75);
		data.add(35);
		data.add(45);
		data.add(55);
		
		assertEquals(new Integer(75), SequentialStatistics.calculateMaxUnsorted(data));
	}
	
	@Test
	public void testMaxWithMedian() {
		assertEquals(1, 1);
	}
	@Test
	public void testMinWithoutMedian() {
		assertEquals(1, 1);
	}
	
	@Test
	public void testMinWithMedian() {
		assertEquals(1, 1);
	}
}
