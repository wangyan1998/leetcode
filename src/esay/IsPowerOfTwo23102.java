package esay;
//给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
//        如果存在一个整数 x 使得n == 2^x ，则认为 n 是 2 的幂次方。


/**
 * @author wy
 * @date 2021/5/30 9:08
 */
public class IsPowerOfTwo23102 {
    /**
     * 位运算
     * 一个数是2的幂，当且仅当n是正整数，并且n的2进制表示中仅包含一个1
     * 技巧1：n&(n-1)可以得到而今之中最低为的那个1，然后判断剩下的数值是否为0即可。
     * 技巧2：n&(-n)，其中-n是n的相反数，是一个负数，该位运算技巧可以直接获取n二进制表示的最低位的1。
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n){
        return n>0&&(n&(n-1))==0;
    }
    public boolean isPowerOfTwo2(int n){
        return n>0&&(n&(-n))==n;
    }

    /**
     * 能用移位方式确定二进制中只有1个1就可以
     * @param n
     * @return
     */
    public boolean isPowerOfTwo1(int n) {
        if(n<0){
            return false;
        }
        int x=n;
        int c=0;
        while(x!=0){
            if((x&1)==1){
                c++;
            }
            x=x>>1;
        }
        if(c==1){
            return true;
        }else {
            return false;
        }
    }
}
