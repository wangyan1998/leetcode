package classify.dp;
//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
//        请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
//        如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。

public class FindMaxForm474 {
    /*
    动态规划思想：
    首先，构造一个dp数组，dp[i][j] 表示当前数组中，最多有 i个0、j个1 的字符串
    遍历字符串数组strs：
     记录 当前字符串 中的 0/1个数
     dp[i][j] 的结果有两种情况：
       1、当前状态(dp[i][j])
       2、上一个状态(dp[i - zeroNum][j - oneNum])的个数 + 1
     */
    public int findMaxForm(String[] strs,int m,int n) {
            int[][] dp = new int[m + 1][n + 1];
            for (String s: strs) {
                int[] count = countzeroesones(s);
                for (int zeroes = m; zeroes >= count[0]; zeroes--)
                    for (int ones = n; ones >= count[1]; ones--)
                        dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
            }
            return dp[m][n];
    }
    public int[] countzeroesones(String s) {
            int[] c = new int[2];
            for (int i = 0; i < s.length(); i++) {
                c[s.charAt(i)-'0']++;
            }
            return c;
    }
}
