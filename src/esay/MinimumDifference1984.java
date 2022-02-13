package esay;
//给你一个下标从0开始的整数数组nums，其中nums[i]表示第i名学生的分数。另给你一个整数k。
//        从数组中选出任意k名学生的分数，使这 k 个分数间最高分和最低分的差值达到最小化 。
//        返回可能的 最小差值 。

import java.util.Arrays;

/**
 * @author wy
 * @date 2022/2/11 9:23
 */
public class MinimumDifference1984 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[nums.length - 1] - nums[0];
        for (int i = k - 1; i < nums.length; i++) {
            min = Math.min(min, nums[i] - nums[i - k + 1]);
        }
        return min;
    }
}
