package medium;
//给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
//数据保证对于给定的 k ，一定能找到可行解。1 <= k <= 10^9
/**
 * @author wy
 * @date 2022/2/3 9:14
 */
public class FindMinFibonacciNumbers1414 {
    public int findMinFibonacciNumbers(int k){
         int res=0;
         while(k!=0){
             k=k-getFibonacci(k);
             res++;
         }
         return res;
    }
    public int getFibonacci(int k){
        int a=1,b=1;
        int temp;
        while(b<=k){
            temp=a+b;
            a=b;
            b=temp;
        }
        return a;
    }

}
