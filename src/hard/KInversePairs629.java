package hard;
//给出两个整数n和k，找出所有包含从1到n的数字，且恰好拥有k个逆序对的不同的数组的个数。
//        逆序对的定义如下：对于数组的第i个和第j个元素，如果满i<j 且 a[i]>a[j]，则其为一个逆序对；否则不是。
//        由于答案可能很大，只需要返回 答案 mod 10^9+ 7 的值。
/**
 * @author wy
 * @date 2021/11/11 9:22
 */
public class KInversePairs629 {
    public int kInversePairs(int n,int k){
        final int MOD = 1000000007;
        int[][] f = new int[2][k + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= k; ++j) {
                int cur = i & 1, prev = cur ^ 1;
                f[cur][j] = (j - 1 >= 0 ? f[cur][j - 1] : 0) - (j - i >= 0 ? f[prev][j - i] : 0) + f[prev][j];
                if (f[cur][j] >= MOD) {
                    f[cur][j] -= MOD;
                } else if (f[cur][j] < 0) {
                    f[cur][j] += MOD;
                }
            }
        }
        return f[n & 1][k];
    }
}
