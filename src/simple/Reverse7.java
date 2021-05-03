package simple;
//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//        如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31−1] ，就返回 0。
//        假设环境不允许存储 64 位整数（有符号或无符号）。


/**
 * @author wy
 * @date 2021/5/3 9:06
 */
public class Reverse7 {
    public static int reverse(int x){
        if(x==0){
            return 0;
        }
        int a=0;
        int res=0;
        long r=0;
        while(x!=0){
            a=x%10;
            x=x/10;
            r=r*10+a;
            if(r>Integer.MAX_VALUE||r<Integer.MIN_VALUE){
                return 0;
            }
            res=res*10+a;

        }
        return res;
    }
}
