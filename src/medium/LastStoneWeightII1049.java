package medium;
//有一堆石头，用整数数组stones 表示。其中stones[i] 表示第 i 块石头的重量。
//        每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：
//        如果x == y，那么两块石头都会被完全粉碎；
//        如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
//        最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。

/**
 * @author wy
 * @date 2021/6/8 8:24
 */
public class LastStoneWeightII1049 {
    /**
     * 动态规划，每个石头的重量的乘积参数只能是｛1，-1｝，我们将-1的分成一堆，1的分成一堆，两堆石头的重量之差的绝对值应该是最小的，如果能
     * 找到一种粉碎方案使得最后剩下的石头的重量是两堆之差，则这是一个合法的粉碎方案。
     * 记石头的总重量为sum，k=-1的石头重量之和为neg,k=1的石头重量之和为sum-neg，要使最后剩余的石头重量最小，也就是使得neg在不超过sum/2
     * 的前提下尽可能的大。所以问题成了背包容量为[sum/2]的背包问题
     * 设置布尔型数组dp[][],dp[i+1][j]表示前i个石头能否凑出重量j，特别的dp[0][]为不选任何石头的情况，除了dp[0][0]为真，其他的都为假
     * 对于第i个石头，考虑凑出重量j:
     * (1)若j<stones[i],则不能选第i个石头，此时有dp[i+1][j]=dp[i][j]
     * (2)若j>=stones[i],则存在选与不选两种情况，如果不选，dp[i+1][j]=dp[i][j],如果选择，需要考虑能否凑出重量j-stones[i]，
     *    即dp[i+1][j]=dp[i][j-stones]。如果两者均为假，则dp[i+1][j]为假，否则dp[i+1][j]为真。
     * 求出dp[n][]后，所有为真的dp[n][j]中，最大的j即为neg能取到的最大值，带入sum-2*neg即可得到最后一块石头的最小重量。
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones){
      int sum=0;
      for(int weight:stones){
          sum+=weight;
      }
      int n=stones.length,m=sum/2;
      boolean[][] dp=new boolean[n+1][m+1];
      dp[0][0]=true;
      for(int i=0;i<n;i++){
          for(int j=0;j<=m;j++){
              if(j<stones[i]){
                  dp[i+1][j]=dp[i][j];
              }else {
                  dp[i+1][j]=dp[i][j]||dp[i][j-stones[i]];
              }
          }
      }
      for(int j=m;;j--){
          if(dp[n][j]){
              return sum-2*j;
          }
      }
    }

    /**
     * 减少一个维度，内层循环倒序计算
     * @param stones
     * @return
     */
    public int lastStoneWeightII1(int[] stones) {
        int sum = 0;
        for (int weight : stones) {
            sum += weight;
        }
        int m = sum / 2;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int weight : stones) {
            for (int j = m; j >= weight; --j) {
                dp[j] = dp[j] || dp[j - weight];
            }
        }
        for (int j = m; ; --j) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }
    }
}
