package hard;
//有台奇怪的打印机有以下两个特殊要求：
//        打印机每次只能打印由 同一个字符 组成的序列。
//        每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
//        给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。


/**
 * @author wy
 * @date 2021/5/24 9:13
 */
public class StrangePrinter664 {
    /**
     *动态规划：令f[i][j]白送hi打印完成区间[i,j]的最少操作数
     * 当我们尝试计算f[i][j]时：
     * (1)s[i]=s[j]，即区间两端的字符串相同，那么当我们打印左侧字符串s[i]时，可以顺便打印右侧字符s[j],这样我们可以忽略右侧字符对该区间
     *    的影响，只需要考虑如何尽快的打印完[i,j-1]即可，此时f[i][j]=f[i][j-1]
     * (2)s[i]!=s[j],即区间两端的字符不同，那么我们需要分别完成该区间的左右两部分的打印。记两部分分别为区间[i,k]和[k+1,j]，此时
     *     f[i][j]=min(f[i][k]+f[k+1][j])，其中i<=k<=j-1;
     * @param s
     * @return
     */
    public int strangePrinter(String s){
      int n=s.length();
      int[][] f=new int[n][n];
      for(int i=n-1;i>=0;i--){
          f[i][i]=1;
          for(int j=i+1;j<n;j++){
              if(s.charAt(i)==s.charAt(j)){
                  f[i][j]=f[i][j-1];
              }else {
                  int minn=Integer.MAX_VALUE;
                  for(int k=i;k<j;k++){
                      minn=Math.min(minn,f[i][k]+f[k+1][j]);
                  }
                  f[i][j]=minn;
              }
          }
      }
      return f[0][n-1];
    }
}
