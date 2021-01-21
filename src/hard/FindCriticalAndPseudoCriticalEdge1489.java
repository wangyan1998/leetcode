package hard;
//给你一个 n个点的带权无向连通图，节点编号为 0到 n-1，同时还有一个数组 edges，
//        其中 edges[i] = [fromi, toi, weighti]表示在fromi和toi节点之间有一条带权无向边。
//        最小生成树(MST) 是给定图中边的一个子集，它连接了所有节点且没有环，而且这些边的权值和最小。
//        请你找到给定图中最小生成树的所有关键边和伪关键边。
//        如果从图中删去某条边，
//        会导致最小生成树的权值和增加，那么我们就说它是一条关键边。
//        伪关键边则是可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。
//        请注意，你可以分别以任意顺序返回关键边的下标和伪关键边的下标。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindCriticalAndPseudoCriticalEdge1489 {
    /**
     * 关键边：如果最小生成树中删去某条边，会导致最小生成树的权值和增加，
     * 那么我们就说它是一条关键边。也就是说，如果设原图最小生成树的权值为
     * value，那么去掉这条边后：
     *(1)要么整个图不连通，不存在最小生成树；
     *(2)要么整个图联通，对应的最小生成树的权值为 v，其严格大于value。
     * 伪关键边：可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。
     * 也就是说，我们可以在计算最小生成树的过程中，最先考虑这条边，
     * 即最先将这条边的两个端点在并查集中合并。设最终得到的最小生成树权值为 v，
     * 如果 v = value，那么这条边就是伪关键边。
     * 需要注意的是，关键边也满足伪关键边对应的性质。因此，我们首先对原图执行Kruskal算法，
     * 得到最小生成树的权值 value，随后我们枚举每一条边，
     * 首先根据上面的方法判断其是否是关键边，如果不是关键边，再判断其是否是伪关键边。
     * @param n
     * @param edges
     * @return
     */
    public List<List<Integer>> findCriticalAndPseudoCriticalEdge(int n,int[][] edges){
       int m=edges.length;
       int[][] newEdges=new int[m][4];
       for(int i=0;i<m;i++){
           for(int j=0;j<3;j++){
               newEdges[i][j]=edges[i][j];
           }
           newEdges[i][3]=i;
       }
       Arrays.sort(newEdges, new Comparator<int[]>() {
           @Override
           public int compare(int[] u, int[] v) {
               return u[2]-v[2];
           }
       });
       //计算value
        UnionFind ufStd=new UnionFind(n);
        int value=0;
        for(int i=0;i<m;++i){
            if(ufStd.unite(newEdges[i][0],newEdges[i][1])){
                value+=newEdges[i][2];
            }
        }
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        for(int i=0;i<2;++i){
            ans.add(new ArrayList<Integer>());
        }
        for(int i=0;i<m;i++){
            //判断是否为关键边
            UnionFind uf=new UnionFind(n);
            int v=0;
            for(int j=0;j<m;++j){
                if(i!=j&&uf.unite(newEdges[j][0],newEdges[j][1])){
                    v+=newEdges[j][2];
                }
            }
            if(uf.setCount!=1||(uf.setCount==1&&v>value)){
                ans.get(0).add(newEdges[i][3]);
                continue;
            }
            //判断是否为伪关键边
            uf=new UnionFind(n);
            uf.unite(newEdges[i][0],newEdges[i][1]);
            v=newEdges[i][2];
            for(int j=0;j<m;j++){
                if(i!=j&&uf.unite(newEdges[j][0],newEdges[j][1])){
                    v+=newEdges[j][2];
                }
            }
            if(v==value){
                ans.get(1).add(newEdges[i][3]);
            }
        }
        return ans;
    }
    /*
    并查集
     */
    class UnionFind{
        int[] parent;
        int[] size;
        int n;
        //当前连通分量数目
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
        public int findSet(int x){
            return parent[x]==x?x:(parent[x]=findSet(parent[x]));
        }
        public boolean unite(int x,int y){
            x=findSet(x);
            y=findSet(y);
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
            x=findSet(x);
            y=findSet(y);
            return x==y;
        }
    }
}
