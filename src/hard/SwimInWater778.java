package hard;
//在一个 N x N 的坐标方格grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
//        现在开始下雨了。当时间为t时，此时雨水导致水池中任意位置的水位为t。你可以从一个平台
//        游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间
//        移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标
//        方格里面。
//        你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台(N-1, N-1)？

import java.util.*;

public class SwimInWater778 {
    /**
     * 二分查找+遍历
     * @param grid
     * @return
     */
    private int N;
    public static final int[][] DIRECTIONS={{0,1},{0,-1},{1,0},{-1,0}};
    public int swimInWater1(int[][] grid){
       this.N=grid.length;
       int left=0;
       int right=N*N-1;
       while(left<right){
           //left+right不会溢出
           int mid=(left+right)/2;
           boolean[][] visited=new boolean[N][N];
           if(grid[0][0]<=mid&&dfs(grid,0,0,visited,mid)){
               //mid可以，尝试mid小一点是不是也可以，下一轮搜索的区间[left,mid]
               right=mid;
           }else {
               left=mid+1;
           }
       }
       return left;
    }
    /**
     * 使用深度优先遍历得到从 (x, y) 开始向四个方向的所有小于等于 threshold 且与 (x, y)
     * 连通的结点
     *
     * @param grid
     * @param x
     * @param y
     * @param visited
     * @param threshold
     * @return
     */
    private boolean dfs(int[][] grid, int x, int y, boolean[][] visited, int threshold) {
        visited[x][y] = true;
        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (inArea1(newX, newY) && !visited[newX][newY] && grid[newX][newY] <= threshold) {
                if (newX == N - 1 && newY == N - 1) {
                    return true;
                }

                if (dfs(grid, newX, newY, visited, threshold)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean inArea1(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    /**
     * 广度遍历+二分查找
     * @param grid
     * @return
     */
    public int swimInWater2(int[][] grid) {
        this.N = grid.length;
        int left = 0;
        int right = N * N - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (grid[0][0] <= mid && bfs(grid, mid)) {
                // mid 可以，尝试 mid 小一点是不是也可以呢？// [left, mid]
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    /**
     * 使用广度优先遍历得到从 (x, y) 开始向四个方向的所有小于等于 threshold 且与 (x, y) 连通的结点
     *
     * @param grid
     * @param threshold
     * @return
     */
    private boolean bfs(int[][] grid, int threshold) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int x = front[0];
            int y = front[1];
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea2(newX, newY) && !visited[newX][newY] && grid[newX][newY] <= threshold) {
                    if (newX == N - 1 && newY == N - 1) {
                        return true;
                    }
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return false;
    }

    private boolean inArea2(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }


    /**
     * Dijkstra算法
     * @param grid
     * @return
     */
    public int swimInWater(int[][] grid){
        int n=grid.length;
        Queue<int[]> minHeap=new PriorityQueue<>(Comparator.comparingInt(o->grid[o[0]][o[1]]));
        minHeap.offer(new int[]{0,0});
        boolean[][] visited=new boolean[n][n];
        int[][] distTo=new int[n][n];
        for(int[] row:distTo){
            Arrays.fill(row,n*n);
        }
        distTo[0][0]=grid[0][0];
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        while(!minHeap.isEmpty()){
            //找最短的边
            int[] front=minHeap.poll();
            int currentX=front[0];
            int currentY=front[1];
            if(visited[currentX][currentY]){
                continue;
            }
            //确定最短路径顶点
            visited[currentX][currentY]=true;
            if(currentX==n-1&&currentY==n-1){
                return distTo[n-1][n-1];
            }
            //更新
            for(int[] direction:directions){
                int newX=currentX+direction[0];
                int newY=currentY+direction[1];
                if(inArea(newX,newY,n)&&!visited[newX][newY]&&Math.max(distTo[currentX][currentY],grid[newX][newY])<distTo[newX][newY]){
                    distTo[newX][newY]=Math.max(distTo[currentX][currentY],grid[newX][newY]);
                    minHeap.offer(new int[]{newX,newY});
                }
            }
        }
        return -1;
    }
    public boolean inArea(int x,int y,int n){
        return x>=0&&x<n&&y>=0&&y<n;
    }

    /**
     * 并查集：我们找的是最少等待时间，可以模拟下雨的过程，把网格抽象成一个无权图，每经过一个时刻，
     * 就考虑此时和雨水高度相等的单元格，考虑这个单元格的上、下、左、右、四个方向，并且高度更低的
     * 单元格，把它们在并查集中进行合并。
     * @param grid
     * @return
     */
    public int swimInWater3(int[][] grid) {
        this.N = grid.length;
        int len = N * N;
        // 下标：方格的高度，值：对应在方格中的坐标
        int[] index = new int[len];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                index[grid[i][j]] = getIndex(i, j);
            }
        }

        UnionFind unionFind = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            int x = index[i] / N;
            int y = index[i] % N;

            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY) && grid[newX][newY] <= i) {
                    unionFind.union(index[i], getIndex(newX, newY));
                }

                if (unionFind.isConnected(0, len - 1)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int getIndex(int x, int y) {
        return x * N + y;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private class UnionFind {

        private int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int root(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean isConnected(int x, int y) {
            return root(x) == root(y);
        }

        public void union(int p, int q) {
            if (isConnected(p, q)) {
                return;
            }
            parent[root(p)] = root(q);
        }
    }

}
