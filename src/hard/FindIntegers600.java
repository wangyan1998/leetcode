package hard;
//给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含连续的1的个数。

/**
 * @author wy
 * @date 2021/9/11 8:44
 */
public class FindIntegers600 {
    /**
     * 动态规划
     * @param n
     * @return
     */
    public int findIntegers(int n){
       int[] dp=new int[31];
       dp[0]=dp[1]=1;
       for(int i=2;i<31;i++){
           dp[i]=dp[i-1]+dp[i-2];
       }
       int pre=0,res=0;
       for(int i=29;i>=0;i--){
           int val=1<<i;
           if((n&val)!=0){
               n-=val;
               res+=dp[i+1];
               if(pre==1){
                   break;
               }
               pre=1;
           }else {
               pre=0;
           }
           if(i==0){
               res++;
           }
       }
       return res;
    }
}
