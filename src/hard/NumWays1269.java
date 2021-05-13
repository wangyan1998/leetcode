package hard;
//有一个长度为arrLen的数组，开始有一个指针在索引0 处。
//        每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
//        给你两个整数steps 和arrLen ，请你计算并返回：在恰好执行steps次操作以后，指针仍然指向索引0 处的方案数。
//        由于答案可能会很大，请返回方案数 模10^9 + 7 后的结果。

/**
 * @author wy
 * @date 2021/5/13 8:52
 */
public class NumWays1269 {
    /**
     * 动态规划：dp[i][j]表示在i步操作之后，指针位于下标j的方案数。其中0<=i<=steps,j的取值范围为0<=j<=arrlen-1.
     * 由于执行了steps步操作，因此指针所在下标一定不会超过steps,所以j的范围可以缩小：0<=j<=min(arrlen-1,steps)。
     * 边界条件：dp[0][0]=1,当1<=j<=min(arrlen-1,steps),dp[0][j]=0。
     * 每一步操作指针可以向左、向右、移动一步，或者停在原地。所以1<=i<=steps时，dp[i][j]可以从dp[i-1][j-1]、dp[i-1][j]
     * 、dp[i-1][j+1],所以转移方程如下：
     *            dp[i][j]=dp[i-1][j-1]+dp[i-1][j]+dp[i-1][j+1]。
     *    当j=0时，dp[i-1][j-1]=0;当j=min(arrlen-1,steps)时，dp[i-1][j+1]=0。
     * @param steps
     * @param arrlen
     * @return
     */
    public int numWays(int steps,int arrlen){
       final int MODULO=1000000007;
       int maxColumn=Math.min(arrlen-1,steps);
       int[][] dp=new int[steps+1][maxColumn+1];
       dp[0][0]=1;
       for(int i=1;i<=steps;i++){
           for(int j=0;j<=maxColumn;j++){
               dp[i][j]=dp[i-1][j];
               if(j-1>=0){
                   dp[i][j]=(dp[i][j]+dp[i-1][j-1])%MODULO;
               }
               if(j+1<=maxColumn){
                   dp[i][j]=(dp[i][j]+dp[i-1][j+1])%MODULO;
               }
           }
       }
       return dp[steps][0];
    }

    public int numWays1(int steps, int arrLen) {
        final int MODULO = 1000000007;
        int maxColumn = Math.min(arrLen - 1, steps);
        int[] dp = new int[maxColumn + 1];
        dp[0] = 1;
        for (int i = 1; i <= steps; i++) {
            int[] dpNext = new int[maxColumn + 1];
            for (int j = 0; j <= maxColumn; j++) {
                dpNext[j] = dp[j];
                if (j - 1 >= 0) {
                    dpNext[j] = (dpNext[j] + dp[j - 1]) % MODULO;
                }
                if (j + 1 <= maxColumn) {
                    dpNext[j] = (dpNext[j] + dp[j + 1]) % MODULO;
                }
            }
            dp = dpNext;
        }
        return dp[0];
    }
}
