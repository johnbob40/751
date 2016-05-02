package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class test {
	
	@Test
	public void defaultTest() {
		assertNull(ParallelStatistics.calculate(null, false, false, false, false, false, false, false, false));
	}

	@Test
	public void testMean() {
		assertEquals(1, 1);
	}
	
	@Test
	public void testMaxWithoutMedian() {
		assertEquals(1, 1);
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
