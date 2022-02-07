package classify.dp;
//给你一个字符串 s，找到 s 中最长的回文子串。
/**
 * @author wy
 * @date 2022/2/6 9:24
 */
public class LongestPalindrome5 {
    /**
     * 动态规划必然可以分解成子问题，而且母问题的结果和子问题递归相关。
     * 比如本题，如果一个子串是回文串，并且长度大于2,那么首尾两个字母去除后必然也是回文串；如果子串是回文串
     * 那么首尾加上相同的字母必然也是回文串。
     * 用P(i,j)表示字符串的从i到j的字母组成的字符串即s[i,j]是否为回文串：
     * P(i,j)=P(i+1,j-1)&&(s[i]==s[j])
     * 动态规划的两个重要元素，一个是递推公式，一个是边界值，下面讨论边界值
     * 本题的边界问题指的是子串长度为1或2的问题，长度为1的子串一定是回文串，长度为2的子串，只要两个字符相同
     * 就是回文串，所以边界条件是：
     * P(i,j)=true,P(i,i+1)=s[i]==s[i+1]
     * @param s
     * @return
     */
    public String longestPalindrome(String s){
        int len=s.length();
        if(len<2){
            return s;
        }
        int maxlen=1;
        int begin=0;
        boolean[][] dp=new boolean[len][len];
        //初始化，长度为1的字符串都是回文字符串
        for (int i=0;i<len;i++){
            dp[i][i]=true;
        }
        char[] charArray=s.toCharArray();
        //开始递推，枚举子字符串
        for(int L=2;L<=len;L++){
            //枚举左边界
            for(int i=0;i<len;i++){
                int j=L+i-1;
                //如果右边界越界
                if(j>=len){
                    break;
                }
                if(charArray[i]!=charArray[j]){
                    dp[i][j]=false;
                }else {
                    //长度为2的情况
                    if(j-i<3){
                        dp[i][j]=true;
                    }else {//长度大于2的情况
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                //如果dp[i][j]为true，就说明该子串是回文串，记录起始位置和长度，找到最长的
                if(dp[i][j]&&j-i+1>maxlen){
                    maxlen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }
}
