package medium;
//给你一个大小为mxn的整数矩阵isWater，它代表了一个由陆地和水域单元格组成的地图。
//        如果isWater[i][j]==0，格子(i, j)是一个陆地格子。
//        如果isWater[i][j]==1，格子(i, j)是一个水域格子。
//        你需要按照如下规则给每个单元格安排高度：
//        (1)每个格子的高度都必须是非负的。
//        (2)如果一个格子是水域，那么它的高度必须为0。
//        (3)任意相邻的格子高度差至多为1。当两个格子在正东、南、西、北方向上相互紧挨着，就称它们为相邻的格子。
//        （也就是说它们有一条公共边）
//        找到一种安排高度的方案，使得矩阵中的最高高度值最大。
//        请你返回一个大小为mxn的整数矩阵 height，其中height[i][j]是格子(i, j)的高度。如果有多种解法，
//        请返回任意一个。


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author wy
 * @date 2022/1/29 9:06
 */
public class HighestPeak {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(ans[i], -1);
        }
        Queue<int[]> queue = new ArrayDeque<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    ans[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int[] dir : dirs) {
                int x = p[0] + dir[0], y = p[1] + dir[1];
                if (0 <= x && x < m && 0 <= y && y < n && ans[x][y] == -1) {
                   ans[x][y]=ans[p[0]][p[1]]+1;
                   queue.offer(new int[]{x,y});
                }
            }
        }
        return ans;
    }

}