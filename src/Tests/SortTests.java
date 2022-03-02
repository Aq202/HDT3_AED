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

	@Test
	void testBubbleSort() {
		Sort comparador = new Sort(new CompareInt());
		Integer[] arreglo = new Integer[] {4,12,7,8,26,55,21}; //4,7,8,12,21,26,55
		comparador.bubbleSort(arreglo);
		assertEquals(arreglo[0], 4);
		assertEquals(arreglo[1], 7);
		assertEquals(arreglo[2], 8);
		assertEquals(arreglo[3], 12);
		assertEquals(arreglo[4], 21);
		assertEquals(arreglo[5], 26);
		assertEquals(arreglo[6], 55);
	}

	@Test
	void testQuickSort() {
		Sort comparador = new Sort(new CompareInt());
		Integer[] arreglo = new Integer[] {4,12,7,8,26,55,21}; //4,7,8,12,21,26,55
		comparador.quickSort(arreglo, 0, arreglo.length-1);
		assertEquals(arreglo[0], 4);
		assertEquals(arreglo[1], 7);
		assertEquals(arreglo[2], 8);
		assertEquals(arreglo[3], 12);
		assertEquals(arreglo[4], 21);
		assertEquals(arreglo[5], 26);
		assertEquals(arreglo[6], 55);
	}

	@Test
	void testGnomeSort() {
		Sort comparador = new Sort(new CompareInt());
		Integer[] arreglo = new Integer[] {4,12,7,8,26,55,21}; //4,7,8,12,21,26,55
		comparador.gnomeSort(arreglo);
		assertEquals(arreglo[0], 4);
		assertEquals(arreglo[1], 7);
		assertEquals(arreglo[2], 8);
		assertEquals(arreglo[3], 12);
		assertEquals(arreglo[4], 21);
		assertEquals(arreglo[5], 26);
		assertEquals(arreglo[6], 55);
	}

}
