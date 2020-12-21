package simple;
//数组的每个索引作为一个阶梯，第i个阶梯对应着一个非负数的体力花费值cost[i](索引从0开始)。
//        每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
//        您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。


public class minCostClimbingStairs746 {
    /*
    动态规划：dp[i]表示上到i的最小花费，可以有两种选择，因为要么走一步，要么走两步，走一步的时候，从i-1开始耗费cost[i-1]
    的体力，走两步的时候从i-2开始，耗费cost[i-2]的体力，两种情况取最小值
     */
    public int minCostClimbingStairs(int[] cost){
     int n=cost.length;
     int[] dp=new int[n+1];
     dp[0]=dp[1]=0;
     for(int i=2;i<=n;++i){
         dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
     }
     return dp[n];
    }
    /*
    因为每一步只和前两个值有关，因此可以将空间复杂度优化为O(1)
     */
    public int minCostClimbingStairs1(int[] cost){
        int n=cost.length;
        int prev=0,curr=0;
        for(int i=2;i<=n;i++){
            int next=Math.min(curr+cost[i-1],prev+cost[i-2]);
            prev=curr;
            curr=next;
        }
        return curr;
    }
}
