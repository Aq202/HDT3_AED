package Files;

/**
 * Interfaz que indica el metodo a implementar por una clase que compare dos objetos. Utiliza genericos.
 * @author Pablo Zamora, Diego Morales, Erick Guerra
 * @param <T> Tipo de objeto a comparar
 * @version 04/03/2022
 */
public interface IComparator<T> {
	
	/**
	 * Metodo Compare. Permite que las clases que lo implementen comparen dos objetos.
	 * @param object1
	 * @param object2
	 * @return int
	 */
	public int Compare(T object1, T object2);
}
