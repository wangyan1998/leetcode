package classify.sort;

public class SelectionSort {
    public int[] selectionSort(int[] array){
        if(array.length==0){
            return array;
        }
        for(int i=0;i<array.length;++i){
            int minIndex=i;
            for(int j=i;j<array.length;j++){
                if(array[j]<array[minIndex]){
                    minIndex=j;
                }
            }
            int temp=array[i];
            array[i]=array[minIndex];
            array[minIndex]=temp;
        }
        return array;
    }
}
