package medium;
//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c。

/**
 * @author wy
 * @date 2021/4/28 8:25
 */
public class JudgeSquareSum633 {
    /**
     * 暴力解法
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c){
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    /**
     * 双指针法：假设a<=b。初始a=0,b=sqrt(c),进行如下操作：
     * 如果a^2+b^2=c,返回true;
     * 如果a^2+b^2<c,a++;
     * 如果a^2+b^2>c,b--;
     * 当a=b时，结束查找，此时如果还没有找到，则不存在。
     * @param c
     * @return
     */
    public boolean judgeSquareSum1(int c){
        int left=0;
        int right=(int)Math.sqrt(c);
        while(left<=right){
            int sum=left*left+right*right;
            if(sum==c){
                return true;
            }else if(sum>c){
                right--;
            }else {
                left++;
            }
        }
        return false;
    }
}
