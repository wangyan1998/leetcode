package medium;
//你准备参加一场远足活动。给你一个二维rows x columns的地图heights，
//        其中heights[row][col]表示格子(row, col)的高度。一开始你在最左上角的格子(0, 0)，
//        且你希望去最右下角的格子(rows-1, columns-1)（注意下标从 0 开始编号）。
//        你每次可以往 上，下，左，右四个方向之一移动，你想要找到耗费体力最小的一条路径。
//        一条路径耗费的 体力值是路径上相邻格子之间 高度差绝对值的最大值决定的。
//        请你返回从左上角走到右下角的最小体力消耗值。


import java.util.*;

public class MinimumEffortPath1631 {
    /**
     * 并查集的思想，把每一个数当成一个结点，我们将这 mnmn 个节点放入并查集中，实时维护它们的连通性。
     * 由于我们需要找到从左上角到右下角的最短路径，因此我们可以将图中的所有边按照权值从小到大进行排序，
     * 并依次加入并查集中。当我们加入一条权值为 x的边之后，如果左上角和右下角从非连通状态变为连通
     * 状态，那么 x 即为答案。
     * @param heights
     * @return
     */
    public int minimumEffortPath(int[][] heights){
        int m = heights.length;
        int n = heights[0].length;
        List<int[]> edges = new ArrayList<int[]>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int id = i * n + j;
                if (i > 0) {
                    edges.add(new int[]{id - n, id, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
                if (j > 0) {
                    edges.add(new int[]{id - 1, id, Math.abs(heights[i][j] - heights[i][j - 1])});
                }
            }
        }
        Collections.sort(edges, new Comparator<int[]>() {
            public int compare(int[] edge1, int[] edge2) {
                return edge1[2] - edge2[2];
            }
        });

        UnionFind uf = new UnionFind(m * n);
        int ans = 0;
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], v = edge[2];
            uf.unite(x, y);
            if (uf.connected(0, m * n - 1)) {
                ans = v;
                break;
            }
        }
        return ans;
    }
}

// 并查集模板
class UnionFind {
    int[] parent;
    int[] size;
    int n;
    // 当前连通分量数目
    int setCount;

    public UnionFind(int n) {
        this.n = n;
        this.setCount = n;
        this.parent = new int[n];
        this.size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public int findset(int x) {
        return parent[x] == x ? x : (parent[x] = findset(parent[x]));
    }

    public boolean unite(int x, int y) {
        x = findset(x);
        y = findset(y);
        if (x == y) {
            return false;
        }
        if (size[x] < size[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        parent[y] = x;
        size[x] += size[y];
        --setCount;
        return true;
    }

    public boolean connected(int x, int y) {
        x = findset(x);
        y = findset(y);
        return x == y;
    }
}
