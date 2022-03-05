package medium;
//给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
//        返回 nums 中 所有 子数组范围的 和 。
//        子数组是数组中一个连续 非空 的元素序列。
//        1 <= nums.length <= 1000
//        -10^9 <= nums[i] <= 10^9
/**
 * @author wy
 * @date 2022/3/4 8:48
 */
public class SubArrayRanges {
    public long subArrayRanges(int[] nums){
        int n=nums.length;
        long res=0;
        for (int i=0;i<n;i++){
            int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
            for (int j=i;j<n;j++){
                max=Math.max(max,nums[j]);
                min=Math.min(min,nums[j]);
                res+=max-min;
            }
        }
        return res;
    }
}
