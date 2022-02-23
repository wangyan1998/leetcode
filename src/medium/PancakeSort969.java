package medium;
//给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。
//        一次煎饼翻转的执行过程如下：
//        选择一个整数 k ，1 <= k <= arr.length
//        反转子数组 arr[0...k-1]（下标从 0 开始）
//        例如，arr = [3,2,1,4] ，选择 k = 3 进行一次煎饼翻转，反转子数组 [3,2,1] ，
//        得到 arr = [1,2,3,4] 。
//        以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转
//        次数在10 * arr.length 范围内的有效答案都将被判断为正确。
//        1 <= arr.length <= 100
//        1 <= arr[i] <= arr.length
//        arr 中的所有整数互不相同（即，arr 是从 1 到 arr.length 整数的一个排列）


import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2022/2/19 18:14
 */
public class PancakeSort969 {
    /**
     * 设一个元素的下标是index，我们可以通过两次煎饼排序将它放到尾部：
     * （1）选择k=index+1,然后反转子数组arr[0,k-1],此时该元素已经被放到首部
     * （2）选择k=n,其中n是数组arr的长度，然后反转整个数组，此时该元素已经被放到尾部。
     * 重复上述操作，每次将最大值放到尾部，并且将数组最后一个元素去掉，针对新的数组进行操作。
     * @param arr
     * @return
     */
    public List<Integer> pancakeSort(int[] arr){
        List<Integer> ret=new ArrayList<Integer>();
        for(int n=arr.length;n>1;n--){
            int index=0;
            for(int i=0;i<n;i++){
                if(arr[i]>=arr[index]){
                    index=i;
                }
            }
            if (index==n-1){
                continue;
            }
            reverse(arr,index);
            reverse(arr,n-1);
            ret.add(index+1);
            ret.add(n);
        }
        return ret;
    }
    public void reverse(int[] arr,int end){
        for (int i=0,j=end;i<j;i++,j--){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }
}
