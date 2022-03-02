package Files;

public class Sort <T> {
	public IComparator comparador;
	
	public Sort(IComparator comparador) {
		this.comparador = comparador;
	}
	
    public void bubbleSort(T[] myArray){
        for (int i = 0; i<myArray.length-1; i++){
            for (int j = i + 1; j < myArray.length; j++){
                if(comparador.Compare(myArray[i], myArray[j]) > 0){
                    T temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }
    }

    public void quickSort(T[] myArray, int inf, int sup){
        int i = inf - 1;
        int j = sup;
        boolean flag = true;
        T temp;
        if (inf >= sup){
            return;
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
    }

    public void gnomeSort(T[] myArray, int size){
        int index = 0;
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
    }
}
