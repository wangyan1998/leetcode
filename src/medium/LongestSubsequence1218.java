package medium;
//给你一个整数数组arr和一个整数difference，请你找出并返回 arr中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
//        子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。

import java.util.*;

/**
 * @author wy
 * @date 2021/11/5 9:34
 */
public class LongestSubsequence1218 {
    /**
     * 动态规划
     * @param arr
     * @param difference
     * @return
     */
    public int longestSubsequence(int[] arr,int difference){
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }
}
