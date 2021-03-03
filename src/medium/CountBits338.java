package medium;
//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，
//        计算其二进制数中的 1 的数目并将它们作为数组返回。
public class CountBits338 {
    /**
     * 分为奇数和偶数，奇数一定比前面那个多一个1，也就是最末位那个1.可能会产生进位，但是，只会
     * 增加一个1.
     * 偶数一定等于它除以2的数中1的个数，除以2就是右移一个0，不影响个1的个数
     * @param num
     * @return
     */
    public int[] countBits(int num){
        int[] res=new int[num+1];
        res[0]=0;
        for(int i=1;i<=num;i++){
            if(i%2==1){
                res[i]=res[i-1]+1;
            }else {
                res[i]=res[i/2];
            }
        }
        return res;
    }
}
