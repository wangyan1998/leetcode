package esay;
//给你一个整数数组nums和一个整数k,请你返回数对(i, j)的数目，满足i<j且|nums[i] - nums[j]| == k。
//        |x|的值定义为：
//        如果x >= 0，那么值为x。
//        如果x < 0，那么值为-x。

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2022/2/9 10:29
 */
public class CountKDifference2008 {
    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int countKDifference(int[] nums,int k){
        Map<Integer,Integer> map=new HashMap<>();
        int res=0;
        for(int i=0;i<nums.length;i++){
            res=res+map.getOrDefault(nums[i]+k,0)+map.getOrDefault(nums[i]-k,0);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return res;
    }
}
