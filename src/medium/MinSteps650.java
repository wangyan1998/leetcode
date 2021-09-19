package medium;
//最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
//        Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
//        Paste（粘贴）：粘贴 上一次 复制的字符。
//        给你一个数字n ，你需要使用最少的操作次数，在记事本上输出 恰好n个 'A' 。返回能够打印出n个 'A' 的最少操作次数。


import java.util.Map;

/**
 * @author wy
 * @date 2021/9/19 9:18
 */
public class MinSteps650 {
    /**
     * 动态规划：如果要得到i个A，必须先存在j个A，这样通过复制和多次粘贴得到i个A，则j必须是i的因子
     * 粘贴的操作次数为i/j-1。状态转移方程为：
     *      f[i]=min(j|i){f[i]+i/j}
     * 其中j|i表示j是i的因子
     * 边界条件是f[1]=0,最后的答案是f[n]。
     * 在枚举i的因子的时候只要从小于sqrt(i)枚举就可以了，因为j和i/j是一对因子，可以互换
     * @param n
     * @return
     */
    public int minSteps(int n){
        int[] f=new int[n+1];
        for(int i=2;i<=n;i++){
            f[i]=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                if(i%j==0){
                    f[i]=Math.min(f[i],f[j]+i/j);
                    f[i]=Math.min(f[i],f[i/j]+j);
                }
            }
        }
        return f[n];
    }
}
