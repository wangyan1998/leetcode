package medium;
//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
//        一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过
//        grid 的边界。
//        返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。

/**
 * @author wy
 * @date 2022/2/12 13:45
 */
public class NumEnclaves1020 {
    /**
     * 深度优先遍历：遍历四周的每一个位置，深度搜索，看能搜索到那些位置，这些能够搜索
     * 的位置不是飞地。遍历整个矩阵，不能深度搜索到的位置就是飞地，统计出其次数就行
     */
    public static int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
    private int m,n;
    private boolean[][] visited;
    public int numEnclaves(int[][] grid){
        m=grid.length;
        n=grid[0].length;
        visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            dfs(grid,i,0);
            dfs(grid,i,n-1);
        }
        for(int j=1;j<n-1;j++){
            dfs(grid,0,j);
            dfs(grid,m-1,j);
        }
        int enclaves=0;
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(grid[i][j]==1&&!visited[i][j]){
                    enclaves++;
                }
            }
        }
        return enclaves;
    }
    public void dfs(int[][] grid,int row,int col){
        if(row<0||row>=m||col<0||col>n||grid[row][col]==0||visited[row][col]){
            return;
        }
        visited[row][col]=true;
        for (int[] dir:dirs){
            dfs(grid,row+dir[0],col+dir[1]);
        }
    }
}
