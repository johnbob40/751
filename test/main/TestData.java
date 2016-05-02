package main;

import static org.junit.Assert.*;

import java.util.Collection;

import main.Data;
import org.junit.Test;

public class TestData {

	@Test
	public void testLength() {
		int length = 100;
		Collection<Integer> data = Data.generate(length);
		assertEquals(length, data.size());
	}
}
