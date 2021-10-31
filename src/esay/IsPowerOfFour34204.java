package esay;
//给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
//        整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4^x


/**
 * @author wy
 * @date 2021/5/31 9:17
 */
public class IsPowerOfFour34204 {
    /**
     * 转换成四进制的过程中统计1的个数，要求必须有一个1，其他位为0
     * @param n
     * @return
     */
    public static boolean isPowerOfFour(int n){
        if(n==0){
            return false;
        }
        int count=0;
        int b=0;
        boolean res=true;
        while(n!=0){
            b=n%4;
            n=n/4;
            if(b==1){
                count++;
            }else {
                if(b!=0){
                    res=false;
                    break;
                }
            }

            if(count>1){
                res=false;
                break;
            }
        }
        return res;
    }

    /**
     * 二进制表示中1的位置，如果n是4的幂，二进制中有且仅有一个1，并且这个1出现在从低位开始的第偶个二进制位上。
     * 我们可以构造一个mask=10101010101010101010101010101010，用它和二进制数据做按位与运算，如果结果为0，表明1在偶数位上。
     * mask也可按十六进制写成aaaaaaaa
     * @param n
     * @return
     */
    public boolean isPowerOfFour1(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

    /**
     * 取模性质，如果一个数是4的幂，那么它除以3的余数一定是1
     * @param n
     * @return
     */
    public boolean isPowerOfFour2(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }
}
