package esay;
//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
//0 <= num <= 2^31 - 1

/**
 * @author wy
 * @date 2022/3/3 8:55
 */
public class AddDigits {
    /**
     * 暴力
     * @param num
     * @return
     */
    public int addDigits(int num){
        while (num>9){
            num=getNum(num);
        }
        return num;
    }
    public int getNum(int num){
        int res=0;
        while(num!=0){
            res+=num%10;
            num/=10;
        }
        return res;
    }
}
