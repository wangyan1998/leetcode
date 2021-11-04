package esay;
//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
//        进阶：不要 使用任何内置的库函数，如 sqrt 。


/**
 * @author wy
 * @date 2021/11/4 9:20
 */
public class IsPerfectSquare367 {
    /**
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num){
        if(num==1){
            return true;
        }
        for(int i=0;i<=num/2;i++){
            if(i*i==num){
                return true;
            }
        }
        return false;
    }

    /**
     * 公式法：在等差数列里，n^2=1+3+5+......2n-1。所以通过这个公式，循环的减1,3,5......。如果在某一个时刻值等于0说明他是完全平方数。
     * @param num
     * @return
     */
    public boolean isPerfectSquare1(int num) {
        if (num < 0)
            return false;
        for (int i = 1; num > 0; i += 2)
            num -= i;
        return 0 == num;

    }
}
