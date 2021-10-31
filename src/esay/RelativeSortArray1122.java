package esay;
//给你两个数组，arr1 和arr2，
//        arr2中的元素各不相同
//        arr2 中的每个元素都出现在arr1中
//        对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾。

import java.util.Arrays;

public class RelativeSortArray1122 {
    public int[] relativeSortArray(int[] arr1,int[] arr2){//交换方法
        int n1=arr1.length;
        int n2=arr2.length;
        int c=0;
        for(int i=0;i<n2;i++){
            for(int j=0;j<n1;j++){
                if(arr1[j]==arr2[i]){
                    swap(arr1,c,j);
                    c++;
                }
            }
        }
        Arrays.sort(arr1,c,n1);
        return arr1;
    }
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public int[] relativeSortArray1(int[] arr1,int[] arr2){//计数排序
        int upper=0;
        for(int x:arr1){
            upper=Math.max(upper,x);
        }
        int[] frequency=new int[upper+1];
        for (int x:arr1){
            ++frequency[x];
        }
        int[] ans=new int[arr1.length];
        int index = 0;
        for(int x:arr2){
            for(int i=0;i<frequency[x];++i){
                ans[index++]=x;
            }
            frequency[x]=0;
        }
        for(int x=0;x<=upper;++x){
            for(int i=0;i<frequency[x];++i){
                ans[index++]=x;
            }
        }
        return ans;
    }
}
