package medium;
//给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
//        形式上，斐波那契式序列是一个非负整数列表 F，且满足：
//        (1) 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
//        (2) F.length >= 3；
//        (3) 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
//        另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
//        返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。

import java.util.ArrayList;
import java.util.List;

public class SplitIntoFibonacci842 {
    /*回溯+剪枝：使用列表存储拆分出的数，回溯过程中维护该列表的元素，列表初始为空。遍历字符串所有可能的前缀，作为当前被拆分出的数
    ，然后对剩余部分继续拆分。
    回溯过程中有三处可以剪枝：
    （1）拆分出的数如果不是0，则不能以0开头，因此如果字符串剩下的部分以0开头，就不需要靠拆分出长度大于1的数，因为长度大于1的数以0
    开头是不符合要求的，不可能继续拆分得到斐波那契序列
    （2）拆分出的数必须符合32位有符号整数类型，即每个数必须在[0,2^31-1]的范围内，如果拆分出的数大于最大值，则不符合要求，长度更大
    的数值也一定更大，也一定大于最大值，也就更不可能拆分出来
    （3）如果列表中至少有2个数，并且拆分出的数已经大于最后2个数的和，那就不要继续拆分了
    整个字符串拆分完毕，如果列表中至少有3个数，得到一个符合要求的斐波那契序列
    */
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<Integer>();
        backtrack(list, S, S.length(), 0, 0, 0);
        return list;
    }

    public boolean backtrack(List<Integer> list, String S, int length, int index, int sum, int prev) {
        if (index == length) {
            return list.size() >= 3;
        }
        long currLong = 0;
        for (int i = index; i < length; i++) {
            if (i > index && S.charAt(index) == '0') {
                break;
            }
            currLong = currLong * 10 + S.charAt(i) - '0';
            if (currLong > Integer.MAX_VALUE) {
                break;
            }
            int curr = (int) currLong;
            if (list.size() >= 2) {
                if (curr < sum) {
                    continue;
                } else if (curr > sum) {
                    break;
                }
            }
            list.add(curr);
            if (backtrack(list, S, length, i + 1, prev + curr, curr)) {
                return true;
            } else {
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

}
