package esay;
//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//        最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//        你可以假设除了整数0之外，这个整数不会以零开头。


/**
 * @author wy
 * @date 2021/10/21 9:19
 */
public class PlusOne66 {
    /**
     * 关键的问题是解决进位问题。
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int j = 0;
        int i = n - 1;
        for (; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                j = 1;
            } else {
                digits[i]++;
                break;
            }
        }
        if (i == -1 && j == 1) {
            int[] res = new int[n + 1];
            res[0] = 1;
            //可以不要，都是0
//            for (int k = 1; k <= n; k++) {
//                res[k] = digits[k - 1];
//            }
            return res;
        }
        return digits;
    }

    public int[] plusOne1(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}
