package medium;
//给你一个由不同整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
//        题目数据保证答案符合 32 位整数范围。


/**
 * @author wy
 * @date 2021/4/24 9:01
 */
public class CombinationSum4377 {
    /**
     * 动态规划：dp[x]表示选取的元素之和等于x的方案数。目标是求dp[target]
     * dp[0]=1;当不选取任何元素的时候，元素之和才为0，因此只有一种方案。
     * 当1<=i<=target时，如果存在一种排列，其中的元素和等于i，则排在该排列的最后一个元素一定是数组nums中的一个元素。假设该元素
     * 是num,则一定有num<=i，对于元素之和等于i-num的每一种排列，在最后添加num之后可以得到一个元素之和等于i的排列，因此在计算dp[i]
     * 时，应该计算所有的dp[i-num]之和。
     * 所以动态规划过程：
     * (1)初始化dp[0]=1;
     * (2)遍历i从1到target对于每一个i，进行如下操作：
     *     遍历数组nums中的每一个元素num，当num<=i时，将dp[i-num]的值加到dp[i]。
     * (3)最终得到dp[target]的值即为答案。
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums,int target){
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int num:nums){
                if(num<=i){
                    dp[i]+=dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
