package Tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import Files.CompareInt;
import Files.Sort;

class SortTests {
	
	private Sort sort;

	public SortTests() {
		sort = new Sort(new CompareInt());
	}
	
	@Test
	void testRadixSort() {
		
		Integer[] values1 = {5,47,21,14,59,65,0};
		var sortedValues1 = sort.radixSort(values1);
		
		assertEquals(0, sortedValues1[0]);
		assertEquals(5, sortedValues1[1]);
		assertEquals(14, sortedValues1[2]);
		assertEquals(21, sortedValues1[3]);
		assertEquals(47, sortedValues1[4]);
		assertEquals(59, sortedValues1[5]);
		assertEquals(65, sortedValues1[6]);
		
		Integer[] values2 = {};
		var sortedValues2 = sort.radixSort(values2);
		
		assertEquals(null, sortedValues2);
		
		
	}

}
