package esay;
//给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/10/20 9:32
 */
public class MinMoves453 {
    /**
     *     将n-1个数加1，相当于将所有数都加1，再将其中一个数减去1。
     *     将所有数都加1这个操作，其实不会改变任何数的相对大小，也就是所有数两两之间的差都是不会变的，
     *     这对于要使所有元素均相等的目标来说没有影响，所以可以忽略这一部分。
     *     那么问题就变成每次选个数减1来达到目标的最小次数。
     *     要使次数最小，而且每次只能将元素减1，故应当把所有数减到与最小值相等。
     * @param nums
     * @return
     */
    public int minMoves(int[] nums){
        Arrays.sort(nums);
        int res=0;
        for(int i=0;i<nums.length;i++){
            res+=nums[i]-nums[0];
        }
        return res;
    }

    public int minMoves1(int[] nums){
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            min= Math.min(min,nums[i]);
        }
        return sum-nums.length*min;
    }
}
