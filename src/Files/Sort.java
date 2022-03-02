package Files;

import java.util.Arrays;

public class Sort <T> {
	public IComparator comparador;
	
	public Sort(IComparator comparador) {
		this.comparador = comparador;
	}
	
	public Integer[] mergeSort(Integer[] arreglo) {
		Integer[] arr = arreglo;
		mSort(arr, 0, arr.length-1);
		return arr;
	}
	
	public void mSort(Integer[] arreglo, int inicio, int fin) {
		if(inicio<fin) {
			// Encontrar el punto medio del arreglo
			int medio = inicio + (fin-inicio)/2;
		
			// Ordenar cada mitad
			mSort(arreglo, inicio, medio);
			mSort(arreglo, medio+1, fin);
			
			// Unir las dos mitades
			merge(arreglo, inicio, medio, fin);
		}
	}
	
	public void merge(Integer[] arreglo, int inicio, int medio, int fin)
    {
		// Encontrar el tamano de los subarreglos a ser unidos
		int n1 = medio - inicio + 1;
		int n2 = fin - medio;

		// Crear arreglos temporales
		Integer[] arr1 = new Integer[n1];
		Integer[] arr2 = new Integer[n2];

		// Copiar la informacion a los arreglos temporales
		for (int i = 0; i < n1; ++i)
			arr1[i] = arreglo[inicio + i];
		for (int j = 0; j < n2; ++j)
			arr2[j] = arreglo[medio + 1 + j];

		// Unir los arreglos temporales

		// Indices iniciales de cada subarreglo
		int i = 0, j = 0;

		// Indice inicial del arreglo unido
		int k = inicio;
		while (i < n1 && j < n2) {
			if (arr1[i] <= arr2[j]) {
				arreglo[k] = arr1[i];
				i++;
			}
			else {
				arreglo[k] = arr2[j];
				j++;
			}
			k++;
		}

		// Copiar elementos restantes de arr1[] si los hay
		while (i < n1) {
			arreglo[k] = arr1[i];
			i++;
			k++;
		}

		// Copiar elementos restantes de arr2[] si los hay
		while (j < n2) {
			arreglo[k] = arr2[j];
			j++;
			k++;
		}
	}
	/**
	 * Se encarga de retornar el entero m�s grande dentro de un array.
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
	 /** Ordena los numeros enteros de un array a traves del metodo burbuja
	 * @param myArray Integer[]
	 */
    public T[] bubbleSort(T[] myArray){
        for (int i = 0; i<myArray.length-1; i++){
            for (int j = i + 1; j < myArray.length; j++){
                if(comparador.Compare(myArray[i], myArray[j]) > 0){
                    T temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }
        return myArray;
    }

    /**
	 * Ordena los numeros enteros de un array a traves del metodo quicksort
	 * @param myArray Integer[]
	 * @param inf int
	 * @param sup int
	 */
    public T[] quickSort(T[] myArray, int inf, int sup){
        int i = inf - 1;
        int j = sup;
        boolean flag = true;
        T temp;
        if (inf >= sup){
            return null;
        }

        T element_div = myArray[sup];

        while (flag){
            while(comparador.Compare(myArray[++i], element_div) < 0);
            while(comparador.Compare(myArray[--j], element_div) > 0 && (j>inf));
            if (i < j){
                temp = myArray[i];
                myArray[i] = myArray[j];
                myArray[j] = temp;
            }
            else{
            flag = false;  
            }
        }
        temp = myArray[i];
	    myArray[i] = myArray[sup];
	    myArray[sup] = temp;
	    quickSort(myArray, inf, i - 1);
	    quickSort(myArray, i + 1, sup);
	    
	    return myArray;
    }

    /**
	 * Ordena los numeros enteros de un array a traves del metodo burbuja
	 * @param myArray Integer[]
	 */
    public T[] gnomeSort(T[] myArray){
        int index = 0;
        int size = myArray.length;
        while (index < size){
            if (index == 0) index++;
            if (comparador.Compare(myArray[index], myArray[index - 1]) > 0){
                index++;
            }
            else{
                T temp = myArray[index];
                myArray[index] = myArray[index-1];
                myArray[index-1] = temp;
                index--;
            }
        }
        return myArray;
    }
}
