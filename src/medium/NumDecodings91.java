package medium;

//一条包含字母A-Z 的消息通过以下映射进行了 编码 ：
//        'A' -> 1
//        'B' -> 2
//        ...
//        'Z' -> 26
//        要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
//        "AAJF" ，将消息分组为 (1 1 10 6)
//        "KJF" ，将消息分组为 (11 10 6)
//        注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
//        给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
//        题目数据保证答案肯定是一个 32 位 的整数。


/**
 * @author wy
 * @date 2021/4/21 8:49
 */
public class NumDecodings91 {
    /**
     * 动态规划：
     * 分两种情况：
     * （1）如果解码是每一个数字解成一个字母，只要s[i]!=0,就可以解码成A~I中的某个字母，由于剩余的前i-1个字符的解码方法书为f(i-1),
     * 所以状态转移方程：f(i)=f(i-1),其中s[i]!=0;
     * (2)如果解码是两个数字解码成一个字母，对s[i-1]和s[i],这是有效编码情况是s[i-1]!=0,并且两位组合数要小于26
     * 转移方程为：f(i)=f(i-2),其中s[i-1]!=0并且10*s[i-1]+s[i]<=26
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }

    public int numDecodings1(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c=f[i]
        int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = 0;
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }


    public int numDecodings2(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int [] dp = new int[n];
        if(s.charAt(0) == '0') return 0;
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) != '0') dp[i] = dp[i - 1];

            if(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) < '7'){
                if (i == 1) dp[i] += 1;
                else dp[i] += dp[i - 2];
            }
        }
        return dp[n - 1];
    }
}
