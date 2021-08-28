package simple;
//给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
//        请返回 nums 的动态和。


/**
 * @author wy
 * @date 2021/8/28 9:06
 */
public class RunningSum1480 {
    public int[] runningSum(int[] nums){
       int[] sum=new int[nums.length];
       sum[0]=nums[0];
       int summ=nums[0];
       for(int i=1;i<nums.length;i++){
           summ+=nums[i];
           sum[i]=summ;
       }
       return sum;
    }
}
