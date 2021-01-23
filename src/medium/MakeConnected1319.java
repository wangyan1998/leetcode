package medium;
//用以太网线缆将n台计算机连接成一个网络，计算机的编号从0到n-1。
//        线缆用connections表示，其中connections[i] = [a, b]连接了计算机a和b。
//        网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
//        给你这个计算机网络的初始布线connections，你可以拔开任意两台直连计算机之间的线缆，
//        并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。
//        如果不可能，则返回-1 。

import java.util.ArrayList;
import java.util.List;

public class MakeConnected1319 {
    /**
     * 并查集的方法，n个顶点互相连通至少需要n-1条边，利用并查集得到该图的连通分量的
     * 个数count，要把这些连通分量连接起来需要count-1条边，也就是在边数充足的情况下
     * 我们需要count-1次操作
     * @param n
     * @param connections
     * @return
     */
    public int makeConnected(int n,int[][] connections){
        int length=connections.length;
        if(length<n-1){
            return -1;
        }
        UniFind unif=new UniFind(n);
        for(int i=0;i<length;i++){
            unif.Union(connections[i][0],connections[i][1]);
        }
        return unif.count-1;
    }
    class UniFind{
        int[] parent;
        int count;
        public UniFind(int n){
            parent=new int[n];
            for (int i = 0; i <n ; i++) {
                parent[i]=i;
                count++;
            }
        }
        public void Union(int index1,int index2){
            int x=Find(index1);
            int y=Find(index2);
            if(x==y){
                return;
            }
            parent[y]=x;
            count--;
        }
        public int Find(int index){
            if(parent[index]!=index){
                parent[index]=Find(parent[index]);
            }
           return parent[index];
        }
    }

    /**
     * 深度遍历求连通分量的方法
     */
    List<Integer>[] edges;
    boolean[] used;
    public int makeConnected1(int n,int[][] connections){
        if(connections.length<n-1){
            return -1;
        }
        edges=new List[n];
        for(int i=0;i<n;i++){
            edges[i]=new ArrayList<Integer>();
        }
        for (int[] conn : connections) {//统计每个节点的邻接节点
            edges[conn[0]].add(conn[1]);
            edges[conn[1]].add(conn[0]);
        }
        used=new boolean[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(!used[i]){
                dfs(i);
                ++ans;//统计连通分量个数
            }
        }
        return ans-1;
    }
    public void dfs(int u){
        used[u]=true;
        for(int v:edges[u]){
            if(!used[v]){
                dfs(v);
            }
        }
    }
}
