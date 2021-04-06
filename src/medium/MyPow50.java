package medium;
//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。


/**
 * @author wy
 * @date 2021/4/6 8:03
 */
public class MyPow50 {
    public double myPow(double x, int n) {
        if (x == 1.00000) {
            if(n>Integer.MIN_VALUE){
                return 1.0;
            }else {
                return 0.0;
            }
        }
        if (x == -1.00000) {
            if (n >= 0) {
                if (n % 2 == 1) {
                    return -1.0;
                } else {
                    return 1.0;
                }
            }else {
                return 1.0;
            }
        }
        if(n<=Integer.MIN_VALUE){
            return 0.0;
        }
        int k = Math.abs(n);
        double r = 1;
        for (int i = 0; i < k; i++) {
            r = r * x;
        }
        double res = 0;
        if (n <= 0) {
            res = 1 / r;
        } else {
            res = r;
        }
        return res;
    }

    public double myPow1(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    /**
     * 快速求幂
     * @param x
     * @param N
     * @return
     */
    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow2(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul1(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
}
