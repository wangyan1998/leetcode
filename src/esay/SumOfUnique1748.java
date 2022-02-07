package esay;
//给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
//        请你返回 nums 中唯一元素的 和 。

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2022/2/6 9:09
 */
public class SumOfUnique1748 {
    public int sumOfUnique(int[] nums){
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        int res=0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])==1){
                res+=nums[i];
            }else if(map.get(nums[i])==2){
                res-=nums[i];
            }
        }
        return res;
    }
}
