package medium;
//给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；非负整数fee 代表了交易股票的手续费用。
//        你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
//        返回获得利润的最大值。
//        注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。

public class MaxProfit714 {
    /*
    动态规划，每天交易结束后有两种状态：手里有股票和手里没有股票
    定义dp[i][0]表示第i天手里没有股票的情况下的最大利润，dp[i][1]表示第i天手里有股票的情况下的最大利润
    考虑转移方程：
    dp[i][0],如果这一天交易完手里没有股票，分两种情况：
    (1)前一天没有股票dp[i-1][0]
    (2)前一天有股票dp[i-1][1],这是需要将其卖出，并获得prices[i]的收益，并支付fee的手续费
    所以综上：dp[i][0]=max{dp[i-1][0],dp[i-1][1]+prices[i]-fee}
    dp[i][1]，如果这一天建议玩手中有股票，分两种情况：
    (1)前一天没有股票,需要买入，并减少prices[i]的收益
    (2)前一天有股票
    综上：dp[i][1]=max{dp[i-1][1],dp[i-1][0]-prices[i]}
    对于初始状态，第0天交易结束，dp[0][0]=0,dp[0][1]=-prices[0]
     */
    public int maxProfit714(int[] prices,int fee){
        int n=prices.length;
        int[][] dp=new int[n][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }
    /*
    我们会发现，dp[i][0]和dp[i][1]的值只和dp[i-1][0]和dp[i-1][1]有关，所以我们只需要两个变量存储一下就可以了
     */
    public int maxProfit1(int[] prices,int fee){
        int n=prices.length;
        int sell=0,buy=-prices[0];
        for(int i=0;i<n;i++){
            sell=Math.max(sell,buy+prices[i]-fee);
            buy=Math.max(buy,sell-prices[i]);
        }
        return sell;
    }
}
