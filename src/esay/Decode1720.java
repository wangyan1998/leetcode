package esay;
//未知 整数数组 arr 由 n 个非负整数组成。
//        经编码后变为长度为 n - 1 的另一个整数数组 encoded ，
//        其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
//        给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
//        请解码返回原数组 arr 。可以证明答案存在并且是唯一的。


/**
 * @author wy
 * @date 2021/5/6 8:30
 */
public class Decode1720 {
    /**
     * 几个常用的运算：
     * 1.十进制转二进制，给定的数循环除以2，直到商为0或1为止。
     * 2.二进制转十进制，每一位一次计算2的幂，知道算出结果。
     * 3.位异或运算^，比如8^11
     * 4.位与运算&
     * 5.位或运算|
     * 6.位非运算~
     * @param encoded
     * @param first
     * @return
     */
    public int[] decode(int[] encoded,int first){
       int[] res=new int[encoded.length+1];
       res[0]=first;
       for(int i=0;i<encoded.length;i++){
           res[i+1]=encoded[i]^res[i];
       }
       return res;
    }
}
