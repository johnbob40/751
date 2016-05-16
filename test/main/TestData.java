package main;

import static org.junit.Assert.*;

import java.util.Collection;

import main.Data;
import org.junit.Test;

public class TestData {

	@Test
	public void testLength() {
		int length = 100;
		Collection<Double> data = Data.generate(length);
		assertEquals(length, data.size());
	}
	
	@Test
	public void testConstGeneration() {
		int length = 100;
		float value = 10.0f;
		Collection<Double> data = Data.generateConstant(length, value);
		for (Double i : data){			
			if (i != value){
				fail();
			}
		}
	}
}
