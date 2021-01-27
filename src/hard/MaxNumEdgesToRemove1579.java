package hard;
//Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3 种类型的边：
//        类型 1：只能由 Alice 遍历。
//        类型 2：只能由 Bob 遍历。
//        类型 3：Alice 和 Bob 都可以遍历。
//        给你一个数组 edges ，其中 edges[i] = [typei, ui, vi]表示节点 ui 和 vi 之间存
//        在类型为 typei 的双向边。请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，
//        找出可以删除的最大边数。如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，
//        则认为图是可以完全遍历的。
//        返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。


import java.util.Arrays;

public class MaxNumEdgesToRemove1579 {
    /**
     * 并查集思想，设置两个并查集，Alice一个，Bob一个
     * 首先把公共边顶点合并，两个并查集都合并
     * 然后分别合并Alice的独占边和Bob独占边的顶点
     * 如果两个并查集最后的连通分量都是1,则说明两者都能遍历
     * 在合并边的过程中，如果两个点已经在同一个连通分量里，这条边就可以去掉
     * @param n
     * @param edges
     * @return
     */
    public int maxNumEdgesToRemove(int n,int[][] edges){
      UnionFind ufa=new UnionFind(n);
      UnionFind ufb=new UnionFind(n);
      int ans=0;
      //节点编号改为从0开始
      for(int[] edge:edges){
          --edge[1];
          --edge[2];
      }
      //公共边
      for(int[] edge:edges){
          if(edge[0]==3){
             if(!ufa.unite(edge[1],edge[2])){
                 ++ans;
             } else {
                 ufb.unite(edge[1],edge[2]);
             }
          }
      }
      //独占边
        for(int[] edge:edges){
            if(edge[0]==1){
                if(!ufa.unite(edge[1],edge[2])){
                    ++ans;
                }
            }else if(edge[0]==2){
                if(!ufb.unite(edge[1],edge[2])){
                    ++ans;
                }
            }
        }
        if(ufa.setCount!=1||ufb.setCount!=1){
            return -1;
        }
        return ans;
    }
    class UnionFind{
        int[] parent;
        int[] size;
        int n;
        int setCount;
        public UnionFind(int n){
            this.n=n;
            this.setCount=n;
            this.parent=new int[n];
            this.size=new int[n];
            Arrays.fill(size,1);
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        public int findset(int x){
            return parent[x]==x?x:(parent[x]=findset(parent[x]));
        }
        public boolean unite(int x,int y){
            x=findset(x);
            y=findset(y);
            if(x==y){
                return false;
            }
            if(size[x]<size[y]){
                int temp=x;
                x=y;
                y=temp;
            }
            parent[y]=x;
            size[x]+=size[y];
            --setCount;
            return true;
        }
        public boolean connected(int x,int y){
            x=findset(x);
            y=findset(y);
            return x==y;
        }
    }
}
