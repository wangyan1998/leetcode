package medium;
//你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为m * n的网格grid进行了标注。
//        每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
//        为了使收益最大化，矿工需要按以下规则来开采黄金：
//        (1)每当矿工进入一个单元，就会收集该单元格中的所有黄金。
//        (2)矿工每次可以从当前位置向上下左右四个方向走。
//        (3)每个单元格只能被开采（进入）一次。
//        (4)不得开采（进入）黄金数目为 0 的单元格。
//        (5)矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。

/**
 * @author wy
 * @date 2022/2/5 9:07
 */
public class GetMaximumGold1219 {
    /**
     * 回溯和递归
     */
    int ans=0;
    int grid[][];
    public int getMaximumGold(int[][] grid){
        this.grid=grid;
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    dfs(i,j,0);
                }
            }
        }
        return ans;
    }
    public void dfs(int i,int j,int gold){
        if(i==-1||j==-1||i==grid.length||j==grid[0].length||grid[i][j]==0) return;
        gold+=grid[i][j];
        int g=grid[i][j];
        grid[i][j]=0;
        ans=Math.max(ans,gold);
        dfs(i+1,j,gold);
        dfs(i-1,j,gold);
        dfs(i,j+1,gold);
        dfs(i,j-1,gold);
        grid[i][j]=g;
    }
}
