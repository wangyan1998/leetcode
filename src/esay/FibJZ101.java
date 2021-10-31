package esay;
//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。
/**
 * @author wy
 * @date 2021/9/4 9:47
 */
public class FibJZ101 {
    public int fib(int n){
        int MOD=1000000007;
        if(n==0||n==1){
            return n;
        }
        int a=0,b=1;
        int res=0;
        for(int i=2;i<=n;i++){
            res=(a+b)%MOD;
            a=b;
            b=res;
        }
        return res;
    }
}
