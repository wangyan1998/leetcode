package hard;
//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//        设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
//        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。


import java.util.Arrays;

public class MaxProfit123 {
    /**
     * 动态规划：
     *见最大利润的188题
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length==0){
            return 0;
        }
        int n = prices.length;
        int k = Math.min(2, n / 2);//一买一卖算一次，所以最多只能买卖n/2次
        int[][] buy = new int[n][k+1];
        int[][] sell = new int[n][k+1];
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }
        for (int i = 1; i < n; ++i) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }
        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }

    /**
     * 动态规划：
     * 因为最多只能进行两次交易，所以在任意一天结束的时候，可能处于以下五种状态之一：
     * （1）没有进行任何操作
     * （2）只进行了一次买入操作【可能是以前买入的，也可能是今天买入的】
     * （3）只进行了一次买入操作和一次卖出操作【可以是以前卖出的，也可以是今天卖出的】
     * （4）进行了一次完整的交易，第二次只进行了一次买入操作【可以是以前买入的，也可以是今天买入的】
     * （5）进行了两次完整的交易【可以是以前卖出的，也可以是今天卖出完成第二次交易】
     * 由于第一个状态利润为0,所以只考虑后面四个状态
     * 设置四个变量buy1,sell1,buy2,sell2表示四个状态下的最大利润，四个状态的转移方程如下
     * buy1=max{buy1,-prices[i]}
     * sell1=max{sell1,buy1+prices[i]}
     * buy2=max{buy2,sell1-prices[i]}
     * sell2=max{sell2,buy2+prices[i]}
     * 最后的最大利润输出sell2就可以了
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
