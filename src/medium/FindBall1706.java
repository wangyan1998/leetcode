package medium;
//用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。
//        箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
//        将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
//        将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
//        在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两
//        块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
//        返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部
//        掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1 。


/**
 * @author wy
 * @date 2022/2/24 9:25
 */
public class FindBall1706 {
    /**
     * 分情况判断
     * @param grid
     * @return
     */
    public int[] findBall(int[][] grid){
        int n=grid[0].length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
           res[i]=Ball(grid,0,i);
        }
        return res;
    }
    public int Ball(int[][] grid,int i,int j){
        int m=grid.length;
        int n=grid[0].length;
        while(i<m){
            if(grid[i][j]==1){
                if(j==n-1||grid[i][j+1]==-1){
                    return -1;
                }else {
                    i++;
                    j++;
                }
            }else {
                if(j==0||grid[i][j-1]==1){
                    return -1;
                }else {
                    i++;
                    j--;
                }
            }
        }
        return j;
    }
}
