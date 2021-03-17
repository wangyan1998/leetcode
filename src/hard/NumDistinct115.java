package hard;
//给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
//        字符串的一个 子序列 是指，通过删除一些（也可以不删除）
//        字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE"是"ABCDE"的一个子序列，
//        而"AEC"不是）
//        题目数据保证答案符合 32 位带符号整数范围。


public class NumDistinct115 {
    /**
     * 动态规划思想：设s和t的长度分别是m和n
     * 首先判断极端情况，当m<n时，肯定不成立
     * 当m>=n时：创建dp，dp[i][j]表示在s[i:]的子序列t[j:]出现的个数。
     * 当j=n时，对任意0<=i<=m,dp[i][n]=1;
     * 当i=m时，对任意0<=j<=n,dp[m][j]=0;
     * 当i<m且j<n时：
     *    如果s[i]=t[j]:
     *      (1)如果s[i]和t[j]匹配，则考虑t[j+1:]作为s[i+1:]的子序列，子序列数为dp[i+1][j+1]
     *      (2)如果s[i]和t[j]不匹配，则考虑t[j:]作为s[i+1:]的子序列，子序列数为dp[i+1][j]
     *    若s[i]!=t[j]:
     *       s[i]不能和t[j]匹配，因此只能考虑t[j:]作为s[i+1:]的子序列，子序列数为dp[i+1][j]
     *       因此，当s[i]!=t[j]时，有dp[i][j]=dp[i+1][j]
     * 所以转移方程：
     * 当s[i]=t[j]时，dp[i][j]=dp[i+1][j+1]+dp[i+1][j];
     * 当s[i]!=t[j]时，dp[i][j]=dp[i+1][j];
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s,String t){
        int m=s.length(),n=t.length();
        if(m<n){
            return 0;
        }
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][n]=1;
        }
        for(int i=m-1;i>=0;i--){
            char sChar=s.charAt(i);
            for(int j=n-1;j>=0;j--){
                char tChar=t.charAt(j);
                if(sChar==tChar){
                    dp[i][j]=dp[i+1][j+1]+dp[i+1][j];
                }else {
                    dp[i][j]=dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
}
