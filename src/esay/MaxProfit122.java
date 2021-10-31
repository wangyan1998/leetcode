package esay;
//给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。
//        设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
public class MaxProfit122 {
    public int maxProfit(int[] prices){
        //动态规划，定义状态 dp[i][0]表示第i天交易完后手里没有股票的最大利润，dp[i][1]表示第i天交易完后手里持有一支股票的最大利润（i从0开始）。
      int n=prices.length;
      int[][] dp=new int[n][2];
      dp[0][0]=0;
      dp[0][1]=-prices[0];
      for(int i=1;i<n;i++){
          dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
          dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
      }
      return dp[n-1][0];
    }
    //由于每一天的状态只与前一天的状态有关，而与更早的状态都无关，因此我们不必存储这些无关的状态，只需要将dp[i-1][0]和dp[i-1][1]两个变量就好了
    public int maxProfit1(int[] prices){
        int n=prices.length;
        int dp0=0,dp1=-prices[0];
        for(int i=1;i<n;i++){
            int newdp0=Math.max(dp0,dp1+prices[i]);
            int newdp1=Math.max(dp1,dp0-prices[i]);
            dp0=newdp0;
            dp1=newdp1;
        }
        return dp0;
    }
    //贪心算法：问题可以等价为寻找x个不相交的区间（i,j）使得所有区间的价格差p[j]-p[i]的总和最大
    public int maxProfit2(int[] prices){
        int ans=0;
        int n=prices.length;
        for(int i=0;i<n;i++){
            ans+=Math.max(0,prices[i]-prices[i-1]);
        }
        return ans;
    }
}

