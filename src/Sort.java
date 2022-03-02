public class Sort <T> {
	public IComparator comparador;
	
	public Sort(IComparator comparador) {
		this.comparador = comparador;
	}
}
