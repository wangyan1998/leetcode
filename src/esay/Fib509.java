package esay;
//斐波那契数，通常用F(n) 表示，形成的序列称为 斐波那契数列 。该数列由0 和 1 开始，
//        后面的每一项数字都是前面两项数字的和。也就是：
//        F(0) = 0，F(1)= 1
//        F(n) = F(n - 1) + F(n - 2)，其中 n > 1
//        给你 n ，请计算 F(n) 。

public class Fib509 {
    /**
     * 数组形式动态规划
     * @param n
     * @return
     */
    public int fib(int n){
        if (n < 2) {
            return n;
        }
        int[] arr=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<=n;i++){
            arr[i]=arr[i-2]+arr[i-1];
        }
        return arr[n+1];
    }
    public int fib1(int n){
        if (n < 2) {
            return n;
        }
        int pre=0;
        int rea=1;
        int res=0;
        for(int i=2;i<=n;i++){
            res=pre+rea;
            pre=rea;
            rea=res;
        }
        return rea;
    }
}
