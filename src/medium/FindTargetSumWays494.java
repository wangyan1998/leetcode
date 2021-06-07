package medium;
//给你一个整数数组 nums 和一个整数 target 。
//        向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
//        例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
//        返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wy
 * @date 2021/6/7 8:58
 */
public class FindTargetSumWays494 {
    int count=0;

    /**
     * 回溯法遍历每一个表达式，如果表达式长度为数组长度而且和为目标值，count+1
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums,int target){
        backtrack(nums,target,0,0);
        return count;
    }
    public void backtrack(int[] nums,int target,int index,int sum){
        if(index==nums.length){
            if(sum==target){
                count++;
            }
        }else {
            backtrack(nums,target,index+1,sum+nums[index]);
            backtrack(nums,target,index+1,sum-nums[index]);
        }
    }

    /**
     * 动态规划，问题转化成求nums中元素和为(sum-target)/2的个数，前提是sum-target为非负偶数，否则返回0
     * 如果sum-target为非负偶数，令neg=(sum-target)/2,可以使用背包的思路计算和为neg的方案数
     * 取数组dp[i][j]表示nums前i个元素和为j的方案数
     * 当i=0时，只有dp[0][0]=1,其他都为0
     * 当1<=i<=n时，当j<nums[i]时，不能选nums[i]，所以dp[i][j]=dp[i-1][j]
     *             当j>=nums[i]时，不选nums[i]时，方案数有dp[i-1][j],选择nums[i]时，方案数有dp[i-1][j-nums[i]]，这种情况下总的方案数是两者之和
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays1(int[] nums,int target){
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        int diff=sum-target;
        if(diff<0||diff%2!=0){
            return 0;
        }
        int n=nums.length,neg=diff/2;
        int[][] dp=new int[n+1][neg+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            int num=nums[i-1];
            for(int j=0;j<=neg;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=num){
                    dp[i][j]+=dp[i-1][j-num];
                }
            }
        }
        return dp[n][neg];
    }

    /**
     * 由于dp的每一行计算只和上一行有关，所以可以使用滚动数组的方式，去掉dp一个纬度，实现的时候内层循环需要采用倒序的便利方式
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }
}
