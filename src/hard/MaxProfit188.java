package hard;
//给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
//        设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
//        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。


import java.util.Arrays;

public class MaxProfit188 {
    //股票的买卖和保持抽象成树，采用深度遍历的方法实现
    public int maxProfit(int k,int[] prices){
        if(prices==null || prices.length==0) {
            return 0;
        }
        return dfs(0,0,0,k,prices);
    }
    //计算k次交易，index表示当前是哪天，status是买卖状态，coutnt为交易次数
    private int dfs(int index, int status, int count, int k, int[] prices) {
        if(index==prices.length || count==k) {
            return 0;
        }
        int a=0,b=0,c=0;
        //保持不动
        a = dfs(index+1,status,count,k,prices);
        if(status==1) {
            //卖一股，并将交易次数+1
            b = dfs(index+1,0,count+1,k,prices)+prices[index];
        } else {
            //买一股
            c = dfs(index+1,1,count,k,prices)-prices[index];
        }
        return Math.max(Math.max(a,b),c);
    }

    /**
     * 动态规划算法
     * 用buy[i][j]表示对于数组prices[0...i]中的价格而言，进行恰好j笔交易，并且当前手上持有一支股票，这种情况下的
     * 最大利润；用sell[i][j]表示恰好进行j笔交易，并且手上不持有股票，这种情况下的最大利润。
     * 对于buy[i][j]，我们考虑当前手上持有的股票是否是在第i天买入的，如果是第i天买入的，那么在第i-1天时，我们手上不持
     * 有股票，对应状态sell[i-1][j]，并且需要扣除prices[i]的买入花费；如果不是第i天买入的，那么在第i-1天时，我们手上
     * 持有股票，对应状态buy[i-1][j]。得到状态转移方程：
     * buy[i][j]=max{buy[i-1][j],sell[i-1][j]-prices[i]}
     * 同理对于sell[i][j]，如果第i天卖出的，那么在第i-1天时，我们手上持有股票，对应状态buy[i-1][j-1]，并且需要增加
     * prices[i]的卖出收益，如果不是第i天卖出的，那么在第i-1天时，我们手上不持有股票，对应状态sell[i-1][j],得到状态
     * 转移方程：
     *    sell[i][j]=max{sell[i-1][j],buy[i-1][j-1]+prices[i]}
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit1(int k,int[] prices){
        if(prices.length==0){
            return 0;
        }
        int n=prices.length;
        k=Math.min(k,n/2);//一买一卖算一次，所以最多只能买卖n/2次
        int[][] buy=new int[n][k+1];
        int[][] sell=new int[n][k+1];
        buy[0][0]=-prices[0];
        sell[0][0]=0;
        for(int i=1;i<=k;++i){
            buy[0][i]=sell[0][i]=Integer.MIN_VALUE/2;
        }
        for(int i=1;i<n;++i){
            buy[i][0]=Math.max(buy[i-1][0],sell[i-1][0]-prices[i]);
            for(int j=1;j<=k;++j){
                buy[i][j]=Math.max(buy[i-1][j],sell[i-1][j]-prices[i]);
                sell[i][j]=Math.max(sell[i-1][j],buy[i-1][j-1]+prices[i]);
            }
        }
        return Arrays.stream(sell[n-1]).max().getAsInt();
    }
}
