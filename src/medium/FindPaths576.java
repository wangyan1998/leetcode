package medium;
//给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。
//        你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
//        给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。
//        因为答案可能非常大，返回对 109 + 7 取余 后的结果。


/**
 * @author wy
 * @date 2021/8/15 9:41
 */
public class FindPaths576 {
    public int count=0;
    public int MOD=1000000007;
    public int findPaths(int m,int n,int maxMove,int startRow,int startColumn){
         findPath(m,n,maxMove,startRow,startColumn);
         return count%MOD;
    }
    public void findPath(int m,int n,int maxMove,int startRow,int startColumn){
        if(maxMove==0){
            return;
        }
        if(startColumn-1<0){
            count++;
        }else {
            findPath(m,n,maxMove-1,startRow,startColumn-1);
        }
        if(startColumn+1>=n){
            count++;
        }else {
            findPath(m,n,maxMove-1,startRow,startColumn+1);
        }
        if(startRow-1<0){
            count++;
        }else {
            findPath(m,n,maxMove-1,startRow-1,startColumn);
        }
        if(startRow+1>=m){
            count++;
        }else {
            findPath(m,n,maxMove-1,startRow+1,startColumn);
        }
    }

    /**
     * 动态规划
     * @param n
     * @param m
     * @param maxMove
     * @param startRow
     * @param startCloumn
     * @return
     */
    public int findPaths1(int n,int m,int maxMove,int startRow,int startCloumn){
        final int MOD=1000000007;
        int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
        int outCounts=0;
        int[][][] dp=new int[maxMove+1][m][n];
        dp[0][startRow][startCloumn]=1;
        for(int i=0;i<maxMove;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<n;k++){
                    int count=dp[i][j][k];
                    if(count>0){
                        for(int[] direction:directions){
                            int j1=j+direction[0],k1=k+direction[1];
                            if(j1>=0&&j1<m&&k1>=0&&k1<n){
                                dp[i+1][j1][k1]=(dp[i+1][j1][k1]+count)%MOD;
                            }else {
                                outCounts=(outCounts+count)%MOD;
                            }
                        }
                    }
                }
            }
        }
        return outCounts;
    }
}
