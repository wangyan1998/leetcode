package esay;
//给你一个字符串 s ，根据下述规则反转字符串：
//        所有非英文字母保留在原有位置。
//        所有英文字母（小写或大写）位置反转。
//        返回反转后的 s 。
//        1 <= s.length <= 100
//        s 仅由 ASCII 值在范围 [33, 122] 的字符组成
//        s 不含 '\"' 或 '\\'

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wy
 * @date 2022/2/23 9:37
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                deque.push(c);
            }
        }
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                res.append(deque.pop());
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
