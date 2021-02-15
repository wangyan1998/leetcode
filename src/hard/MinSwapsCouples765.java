package hard;
//N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
//        人和座位用0到2N-1的整数表示，情侣们按顺序编号，第一对是(0, 1)，第二对是(2, 3)，以此类推，
//        最后一对是(2N-2, 2N-1)。
//        这些情侣的初始座位row[i]是由最初始坐在第 i 个座位上的人决定的。

import java.util.*;

public class MinSwapsCouples765 {
    /**
     * 并查集
     * @param row
     * @return
     */
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int tot = n / 2;
        int[] f = new int[tot];
        for (int i = 0; i < tot; i++) {
            f[i] = i;
        }

        for (int i = 0; i < n; i += 2) {
            int l = row[i] / 2;
            int r = row[i + 1] / 2;
            add(f, l, r);
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < tot; i++) {
            int fx = getf(f, i);
            map.put(fx, map.getOrDefault(fx, 0) + 1);
        }

        int ret = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ret += entry.getValue() - 1;
        }
        return ret;
    }

    public int getf(int[] f, int x) {
        if (f[x] == x) {
            return x;
        }
        int newf = getf(f, f[x]);
        f[x] = newf;
        return newf;
    }

    public void add(int[] f, int x, int y) {
        int fx = getf(f, x);
        int fy = getf(f, y);
        f[fx] = fy;
    }

    /**
     * 广度优先搜素
     * @param row
     * @return
     */
    public int minSwapsCouples1(int[] row) {
        int n = row.length;
        int tot = n / 2;
        List<Integer>[] graph = new List[tot];
        for (int i = 0; i < tot; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i += 2) {
            int l = row[i] / 2;
            int r = row[i + 1] / 2;
            if (l != r) {
                graph[l].add(r);
                graph[r].add(l);
            }
        }
        boolean[] visited = new boolean[tot];
        int ret = 0;
        for (int i = 0; i < tot; i++) {
            if (!visited[i]) {
                Queue<Integer> queue = new LinkedList<Integer>();
                visited[i] = true;
                queue.offer(i);
                int cnt = 0;

                while (!queue.isEmpty()) {
                    int x = queue.poll();
                    cnt += 1;

                    for (int y : graph[x]) {
                        if (!visited[y]) {
                            visited[y] = true;
                            queue.offer(y);
                        }
                    }
                }
                ret += cnt - 1;
            }
        }
        return ret;
    }
}
