package Tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import Files.CompareInt;
import Files.Sort;

class SortTests {

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
		comparador.gnomeSort(arreglo, arreglo.length);
		assertEquals(arreglo[0], 4);
		assertEquals(arreglo[1], 7);
		assertEquals(arreglo[2], 8);
		assertEquals(arreglo[3], 12);
		assertEquals(arreglo[4], 21);
		assertEquals(arreglo[5], 26);
		assertEquals(arreglo[6], 55);
	}

}
