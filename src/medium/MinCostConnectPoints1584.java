package medium;
//给你一个points数组，表示 2D 平面上的一些点，其中points[i] = [xi, yi]。
//        连接点[xi, yi] 和点[xj, yj]的费用为它们之间的 曼哈顿距离：
//        |xi - xj| + |yi - yj|，其中|val|表示val的绝对值。
//        请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有一条简单路径时，
//        才认为所有点都已连接。

import java.util.Arrays;

public class MinCostConnectPoints1584 {
    public int minCostConnectPoints(int[][] points){
        int n = points.length, res = 0, i = 0, connected = 0;
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, 10000000);
        while (++connected < n) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = true;
            int next = i;
            for (int j = 0; j < n; ++j)
                if (dist[j] != Integer.MAX_VALUE) {
                    dist[j] = Math.min(dist[j], Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
                    next = dist[j] < dist[next] ? j : next;
                }
            res += dist[next];
            i = next;
        }
        return res;
    }
}
