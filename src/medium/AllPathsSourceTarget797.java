package medium;
//给你一个有n个节点的有向无环图（DAG），请你找出所有从节点0到节点n-1的路径并输出（不要求按特定顺序）
//        二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
//        译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。


import java.util.ArrayList;
import java.util.*;

/**
 * @author wy
 * @date 2021/8/25 9:49
 */
public class AllPathsSourceTarget797 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Deque<Integer> stack = new ArrayDeque<Integer>();

    /**
     * 深度优先搜索
     * @param graph
     * @return
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    public void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            ans.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int y : graph[x]) {
            stack.offerLast(y);
            dfs(graph, y, n);
            stack.pollLast();
        }
    }
}
