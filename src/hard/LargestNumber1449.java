package hard;
//给你一个整数数组cost和一个整数target。请你返回满足如下规则可以得到的最大整数：
//        给当前结果添加一个数位（i + 1）的成本为cost[i]（cost数组下标从 0 开始）。
//        总成本必须恰好等于target。
//        添加的数位中没有数字 0 。
//        由于答案可能会很大，请你以字符串形式返回。
//        如果按照上述要求无法得到任何整数，请你返回 "0" 。


import java.util.Arrays;

/**
 * @author wy
 * @date 2021/6/12 9:24
 */
public class LargestNumber1449 {
    /**
     * 背包问题
     * 比较两个数的大小：位数多的整数必然大于位数小的整数，所以我们需要先计算出可以得到的整数的最大位数。
     * 这是一个背包问题，背包容量是target,物品重量为cost[i],价值为1的完全背包问题。
     * dp[i+1][j]表示使用前i个位数且花费总成本恰好为j时的最大位数，若花费总成本无法为j,则规定其为负无穷。特别的dp[0][]为不选择
     * 任何数位的状态，因此除了dp[0][0]为0，其他的都为负无穷。
     * 对于第i个数位，考虑花费总成本恰好为j时的状态转移方程：
     * （1）若j<cost[i],则无法选择第i个数位，此时有dp[i+1][j]=dp[i][j]
     * (2)若j>=cost[i]，存在选或不选两种决策，不选时有dp[i+1][j]=dp[i][j],选时由于第i个数位可以重复选择，可以从使用前i个位数
     * 且花费总成本恰好为j-cost[i]的状态转移而来，即dp[i+1][j]=dp[i+1][j-cost[i]]+1。取这两种决策的最大值。
     * dp[9][target]可以得到整数的最大位数，若小于零则表示无法得到满足要求的整数，返回“0”。否则生成一个整数，其位数为dp[9][target],
     * 且数值最大。
     * 为了生成该整数，我们可以用额外的二维数组from，在转移时记录转移来源。这样可以从最终的状态dp[9][target]顺着from不断倒推，直到达到
     * 起始状态dp[0][0]。在倒退状态时，若来源是dp[i+1][j-cost[i]]则说明我们选取了第i个数位。
     * （1）若j<cost[i],有from[i+1][j]=j;
     * (2)若j>=cost[i],当dp[i][j]>dp[i+1][j-cost[i]]+1时有from[i+1][j]=j，否则有from[i+1][j]=j-cost[i]。
     * 注意我们并没有记录转移来源是i还是 i+1，这是因为若 from[i+1][j]的值为j，则必定从i转移过来，否则必定从i+1转移过来。
     * 此外，由于我们是从最大数位乡最小数位倒退，为使生成的整数尽可能大，对于当前数位应尽可能多的选取，所以当dp[i][j]与
     * dp[i+1][j-cost[i]]+1相等时，我们选择从后者转移过来。
     * @param cost
     * @param target
     * @return
     */
    public String largestNumber(int[] cost,int target){
       int[][] dp=new int[10][target+1];
       for(int i=0;i<10;i++){
           Arrays.fill(dp[i],Integer.MIN_VALUE);
       }
       int[][] from=new int[10][target+1];
       dp[0][0]=0;
       for(int i=0;i<9;i++){
           int c=cost[i];
           for(int j=0;j<=target;j++){
               if(j<c){
                   dp[i+1][j]=dp[i][j];
                   from[i+1][j]=j;
               }else {
                   if(dp[i][j]>dp[i+1][j-c]+1){
                       dp[i+1][j]=dp[i][j];
                       from[i+1][j]=j;
                   }else {
                       dp[i+1][j]=dp[i+1][j-c]+1;
                       from[i+1][j]=j-c;
                   }
               }
           }
       }
       if(dp[9][target]<0){
           return "0";
       }
       StringBuffer sb=new StringBuffer();
       int i=9,j=target;
       while(i>0){
           if(j==from[i][j]){
               --i;
           }else {
               sb.append(i);
               j=from[i][j];
           }
       }
       return sb.toString();
    }

    /**
     * 优化版
     * @param cost
     * @param target
     * @return
     */
    public String largestNumber1(int[] cost, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int c : cost) {
            for (int j = c; j <= target; ++j) {
                dp[j] = Math.max(dp[j], dp[j - c] + 1);
            }
        }
        if (dp[target] < 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 8, j = target; i >= 0; i--) {
            for (int c = cost[i]; j >= c && dp[j] == dp[j - c] + 1; j -= c) {
                sb.append(i + 1);
            }
        }
        return sb.toString();
    }
}
