package simple;
//463
public class IsLandPerimeter {
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};

    /**
     * 迭代，对于每一个陆地格子，看其四个方向是不是边界或者水域，如果是，贡献一条边
     * @param grid
     * @return
     */
    public int isLandPerimeter(int[][] grid){
      int n=grid.length,m=grid[0].length;
      int ans=0;
      for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
              if(grid[i][j]==1){
                  int cnt=0;
                  for(int k=0;k<4;k++){
                      int tx=i+dx[k];
                      int ty=j+dy[k];
                      if(tx<0||tx>=n||ty<0||ty>=m||grid[tx][ty]==0){
                          cnt+=1;
                      }
                  }
                  ans+=cnt;
              }
          }
      }
      return ans;
    }

    /**
     * 深度优先搜索
     * @param grid
     * @return
     */
    public int isLandPerimeter1(int[][] grid){
       int n=grid.length,m=grid[0].length;
       int ans=0;
       for(int i=0;i<n;++i){//遍历每一个格子
           for(int j=0;j<m;++j){
               ans+=dfs(i,j,grid,n,m);
           }
       }
       return ans;
    }
    public int dfs(int x,int y,int[][] grid,int n,int m){
        if(x<0||x>=n||y<0||y>=m||grid[x][y]==0){
            return 1;
        }
        if(grid[x][y]==2){
            return 0;
        }
        grid[x][y]=2;//标记该陆地格子已经遍历过
        int res=0;
        for(int i=0;i<4;++i){
            int tx=x+dx[i];
            int ty=y+dy[i];
            res+=dfs(tx,ty,grid,n,m);
        }
        return res;
    }
}
