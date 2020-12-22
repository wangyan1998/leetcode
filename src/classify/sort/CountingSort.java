package classify.sort;

import java.util.Arrays;
public class CountingSort {
    public int[] countingSort(int[] array){
        if(array.length==0){
            return array;
        }
        //一：求取最大值和最小值，计算中间数组的长度：中间数组是用来记录原始数据中每个值出现的频率
        int min=array[0],max=array[0];
        for(int i=1;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
            if(array[i]<min){
                min=array[i];
            }
        }
        //二：有了最大值和最小值能够确定中间数组的长度
        int[] bucket=new int[max-min+1];
        Arrays.fill(bucket,0);
        //三.循环遍历旧数组计数排序: 就是统计原始数组值出现的频率到中间数组中
        for(int i=0;i<array.length;i++){
            bucket[array[i]-min]++;
        }
        int index=0,i=0;
        //先循环每一个元素，取得数值下标，添加到原来数组中
        while(index<array.length){
            if(bucket[i]!=0){
                array[index]=i+min;
                bucket[i]--;
                index++;
            }else {
                i++;
            }
        }
        return array;
    }
    public int[] countingSort1(int[] array){//自写,不好，重复有冲突
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
