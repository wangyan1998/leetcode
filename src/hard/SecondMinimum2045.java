package hard;
//城市用一个 双向连通 图表示，图中有 n 个节点，从 1 到 n 编号（包含 1 和 n）。
//        图中的边用一个二维整数数组 edges 表示，其中每个 edges[i] = [ui, vi]
//        表示一条节点ui 和节点vi 之间的双向连通边。每组节点对由 最多一条 边连通，
//        顶点不存在连接到自身的边。穿过任意一条边的时间是 time分钟。
//        每个节点都有一个交通信号灯，每change分钟改变一次，从绿色变成红色，
//        再由红色变成绿色，循环往复。所有信号灯都同时 改变。你可以在 任何时候
//        进入某个节点，但是 只能 在节点信号灯是绿色时 才能离开。如果信号灯是绿色，
//        你不能在节点等待，必须离开。
//        第二小的值 是严格大于 最小值的所有值中最小的值。
//        例如，[2, 3, 4] 中第二小的值是 3 ，而 [2, 2, 4] 中第二小的值是 4 。
//        给你n、edges、time 和 change ，返回从节点 1 到节点 n 需要的 第二短时间 。
//        注意：
//        你可以 任意次 穿过任意顶点，包括 1 和 n 。
//        你可以假设在 启程时 ，所有信号灯刚刚变成 绿色 。


import java.util.*;

/**
 * @author wy
 * @date 2022/1/24 9:31
 */
public class SecondMinimum2045 {
    public int secondMinimum(int n,int[][] edges,int time,int change){
        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // path[i][0] 表示从 1 到 i 的最短路长度，path[i][1] 表示从 1 到 i 的严格次短路长度
        int[][] path = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(path[i], Integer.MAX_VALUE);
        }
        path[1][0] = 0;
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{1, 0});
        while (path[n][1] == Integer.MAX_VALUE) {
            int[] arr = queue.poll();
            int cur = arr[0], len = arr[1];
            for (int next : graph[cur]) {
                if (len + 1 < path[next][0]) {
                    path[next][0] = len + 1;
                    queue.offer(new int[]{next, len + 1});
                } else if (len + 1 > path[next][0] && len + 1 < path[next][1]) {
                    path[next][1] = len + 1;
                    queue.offer(new int[]{next, len + 1});
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < path[n][1]; i++) {
            if (ret % (2 * change) >= change) {
                ret = ret + (2 * change - ret % (2 * change));
            }
            ret = ret + time;
        }
        return ret;
    }
}
