package simple;
//给定一个整数，写一个函数来判断它是否是3的幂次方。如果是，返回 true ；否则，返回 false 。
//        整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3^x

/**
 * @author wy
 * @date 2021/9/23 8:57
 */
public class IsPowerOfThree3263 {
    /**
     * 通过循环试着除以3，能得到结果
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n){
        while(n!=0&&n%3==0){
            n/=3;
        }
        return n==1;
    }

    /**
     * 判断是否为最大3的幂的约数
     * @param n
     * @return
     */
    public boolean isPowerOfThree1(int n){
        return n>0&&1162261467%n==0;
    }
}
