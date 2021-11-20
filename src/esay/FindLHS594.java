package esay;
//和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
//        现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
//        数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。


import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wy
 * @date 2021/11/20 10:26
 */
public class FindLHS594 {
    /**
     * 枚举法
     * @param nums
     * @return
     */
    public int findLHS(int[] nums){
        Arrays.sort(nums);
        int begin=0;
        int res=0;
        for(int end=0;end<nums.length;end++){
            while(nums[end]-nums[begin]>1){
                begin++;
            }
            if(nums[end]-nums[begin]==1){
                res=Math.max(res,end-begin+1);
            }
        }
        return res;
    }

    /**
     * 哈希统计
     * @param nums
     * @return
     */
    public int findLHS1(int[] nums){
        HashMap<Integer,Integer> cnt=new HashMap<>();
        int res=0;
        for(int num:nums){
            cnt.put(num,cnt.getOrDefault(num,0)+1);
        }
        for(int key:cnt.keySet()){
            if(cnt.containsKey(key+1)){
                res=Math.max(res,cnt.get(key)+cnt.get(key+1));
            }
        }
        return res;
    }
}
