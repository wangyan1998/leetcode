package medium;
//有 n 个城市通过一些航班连接。给你一个数组flights ，其中flights[i] = [fromi, toi, pricei] ，
//        表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
//        现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k站中转的路线,
//        使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/8/24 9:43
 */
public class FindCheapestPrice787 {
    /**
     * 动态规划：用f[t][i]表示通过恰好t次航班，从出发城市src到达城市i需要的最小花费。在进行状态转移的时候，我们可以
     * 枚举最后一次航班的起点j,即：
     *     f[t][i]=min【(j,i)属于flights】{f[t-1][j]+cost(j,i)}
     * 由于最多只能中转k次，也就是最多搭乘k+1次航班，所以最终的答案即为：
     *   f[1][dst],f[2][dst],......f[k+1][dst]中的最小值。
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPrice(int n,int[][] flights,int src,int dst,int k){
        final int INF=10000*101+1;
        int[][] f=new int[k+2][n];
        for(int i=0;i<k+2;i++){
            Arrays.fill(f[i],INF);
        }
        f[0][src]=0;
        for(int t=1;t<=k+1;++t){
            for(int[] flight:flights){
                int j=flight[0],i=flight[1],cost=flight[2];
                f[t][i]=Math.min(f[t][i],f[t-1][j]+cost);
            }
        }
        int ans=INF;
        for(int t=1;t<=k+1;++t){
            ans=Math.min(ans,f[t][dst]);
        }
        return ans==INF? -1:ans;
    }

    public int findCheapestPrice1(int n,int[][] flights,int src,int dst,int k){
        final int INF=10000*101+1;
        int[] f=new int[n];
        Arrays.fill(f,INF);
        f[src]=0;
        int ans=INF;
        for(int t=1;t<=k+1;++t){
            int[] g=new int[n];
            Arrays.fill(g,INF);
            for(int[] flight:flights){
                int j=flight[0],i=flight[1],cost=flight[2];
                g[i]=Math.min(g[i],f[j]+cost);
            }
            f=g;
            ans=Math.min(ans,f[dst]);
        }
        return ans==INF?-1:ans;
    }
}
