package esay;
//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//        要求时间复杂度为O(n)。


/**
 * @author wy
 * @date 2021/7/17 9:29
 */
public class MaxSubArrayJZ42 {
    /**
     * 动态规划：max[i]表示i之前的数的和的最大值（包括nums[i]）
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        max[0] = nums[0];
        int maxres = max[0];
        for (int i = 1; i < n; i++) {
            if(max[i-1]>=0){
                if(nums[i]>=0){
                    max[i]=max[i-1]+nums[i];
                }else {
                    max[i]=Math.max(max[i-1]+nums[i],nums[i]);
                }
            }else {
                if(nums[i]>=0){
                    max[i]=nums[i];
                }else {
                    max[i]=Math.max(max[i-1],nums[i]);
                }
            }
            maxres=Math.max(maxres,max[i]);
        }
        return maxres;
    }

    public int maxSubArray1(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
