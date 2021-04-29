package hard;
//一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，
//        但是不可以跳入水中。
//        给你石子的位置列表 stones（用单元格序号 升序 表示），请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
//        开始时，青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
//        如果青蛙上一步跳跃了k个单位，那么它接下来的跳跃距离只能选择为k - 1、k或k + 1 个单位。另请注意，青蛙只能向前方（终点的方向）跳跃。

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/4/29 10:50
 */
public class CanCross403 {
    private Boolean[][] rec;

    /**
     * 记忆搜索+二分查找
     * 深度优先搜索，当青蛙位于第i个石子，上次跳跃距离为lastDis时，他能够跳跃的距离范围为[lastDis-1,lsatDis+1].
     * 我们需要分别判断这三个距离对应的三个位置是否存在石子。查找石子可以采用二分查找，因为石子位置编号是升序。
     * @param stones
     * @return
     */
    public boolean canCross(int[] stones) {
        int n = stones.length;
        rec = new Boolean[n][n];
        return dfs(stones, 0, 0);
    }

    private boolean dfs(int[] stones, int i, int lastDis) {
        if (i == stones.length - 1) {
            return true;
        }
        if (rec[i][lastDis] != null) {
            return rec[i][lastDis];
        }

        for (int curDis = lastDis - 1; curDis <= lastDis + 1; curDis++) {
            if (curDis > 0) {
                int j = Arrays.binarySearch(stones, i + 1, stones.length, curDis + stones[i]);
                if (j >= 0 && dfs(stones, j, curDis)) {
                    return rec[i][lastDis] = true;
                }
            }
        }
        return rec[i][lastDis] = false;
    }

    /**
     * 动态规划：令dp[i][k]表示青蛙能否达到现在所处编号为i且上一次跳跃距离为k的状态
     * 状态转移方程为：dp[i][k]=dp[j][k-1]||dp[j][k]||dp[j][k+1]
     * 其中j代表了青蛙的上一次所在的石子编号，满足stones[i]-stones[i]=k;
     * 初始dp[0][0]=true
     * @param stones
     * @return
     */
    public boolean canCross1(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; ++i) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }
}
