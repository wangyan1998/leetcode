package medium;
//元素的 频数 是该元素在一个数组中出现的次数。
//        给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
//        执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。


import java.util.Arrays;

/**
 * @author wy
 * @date 2021/7/19 9:24
 */
public class MaxFrequency1838 {
    /**
     * 滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public int maxFrequency(int[] nums, int k) {
       Arrays.sort(nums);
       int n=nums.length;
       long total=0;
       int l=0,res=1;
       for(int r=1;r<n;r++){
           total+=(long)(nums[r]-nums[r-1])*(r-l);
           while (total>k){
               total-=nums[r]-nums[l];
               l++;
           }
           res=Math.max(res,r-l+1);
       }
       return res;
    }
}
