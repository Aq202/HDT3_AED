public class CompareInt implements IComparator<Integer> {

	@Override
	public int Compare(Integer object1, Integer object2) {
		int num1 = object1;
		int num2 = object2;
		int resultado = 0;
		if (object1 > object2) return 1;
		else if (object1 < object2) return -1;
		else return 0;
	}

}