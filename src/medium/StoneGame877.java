package medium;
//亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子piles[i]。
//        游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
//        亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。
//        这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
//        假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回true，当李赢得比赛时返回false。


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wy
 * @date 2021/6/16 8:40
 */
public class StoneGame877 {
    /**
     * 动态规划：
     * 由于每次只能从行的开始或结束处取走整堆石子，因此可以保证剩下的石子堆一定是连续的。
     * 定义二维数组dp，行数和列数都等于石子的堆数，dp[i][j]表示当剩下的石子堆为下标i到下标j时，当前玩家
     * 与另一玩家的石子数量差的最大值，注意当前玩家不一定是先手Alex
     * 只有当i<=j，剩下的石子才有意义，因此当i>j时，dp[i][j]=0.
     * 当i=j时，只剩下一堆石子，当前玩家只能取走这堆石子，因此对于所有0<=i<nums.length，都有dp[i][i]=piles[i]。
     * 当i<j时，当前玩家可以选择取走piles[i]或者piles[j]，然后轮到另一玩家再剩下的石子堆中取走石子。
     * 在两种方案中，当前玩家会选择最优的方案，使自己的狮子数量最大化：
     *   dp[i][j]=max(piles[i]-dp[i+1][j],piles[j]-dp[i][j-1])
     * 最后判断dp[0][piles.length-1]的值是否大于零，如果大于0，则Alex的狮子数量大于Lee的石子数量，因此Alex赢得比赛，否则Lee赢得比赛
     * @param piles
     * @return
     */
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;
    }

    /**
     * 优化版
     * @param piles
     * @return
     */
    public boolean stoneGame1(int[] piles) {
        int length = piles.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
            }
        }
        return dp[length - 1] > 0;
    }

    /**
     * 可以用数学证明，Alex 只要选择取走数量更多的一组石子即可。因此，\text{Alex}Alex 总是可以赢得比赛。
     * @param piles
     * @return
     */
    public boolean stoneGame2(int[] piles) {
        return true;
    }
}
