package Files;

/**
 * Clase CompareInt. Implementa la interfaz IComparator para implementar el metodo de comparacion.
 * Permite la creacion de un comparador de dos enteros.
 * @author Pablo Zamora, Diego Morales, Erick Guerra.
 * @version 04/03/2022
 */
public class CompareInt implements IComparator<Integer> {

	@Override
	public int Compare(Integer object1, Integer object2) {
		int num1 = object1;
		int num2 = object2;
		int resultado = 0;
		if (object1 > object2) return 1; //Si el entero 1 es mayor, el metodo devuelve 1
		else if (object1 < object2) return -1; //Si el entero 2 es mayor, el metodo devuelve -1
		else return 0; //Si son iguales, el metodo devuelve 0
	}

}