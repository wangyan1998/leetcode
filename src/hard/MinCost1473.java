package hard;
//在一个小城市里，有m个房子排成一排，你需要给每个房子涂上 n种颜色之一（颜色编号为 1 到 n）。有的房子去年夏天已经涂过颜色了，
//        所以这些房子不需要被重新涂色。
//        我们将连续相同颜色尽可能多的房子称为一个街区。（比方说 houses = [1,2,2,3,3,2,1,1] ，它包含 5 个街区
//        [{1}, {2,2}, {3,3}, {2}, {1,1}] 。）
//        给你一个数组houses，一个m*n的矩阵cost和一个整数target，其中：
//        houses[i]：是第i个房子的颜色，0表示这个房子还没有被涂色。
//        cost[i][j]：是将第i个房子涂成颜色j+1的花费。
//        请你返回房子涂色方案的最小总花费，使得每个房子都被涂色后，恰好组成target个街区。如果没有可用的涂色方案，请返回-1。


import java.util.Arrays;

/**
 * @author wy
 * @date 2021/5/4 9:41
 */
public class MinCost1473 {
    // 极大值
    // 选择 Integer.MAX_VALUE / 2 的原因是防止整数相加溢出
    static final int INFTY = Integer.MAX_VALUE / 2;

    /**
     * 动态规划
     * @param houses
     * @param cost
     * @param m
     * @param n
     * @param target
     * @return
     */
    public int minCost(int[] houses,int[][] cost,int m,int n,int target){
        // 将颜色调整为从 0 开始编号，没有被涂色标记为 -1
        for (int i = 0; i < m; ++i) {
            --houses[i];
        }

        // dp 所有元素初始化为极大值
        int[][][] dp = new int[m][n][target];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dp[i][j], INFTY);
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (houses[i] != -1 && houses[i] != j) {
                    continue;
                }

                for (int k = 0; k < target; ++k) {
                    for (int j0 = 0; j0 < n; ++j0) {
                        if (j == j0) {
                            if (i == 0) {
                                if (k == 0) {
                                    dp[i][j][k] = 0;
                                }
                            } else {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k]);
                            }
                        } else if (i > 0 && k > 0) {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j0][k - 1]);
                        }
                    }

                    if (dp[i][j][k] != INFTY && houses[i] == -1) {
                        dp[i][j][k] += cost[i][j];
                    }
                }
            }
        }

        int ans = INFTY;
        for (int j = 0; j < n; ++j) {
            ans = Math.min(ans, dp[m - 1][j][target - 1]);
        }
        return ans == INFTY ? -1 : ans;
    }
}
