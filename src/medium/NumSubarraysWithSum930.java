package medium;
//给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
//        子数组是数组的一段连续部分。

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/7/8 15:01
 */
public class NumSubarraysWithSum930 {
    /**
     * 前缀和，暴力搜索，时间复杂度比较高
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0]=nums[0];
        int count=0;
        if(nums[0]==goal){
            count++;
        }
        for(int i=1;i<n;i++){
            sum[i]=sum[i-1]+nums[i];
            if(sum[i]==goal){
             count++;
            }
            for(int j=0;j<i;j++){
                if(sum[i]-sum[j]==goal){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 遍历统计前缀和的符合个数太浪费时间，可以采用哈希表进行统计。
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum1(int[] nums,int goal){
        int sum=0;
        Map<Integer,Integer> cnt=new HashMap<Integer, Integer>();
        int ret=0;
        for(int num:nums){
            cnt.put(sum,cnt.getOrDefault(sum,0)+1);
            sum+=num;
            ret+=cnt.getOrDefault(sum-goal,0);
        }
        return ret;
    }
}
