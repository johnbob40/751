package main;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashMap;

import org.junit.Test;
import main.SequentialStatistics;

public class TestSequentialCalculate {
	private HashMap<String, Double> results;
	private Collection<Double> data;


	public TestSequentialCalculate(){
		results = new HashMap<String, Double>();
		data = Data.generateConstant(10, 5);
	}

	@Test
	public void testNullInputs() {
		HashMap<String, Double> result = SequentialStatistics.calculate(null, false, false, false, false, false, false, false);
		assertEquals(result.size(), 0);
		
		data.clear();
		result = SequentialStatistics.calculate(data, false, false, false, false, false, false, false);
		assertEquals(result.size(), 0);
	}
	
	@Test
	public void testCalculatingAll() {
		results = SequentialStatistics.calculate(data, true, true, true, true, true, true, true);
		assertEquals(results.get("mean"), 5.0, 0.0);
		assertEquals(results.get("median"), 5.0, 0.0);
		assertEquals(results.get("max"), 5.0, 0.0);
		assertEquals(results.get("min"), 5.0, 0.0);
		assertTrue(Double.isNaN(results.get("skewness")));
		assertEquals(results.get("stdDev"), 0.0, 0.0);
	}

	@Test
	public void testCalculatingAllButMean() {
		data = Data.generate(100);
		results = SequentialStatistics.calculate(data, false, true, true, true, true, true, true);
		assertNull(results.get("mean"));
		assertEquals(results.get("max"), 99.0, 0.0);
		assertEquals(results.get("median"), 49.5, 0.0);
		assertEquals(results.get("min"), 0.0, 0.0);
		assertEquals(results.get("skewness"), 0.0, 0.0);
		assertEquals(results.get("stdDev"), 28.86, 0.1);
	}
	
}
