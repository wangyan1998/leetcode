package hard;
//对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称k（k>=2）是 n 的一个好进制。
//        以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。

/**
 * @author wy
 * @date 2021/6/18 9:00
 */
public class SmallestGoodBase483 {
    /**
     * 数学法证明两个结论：
     * 正整数n，如果在k进制下所有数位都为1，位数为m+1位
     * 结论一：m<log(k,n)
     * 结论二：k={[取下限]m根号下n}
     * 根据结论1，可以知道m的取值范围为[1，log(k,n)),且m=1时必然有解。因为随着m的增大，k不断减小，所以我们只需要从大到小检查
     * 每一个m的可能取值，利用结论2快速计算出对应的k值，然后校验计算出的k值是否有效即可。如果k值有效， 即可返回结果。
     * @param n
     * @return
     */
    public String smallestGoodBase(String n){
        long nVal = Long.parseLong(n);
        int mMax = (int) Math.floor(Math.log(nVal) / Math.log(2));
        for (int m = mMax; m > 1; m--) {
            int k = (int) Math.pow(nVal, 1.0 / m);
            long mul = 1, sum = 1;
            for (int i = 0; i < m; i++) {
                mul *= k;
                sum += mul;
            }
            if (sum == nVal) {
                return Integer.toString(k);
            }
        }
        return Long.toString(nVal - 1);
    }
}
