package main;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashMap;

import org.junit.Test;

import sequential.SequentialStatistics;
import util.Data;

public class TestSequentialCalculate {
	private HashMap<String, Double> results;
	private Collection<Double> data;


	public TestSequentialCalculate(){
		results = new HashMap<String, Double>();
		data = Data.generateConstant(10, 5);
	}

	@Test
	public void testNullInputs() {
		results = SequentialStatistics.calculate(null, false, false, false, false, false, false, false);
		assertEquals(results.size(), 0);
	}
	
	@Test
	public void testCalculateWithNoData(){
		data.clear();
		results = SequentialStatistics.calculate(data, false, false, false, false, false, false, false);
		assertEquals(results.size(), 0);
	}
	@Test
	public void testCalculateNothing(){
		results = SequentialStatistics.calculate(data, false, false, false, false, false, false, false);
		assertEquals(results.size(), 0);
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
	
	@Test
	public void testDataIntegrity(){
		data = Data.generateReverse(5);
		Collection<Double> data1 = Data.generateReverse(5);
		System.out.println(data1);
		SequentialStatistics.calculate(data, true, true, false, false, false, false, false);
		System.out.println(data);
		assertEquals(data, data1);
	}
	
}
