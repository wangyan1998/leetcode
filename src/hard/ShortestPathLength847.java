package hard;
//存在一个由 n 个节点组成的无向连通图，图中的节点按从 0 到 n - 1 编号。
//        给你一个数组 graph 表示这个图。其中，graph[i] 是一个列表，由所有与节点 i 直接相连的节点组成。
//        返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wy
 * @date 2021/8/6 9:15
 */
public class ShortestPathLength847 {
    public int shortestPathLength(int[][] graph){
        int n=graph.length;
        Queue<int[]> queue=new LinkedList<int[]>();
        boolean[][] seen=new boolean[n][1<<n];
        for(int i=0;i<n;i++){
            queue.offer(new int[]{i,1<<i,0});
            seen[i][1<<i]=true;
        }
        int ans=0;
        while(!queue.isEmpty()){
            int[] tuple=queue.poll();
            int u=tuple[0],mask=tuple[1],dist=tuple[2];
            if(mask==(1<<n)-1){
                ans=dist;
                break;
            }
            for(int v:graph[u]){
                int maskV=mask|(1<<v);
                if(!seen[v][maskV]){
                    queue.offer(new int[]{v,maskV,dist+1});
                    seen[v][maskV]=true;
                }
            }
        }
        return ans;
    }
}
