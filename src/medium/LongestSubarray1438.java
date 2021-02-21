package medium;
//给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，
//        该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
//        如果不存在满足条件的子数组，则返回 0 。


import java.util.TreeMap;

public class LongestSubarray1438 {
    public int longestSubarray(int[] nums,int limit){
        TreeMap<Integer,Integer> map=new TreeMap<Integer, Integer>();
        int n=nums.length;
        int left=0,right=0;
        int ret=0;
        while(right<n){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while (map.lastKey()-map.firstKey()>limit){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            ret=Math.max(ret,right-left+1);
            right++;
        }
        return ret;
    }
}
