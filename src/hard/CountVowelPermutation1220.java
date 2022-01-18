package hard;
//给你一个整数n，请你帮忙统计一下我们可以按下述规则形成多少个长度为n的字符串：
//        #字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
//        #每个元音'a'后面都只能跟着'e'
//        #每个元音 'e' 后面只能跟着 'a' 或者是 'i'
//        #每个元'i'后面不能 再跟着另一个'i'
//        #每个元音'o'后面只能跟着'i'或者是'u'
//        #每个元音'u'后面只能跟着'a'
//        由于答案可能会很大，所以请你返回 模10^9 + 7之后的结果。

/**
 * @author wy
 * @date 2022/1/17 9:52
 */
public class CountVowelPermutation1220 {
    public int countVowelPermutation(int n){
       long mod=1000000007;
       long[] dp=new long[5];
       long[] ndp=new long[5];
       for(int i=0;i<5;i++){
           dp[i]=1;
       }
       for(int i=2;i<=n;i++){
           ndp[0]=(dp[1]+dp[2]+dp[4])%mod;
           ndp[1]=(dp[0]+dp[2])%mod;
           ndp[2]=(dp[1]+dp[3])%mod;
           ndp[3]=dp[2];
           ndp[4]=(dp[2]+dp[3])%mod;
           System.arraycopy(ndp,0,dp,0,5);
       }
       long ans=0;
       for(int i=0;i<5;i++){
           ans=(ans+dp[i])%mod;
       }
       return (int)ans;
    }
}
