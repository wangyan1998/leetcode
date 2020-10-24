package medium;

import java.util.Arrays;

public class VideoStitching {
    public int videoStitching(int[][] clips,int T){//动态规划
        int[] dp=new int[T+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0]=0;
        for(int i=1;i<=T;i++){
            for(int[] clip:clips){
                if(clip[0]<i&&i<=clip[1]){
                    dp[i]=Math.min(dp[i],dp[clip[0]]+1);
                }
            }
        }
        return dp[T]==Integer.MAX_VALUE-1?-1:dp[T];
    }
    public int videoStitching1(int[][] clips,int T){//贪心算法
        int[] maxn=new int[T];
        int last=0,ret=0,pre=0;
        for (int[] clip:clips) {
            if(clip[0]<T){
                maxn[clip[0]]=Math.max(maxn[clip[0]],clip[1]);
            }
        }
        for (int i = 0; i <T; i++) {
            last=Math.max(last,maxn[i]);
            if(i==last){
                return -1;
            }
            if(i==pre){
                ret++;
                pre=last;
            }
        }
        return ret;
    }
}
