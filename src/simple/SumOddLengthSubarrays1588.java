package simple;
//给你一个正整数数组arr，请你计算所有可能的奇数长度子数组的和。
//        子数组 定义为原数组中的一个连续子序列。
//        请你返回 arr中 所有奇数长度子数组的和 。

/**
 * @author wy
 * @date 2021/8/29 8:59
 */
public class SumOddLengthSubarrays1588 {
    /**
     * 前缀和
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr){
        int n=arr.length;
        if(n==1){
            return arr[0];
        }
        int res=arr[0];
        int[] sum=new int[n];
        sum[0]=arr[0];
        for(int i=1;i<n;i++){
            sum[i]=sum[i-1]+arr[i];
            if(i%2==1){
                for(int j=0;j<i;j+=2){
                    res+=sum[i]-sum[j];
                }
            }else {
                res+=sum[i];
                for(int j=1;j<i;j+=2){
                    res+=sum[i]-sum[j];
                }
            }
        }
        return res;
    }

    public int sumOddLengthSubarrays1(int[] arr){
        int res=0;
        for(int i=0;i<arr.length;i++){
            int left=i+1,right=arr.length-i;
            int lefteven=(left+1)/2,righteven=(right+1)/2;
            int leftodd=left/2,rightodd=right/2;
            res+=(lefteven*righteven+leftodd*rightodd)*arr[i];
        }
        return res;
    }
}
