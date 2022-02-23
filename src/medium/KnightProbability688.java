package medium;
//在一个n x n的国际象棋棋盘上，一个骑士从单元格 (row, column)开始，并尝试进行 k 次移动。
//        行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。
//        象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交
//        方向上是一个单元格。每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋
//        子会离开棋盘)，然后移动到那里。
//        骑士继续移动，直到它走了 k 步或离开了棋盘。
//        返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。


/**
 * @author wy
 * @date 2022/2/17 20:28
 */
public class KnightProbability688 {
    static int[][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        for (int step = 0; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (step == 0) {
                        dp[step][i][j] = 1;
                    } else {
                        for (int[] dir : dirs) {
                            int ni = i + dir[0], nj = j + dir[1];
                            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                                dp[step][i][j] += dp[step - 1][ni][nj] / 8;
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }
}
