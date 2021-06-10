package medium;

/**
 * @author wy
 * @date 2021/6/10 9:11
 */
public class Change518 {
    /**
     * 动态规划：dp[x]表示金额之和等于x的硬币组合数，求dp[amount];
     * 动态规划的边界是dp[0]=1.只有不选取任何硬币时，金额之和才为0；
     * 对于面额为coin的硬币，当coin<=i<=amount时，如果存在一种硬币组合的金额之和等于i-coin，则在该硬币组这种增加一个面额为coin的硬币，即可
     * 得到一种金额之和等于i的硬币组合，因此需要遍历coins,对于其中的每一种面额的硬币，更新数组dp中的每一个大于等于该面额的元素的值。
     * 初始化：dp[0]=1;
     * 遍历coins,对于其中每一个元素coin,进行如下操作：
     *    遍历i从coin到amount，将dp[i-coins]的值加到dp[i];
     *    最终得到的dp[amount]就是答案。
     * @param amount
     * @param coins
     * @return
     */
    public  int change(int amount,int[] coins){
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
