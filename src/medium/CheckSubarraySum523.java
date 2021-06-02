package medium;
//给你一个整数数组 nums 和一个整数k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
//        子数组大小 至少为 2 ，且
//        子数组元素总和为 k 的倍数。
//        如果存在，返回 true ；否则，返回 false 。
//        如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。


import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/6/2 9:08
 */
public class CheckSubarraySum523 {
    /**
     * 暴力算法，一般会超时
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums,int k){
        boolean res=false;
        int n=nums.length;
        int[] sum=new int[n];
        sum[0]=nums[0];
        for(int i=1;i<n;i++){
            sum[i]=sum[i-1]+nums[i];
            if(sum[i]%k==0){
                res=true;
            }
        }
        int a=0;
        for(int i=2;i<n;i++){
            for(int j=0;j<i-1;j++){
                a=sum[i]-sum[j];
                if(a%k==0){
                    res=true;
                    break;
                }
            }
        }
        return res;
    }

    /**
     *如果p-q是k的倍数，则p%k和q%k结果应该是相同的，也就是如果两个数的差是k的倍数，那么两个数对k的余数应该是一样的。
     *可以用map记录余数出现的第一次位置，然后下次再出现，判断两次位置差>=2就可以了
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum1(int[] nums,int k){
        int n=nums.length;
        int sum=0;
        int pre=0;
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        sum=nums[0];
        map.put(nums[0]%k,0);
        for(int i=1;i<n;i++){
            sum=sum+nums[i];
            pre=sum%k;
            if(pre==0){
                return true;
            }
            int l=map.getOrDefault(pre,-1);
            if(l!=-1){
                if(i-l>=2){
                    return true;
                }
            }else {
                map.put(pre,i);
            }
        }
       return false;
    }
}
