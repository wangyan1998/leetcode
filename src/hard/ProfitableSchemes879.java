package hard;
//集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
//        第i种工作会产生profit[i]的利润，它要求group[i]名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
//        工作的任何至少产生minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
//        有多少种计划可以选择？因为答案很大，所以 返回结果模10^9 + 7的值。

/**
 * @author wy
 * @date 2021/6/9 8:44
 */
public class ProfitableSchemes879 {
    /**
     * 动态规划：这个题类似于经典的背包问题，两者不同点在于，经典背包问题只有一种容量限制，而本题却有两种限制：集团员工人数上限n，以及工作利润
     * 下限minProfit
     * 三维动态规划：三个维度为当前可选择的工作，已选择的小组员工人数，以及目前状态的工作获利下限.
     * 定义三维数组dp,dp[i][j][k]表示在前i个工作中选择了j个员工，并且满足工作利润至少为k的情况下的盈利计划的总数目。假设group数组长度为len
     * 最后的答案为{sum[0->n]dp[len][i][minProfit]}
     * 新建一个数组dp[len+1][n+1][minProfit+1],初始化dp[0][0][0]=1，下面分析转移方程：
     * 对于每个工作i,我们根据当前工作人数的上限j,有能够开展当前工作和无法开展当前工作两种情况：
     * （1）如果无法开展当前工作i,dp[i][j][k]=dp[i-1][j][k]
     * （2）如果能够开展当前工作i，设当前小组人数为group[i]，工作获利profit[i],那么不考虑取模运算的情况下，则有：
     *       dp[i][j][k]=dp[i-1][j][k]+dp[i-1][j-group[i]][max(0,k-profit[i])]
     *  因为我们定义的第三维是工作利润至少为k而不是工作利润恰好为k,所以第三维是max(0,k-profit[i]),而不是k-profit[i]
     *
     * @param n
     * @param minProfit
     * @param group
     * @param profit
     * @return
     */
    public int profitableSchemes(int n,int minProfit,int[] group,int[] profit){
      int len=group.length,MOD=(int)1e9+7;
      int[][][] dp=new int[len+1][n+1][minProfit+1];
      dp[0][0][0]=1;
      for(int i=1;i<=len;i++){
          int members=group[i-1],earn=profit[i-1];
          for(int j=0;j<=n;j++){
              for(int k=0;k<=minProfit;k++){
                  if(j<members){
                      dp[i][j][k]=dp[i-1][j][k];
                  }else {
                      dp[i][j][k]=(dp[i-1][j][k]+dp[i-1][j-members][Math.max(0,k-earn)])%MOD;
                  }
              }
          }
      }
      int sum=0;
      for(int j=0;j<=n;j++){
          sum=(sum+dp[len][j][minProfit])%MOD;
      }
      return sum;
    }

    /**
     * dp[i][][]只与dp[i-1][][]有关，所以可以采用滚动数组，减少一个维度，内层循环采取倒序
     * @param n
     * @param minProfit
     * @param group
     * @param profit
     * @return
     */
    public int profitableSchemes1(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        int len = group.length, MOD = (int)1e9 + 7;
        for (int i = 1; i <= len; i++) {
            int members = group[i - 1], earn = profit[i - 1];
            for (int j = n; j >= members; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] = (dp[j][k] + dp[j - members][Math.max(0, k - earn)]) % MOD;
                }
            }
        }
        return dp[n][minProfit];
    }
}
