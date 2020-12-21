package classify.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountingSort {
    public int[] countingSort(int[] array){
        if(array.length==0){
            return array;
        }
        int bias,min=array[0],max=array[0];
        for(int i=1;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
            if(array[i]<min){
                min=array[i];
            }
        }
        bias=0-min;
        int[] bucket=new int[max-min+1];
        Arrays.fill(bucket,0);
        for(int i=0;i<array.length;i++){
            bucket[array[i]+bias]++;
        }
        int index=0,i=0;
        while(index<array.length){
            if(bucket[i]!=0){
                array[index]=i-bias;
                bucket[i]--;
                index++;
            }else {
                i++;
            }
        }
        return array;
    }
    public int[] countingSort1(int[] array){
        int[] arr=new int[array.length];
        for(int i=0;i<array.length;i++){
            int num=0;
            for(int j=0;j<array.length;j++){
                if(array[j]<array[i]){
                    num++;
                }
            }
           arr[num]=array[i];
        }
        return arr;
    }
}
