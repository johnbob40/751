package main;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashMap;

import org.junit.Test;

public class TestParallelCalculate {
	private HashMap<String, Double> results;
	private Collection<Double> data;


	public TestParallelCalculate(){
		results = new HashMap<String, Double>();
		data = Data.generateConstant(10, 5);
	}

	@Test
	public void testNullInputs() {
		results = ParallelStatistics.calculate(null, false, false, false, false, false, false, false);
		assertEquals(results.size(), 0);
	}
	
	@Test
	public void testCalculateWithNoData(){
		data.clear();
		results = ParallelStatistics.calculate(data, false, false, false, false, false, false, false);
		assertEquals(results.size(), 0);
	}
	@Test
	public void testCalculateNothing(){
		results = ParallelStatistics.calculate(data, false, false, false, false, false, false, false);
		assertEquals(results.size(), 0);
	}
}