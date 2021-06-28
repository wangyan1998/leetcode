package hard;
//给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
//        例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
//        现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
//        求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。


import java.util.*;

/**
 * @author wy
 * @date 2021/6/28 9:06
 */
public class NumBusesToDestination815 {
    /**
     * 建图+广度优先搜索
     * @param routes
     * @param source
     * @param target
     * @return
     */
    public int numBusesToDestination(int[][] routes,int source,int target){
        if (source == target) {
            return 0;
        }

        int n = routes.length;
        boolean[][] edge = new boolean[n][n];
        Map<Integer, List<Integer>> rec = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            for (int site : routes[i]) {
                List<Integer> list = rec.getOrDefault(site, new ArrayList<Integer>());
                for (int j : list) {
                    edge[i][j] = edge[j][i] = true;
                }
                list.add(i);
                rec.put(site, list);
            }
        }

        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        Queue<Integer> que = new LinkedList<Integer>();
        for (int site : rec.getOrDefault(source, new ArrayList<Integer>())) {
            dis[site] = 1;
            que.offer(site);
        }
        while (!que.isEmpty()) {
            int x = que.poll();
            for (int y = 0; y < n; y++) {
                if (edge[x][y] && dis[y] == -1) {
                    dis[y] = dis[x] + 1;
                    que.offer(y);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for (int site : rec.getOrDefault(target, new ArrayList<Integer>())) {
            if (dis[site] != -1) {
                ret = Math.min(ret, dis[site]);
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}
