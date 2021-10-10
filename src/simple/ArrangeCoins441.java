package simple;
//你总共有n枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
//        给你一个数字n ，计算并返回可形成 完整阶梯行 的总行数。


/**
 * @author wy
 * @date 2021/10/10 9:30
 */
public class ArrangeCoins441 {
    public int arrangeCoins(int n){
        int i=1;
        while(n>=0){
            n-=i;
            i++;
        }
        return i-2;
    }
}
