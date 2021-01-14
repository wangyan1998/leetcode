package medium;
//在本问题中, 树指的是一个连通且无环的无向图。
//        输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。
//        附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
//        结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v]，
//        返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，
//        则返回二维数组中最后出现的边。答案边[u, v] 应满足相同的格式u < v。


import java.util.HashSet;
import java.util.Set;

public class FindRedundantConnection684 {
    /**
     * 并查集算法：
     * 树是一个连通且无环的无向图，在树中多了一条附加的边之后就会出现环，因此附加的边即为导致环出现的边。
     * 可以通过并查集寻找附加的边。初始时，每个节点都属于不同的连通分量。遍历每一条边，
     * 判断这条边连接的两个顶点是否属于相同的连通分量。
     * 如果两个顶点属于不同的连通分量，则说明在遍历到当前的边之前，这两个顶点之间不连通，
     * 因此当前的边不会导致环出现，合并这两个顶点的连通分量。
     * 如果两个顶点属于相同的连通分量，则说明在遍历到当前的边之前，这两个顶点之间已经连通，
     * 因此当前的边导致环出现，为附加的边，将当前的边作为答案返回。
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        int nodesCount = edges.length;
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < nodesCount; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}
