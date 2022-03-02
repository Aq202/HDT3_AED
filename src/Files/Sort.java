package Files;

import java.util.Arrays;

public class Sort <T> {
	public IComparator comparador;
	
	public Sort(IComparator comparador) {
		this.comparador = comparador;
	}
	
	/**
	 * Se encarga de retornar el entero más grande dentro de un array.
	 * @param elements array.
	 * @return
	 */
	private int getMaxNumber(Integer[] elements) {
		int max = elements[0];
		for(int number:elements) {
			if(number > max) max = number;
		}
		return max;
	}
	
	/**
	 * Ordena los numeros de un array en base a la unidad del exponente especificado.
	 * @param elements Integer[]
	 * @param exp exponente
	 * @return Integer[]. Array ordenado
	 */
	private Integer[] radix_orderByDigit(Integer[] elements, int exp) {
		
		Integer[][] numbersByDigit = new Integer[10][elements.length];
		Integer[] count = new Integer[10];
		Integer[] output = new Integer[elements.length];
		
		Arrays.fill(count, 0); //rellenar count con O's
		
		for(Integer number: elements) {
			
			int digit = (number / exp) % 10;
			
			//agrupar por digito
			numbersByDigit[digit][count[digit]] = number;			
			//aumentar la cantidad de numeros con n digito
			count[digit]++;				
		}
		
		int outputCount = 0;
		//crear array de salida
		for(int i = 0; i < numbersByDigit.length; i++) {
			for(int j = 0; j < numbersByDigit[i].length; j++) {
				
				Integer number = numbersByDigit[i][j];				
				if(number != null) {
					output[outputCount] = number;
					outputCount++;
				}else break;				
			}
		}
		return output;
	}
	
	/**
	 * Ordena los numeros enteros de un array a traves del metodo radix
	 * @param elements Integer[]
	 * @return Integer[]. Array ordenado.
	 */
	public Integer[] radixSort(Integer[] elements) {
		
		if(elements == null || elements.length == 0) return null;
		int max = getMaxNumber(elements);
		
		//aumentar potencia de 10
		for(int exp = 1; max / exp > 0; exp *= 10) {
			elements = radix_orderByDigit(elements, exp);
		}
		return elements;
	}
}
