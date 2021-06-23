package simple;
//请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
//        例如，把 9表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。


/**
 * @author wy
 * @date 2021/6/23 8:23
 */
public class HammingWeightJZ15 {
    public int hammingWeight(int n){
        int res=0;
        while(n!=0){
            if((n&1)==1){
                res++;
            }
            n=n>>1;
        }
        return res;
    }
    public int hammingWeight1(int n){
        return Integer.bitCount(n);
    }
    public int hammingWeight2(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
    public int hammingWeight3(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
