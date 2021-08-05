package medium;
//在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
//        对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
//        返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
//        该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是graph的节点数。
//        图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wy
 * @date 2021/8/5 9:13
 */
public class EventualSafeNodes802 {
    /**
     * 深度优先搜索+三色标记法
     * 如果起始节点位于一个环内，或者能到达一个环，则该节点不是安全的。否则该节点是安全的。
     * 我们可以使用深度优先搜索来找环，并在深度优先搜索时用三种颜色进行标记标记规则如下：
     * （1）白色（0）:该节点尚未被访问
     * （2）灰色（1）：该节点位于递归栈中，或者在某个环上
     * （3）黑色（2）:该节点搜索完毕，是一个安全节点
     * 在首先访问一个节点时将其标记为灰色，并继续搜索与其相连的节点，如果在搜索过程中遇到了一个灰色节点，则说明找到了一个环，
     * 此时退出搜索，栈中的节点仍然保持为灰色。这一做法可以吧找到了环这一信息传递到栈中的所有节点上。
     * 如果搜索过程中没有遇到灰色节点，则说明没有遇到环，那么递归返回前，我们将其标记由灰色改为黑色，即表示它是一个安全节点。
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes(int[][] graph){
        int n=graph.length;
        int[] color=new int[n];
        List<Integer> ans=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if(safe(graph,color,i)){
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean safe(int[][] graph,int[] color,int x){
        if(color[x]>0){
            return color[x]==2;
        }
        color[x]=1;
        for(int y:graph[x]){
            if(!safe(graph,color,y)){
                return false;
            }
        }
        color[x]=2;
        return true;
    }

    /**
     * 拓扑排序，若一个节点没有出边，则该节点是安全的；若一个节点出边相连的点都是安全的，则该节点也是安全的。
     * 根据这一性质，我们可以将图中所有边反向，得到一个反图，然后在反图上进行拓扑排序
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes1(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> rg = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) {
            rg.add(new ArrayList<Integer>());
        }
        int[] inDeg = new int[n];
        for (int x = 0; x < n; ++x) {
            for (int y : graph[x]) {
                rg.get(y).add(x);
            }
            inDeg[x] = graph[x].length;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (inDeg[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int y = queue.poll();
            for (int x : rg.get(y)) {
                if (--inDeg[x] == 0) {
                    queue.offer(x);
                }
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (inDeg[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
