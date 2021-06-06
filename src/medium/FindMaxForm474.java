package medium;
//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
//        请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
//        如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wy
 * @date 2021/6/6 9:31
 */
public class FindMaxForm474 {
    /**
     * 动态规划+倒序滚动数组
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs,int m,int n){
        int[][] dp = new int[m + 1][n + 1];
        for (String s: strs) {
            int[] count = getcount(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--)
                for (int ones = n; ones >= count[1]; ones--)
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
        }
        return dp[m][n];
    }
    public int[] getcount(String s){
        int[] res=new int[2];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                res[0]++;
            }else {
                res[1]++;
            }
        }
        return res;
    }
}
