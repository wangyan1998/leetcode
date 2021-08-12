package medium;
//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
//        子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。


/**
 * @author wy
 * @date 2021/8/12 11:00
 */
public class LongestPalindromeSubseq516 {
    /**
     * 动态规划
     * 对一个子序列来说，如果它是回文子序列，并且长度大于2，那么将它首尾两个字符去掉，它仍然是一个回文序列。
     * 用dp[i][j]表示字符串s下标范围[i,j]内的最长回文子序列的长度。假设字符串长度为n,则只有当0<=i<=j<n时，才有dp[i][j]>0,否则dp[i][j]=0.
     * 由于任何长度为1的子序列都是回文子序列，因此动态规划的边界情况是，对任意0<=i<n，都有dp[i][i]=1；
     * 当i<j时，计算dp[i][j]：
     * 如果s[i]=s[j],dp[i][j]=dp[i+1][j-1]+2.
     * 如果s[i]!=s[j],dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1])
     * 最后dp[0][n-1]就是答案。
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s){
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=n-1;i>=0;i--){
            dp[i][i]=1;
            char c1=s.charAt(i);
            for(int j=i+1;j<n;j++){
                char c2=s.charAt(j);
                if(c1==c2){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
