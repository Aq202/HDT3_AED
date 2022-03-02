package Files;

public class Sort <T> {
	public IComparator comparador;
	
	public Sort(IComparator comparador) {
		this.comparador = comparador;
	}
	
	public void mergeSort(Integer[] arreglo, int inicio, int fin) {
		if(inicio<fin) {
			// Encontrar el punto medio del arreglo
			int medio = inicio + (fin-inicio)/2;
		
			// Ordenar cada mitad
			mergeSort(arreglo, inicio, medio);
			mergeSort(arreglo, medio+1, fin);
			
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
}
