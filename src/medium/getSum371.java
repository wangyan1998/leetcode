package medium;
//给你两个整数 a 和 b ，不使用运算符 + 和 - ，计算并返回两整数之和。
/**
 * @author wy
 * @date 2021/9/26 9:29
 */
public class getSum371 {
    /**
     * 位运算：有符号整数通常用补码来表示和存储，补码特征如下：
     * （1）正整数的补码和原码相同，负整数的补码为其原码除符号位外的所有位取反后加1
     * （2）可以将减法运算转化为补码的加法运算来实现
     * （3）符号位与数值位可以一起参与运算
     * 考虑两个二进制位相加的四种情况：
     * 0 + 0 = 0
     * 0 + 1 = 1
     * 1 + 0 = 1
     * 1 + 1 = 0 (进位)
     *可以发现对于整数a和b：
     * （1）在不考虑进位的情况下，其无进位加法的结果为a^b
     * （2）而需要进位的位为a&b，进位后结果为（a&b）<<1
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a,int b){
        while(b!=0){
            int carry=(a&b)<<1;
            a=a^b;
            b=carry;
        }
        return a;
    }
}
