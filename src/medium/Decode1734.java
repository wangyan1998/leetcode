package medium;
//给你一个整数数组perm，它是前n个正整数的排列，且n是个奇数。
//        它被加密成另一个长度为n-1的整数数组encoded，满足encoded[i]=perm[i] XOR perm[i + 1]。
//        比方说，如果perm = [1,3,2]，那么encoded = [2,1]。
//        给你encoded数组，请你返回原始数组perm。题目保证答案存在且唯一。

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2021/5/11 8:59
 */
public class Decode1734 {
    /**
     * 如果能得到数组的全部元素异或运算结果以及数组除了第一个元素的全部元素的异或运算结果，就可以得到数组第一个元素的值。
     * 所有元素的异或值就是1-n取异或。
     * n为奇数，除了第一个元素，还有n-1个元素，n-1是偶数，又由于数组encoded每个元素都是两个元素的异或运算结果。
     * 多疑数组encoded中存在（n-1）/2个元素，这些元素的异或运算的结果就是除了数字第一个元素以外的全部元素的运算结果。
     * 具体而言，数组 encoded 的所有下标为奇数的元素的异或运算结果即为数组 perm 除了perm[0] 以外的全部元素的异或运算结果。
     *
     * @param encoded
     * @return
     */
    public int[] decode(int[] encoded){
        int n = encoded.length + 1;
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total ^= i;
        }
        int odd = 0;
        for (int i = 1; i < n - 1; i += 2) {
            odd ^= encoded[i];
        }
        int[] perm = new int[n];
        perm[0] = total ^ odd;
        for (int i = 0; i < n - 1; i++) {
            perm[i + 1] = perm[i] ^ encoded[i];
        }
        return perm;
    }
}
