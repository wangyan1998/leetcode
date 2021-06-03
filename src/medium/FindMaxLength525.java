package medium;
//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/6/3 9:21
 */
public class FindMaxLength525 {
    /**
     * 前缀和+哈希表
     * 把数组中的1当作1，把数组中的0当作-1，这样如果一个范围内的0,1个数相同，则他们的和为0
     * 从前缀和的角度来看，也就是两个位置的前缀和相同，比如i,j位置的前缀和相同，则表明j-i长度的子数组是0,1个数相同的子数组
     * 这样便利过程中找到最长的子数组就可以了。用map记录前缀和第一次出现的位置。
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums){
        int maxLength=0;
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        int counter=0;
        map.put(counter,-1);
        int n=nums.length;
        for(int i=0;i<n;i++){
            int num=nums[i];
            if(num==1){
                counter++;
            }else {
                counter--;
            }
            if(map.containsKey(counter)){
                int prevIndex=map.get(counter);
                maxLength=Math.max(maxLength,i-prevIndex);
            }else {
                map.put(counter,i);
            }
        }
        return maxLength;
    }
}
