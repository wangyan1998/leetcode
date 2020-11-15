package medium;
//给定一个以字符串表示的非负整数num，移除这个数中的 k 位数字，使得剩下的数字最小。
//        注意:
//        num 的长度小于 10002 且≥ k。
//        num 不会包含任何前导零。
//        示例 1 :
//        输入: num = "1432219", k = 3
//        输出: "1219"
//        解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class RemoveKdigits402 {
    public String removeKdigits1(String num,int k){
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();

    }
}
