package simple;
//小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
//        有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
//        每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
//        每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
//        给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。
//        返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wy
 * @date 2021/7/1 9:48
 */
public class NumWaysLCP07 {
    /**
     * 深度优先搜索遍历
     */
    int ways, n, k;
    List<List<Integer>> edges;

    public int numWays(int n, int[][] relation, int k) {
        ways = 0;
        this.n = n;
        this.k = k;
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] edge : relation) {
            int src = edge[0], dst = edge[1];
            edges.get(src).add(dst);
        }
        dfs(0, 0);
        return ways;
    }

    public void dfs(int index, int steps) {
        if (steps == k) {
            if (index == n - 1) {
                ways++;
            }
            return;
        }
        List<Integer> list = edges.get(index);
        for (int nextIndex : list) {
            dfs(nextIndex, steps + 1);
        }
    }

    /**
     * 广度优先搜索遍历
     * @param n
     * @param relation
     * @param k
     * @return
     */
    public int numWays1(int n, int[][] relation, int k) {
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] edge : relation) {
            int src = edge[0], dst = edge[1];
            edges.get(src).add(dst);
        }

        int steps = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        while (!queue.isEmpty() && steps < k) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                List<Integer> list = edges.get(index);
                for (int nextIndex : list) {
                    queue.offer(nextIndex);
                }
            }
        }

        int ways = 0;
        if (steps == k) {
            while (!queue.isEmpty()) {
                if (queue.poll() == n - 1) {
                    ways++;
                }
            }
        }
        return ways;
    }

    /**
     * 动态规划，dp[i][j]为经过i轮传播到编号为j的方案数，0<=i<=k,0<=j<=n
     * 当i=0时，dp[0][0]=1,dp[0][j]=0(j!=0)
     * 对于传信息关系[src,dst]，如果第i轮传递到src编号的玩家，则第i+1轮可以传到dst玩家。
     * dp[i+1][dst]=sum{[src,dst]属于relation}dp[i][src]
     * 最后答案为dp[k][n-1]
     * @param n
     * @param relation
     * @param k
     * @return
     */
    public int numWays2(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }

    /**
     * 优化版的动态规划
     * 上述实现的空间复杂度是 O(kn)。由于当 i>0 时，dp[i][] 的值只和 dp[i−1][] 的值有关，
     * 因此可以将二维数组变成一维数组，将空间复杂度优化到 O(n)。
     * @param n
     * @param relation
     * @param k
     * @return
     */
    public int numWays3(int n, int[][] relation, int k) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < k; i++) {
            int[] next = new int[n];
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                next[dst] += dp[src];
            }
            dp = next;
        }
        return dp[n - 1];
    }
}
