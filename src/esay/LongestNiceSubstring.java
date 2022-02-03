package esay;
//当一个字符串 s包含的每一种字母的大写和小写形式同时出现在s中，就称这个字符串s是美好字符串。
//        比方说，"abABB"是美好字符串，因为'A' 和'a'同时出现了，且'B' 和'b'也同时出现了。
//        然而，"abA"不是美好字符串因为'b'出现了，而'B'没有出现。
//        给你一个字符串s，请你返回s最长的美好子字符串。如果有多个答案，请你返回最早出现的一个。
//        如果不存在美好子字符串，请你返回一个空字符串。

import java.util.HashSet;
import java.util.Set;

/**
 * @author wy
 * @date 2022/2/1 9:34
 */
public class LongestNiceSubstring {
    /**
     * 暴力搜索
     * 题目关于美好字符串的定义为: 字符串中的每个字母的大写和小写形式同时出现在该字符串中。
     * 检测时，由于英文字母‘a’−‘z’ 最多只有 2626 个, 因此可以利用二进制位来进行标记，
     * lower 标记字符中出现过小写英文字母，upper 标记字符中出现过大写英文字母。如果满
     * 足 lower=upper ，我们则认为字符串中所有的字符都满足大小写形式同时出现，则认定该
     * 字符串为美好字符串
     *
     * @param s
     * @return
     */
    public String longestNiceSubstring(String s){
        int n = s.length();
        int maxPos = 0;
        int maxLen = 0;
        for (int i = 0; i < n; ++i) {
            int lower = 0;
            int upper = 0;
            for (int j = i; j < n; ++j) {
                if (Character.isLowerCase(s.charAt(j))) {
                    lower |= 1 << (s.charAt(j) - 'a');
                } else {
                    upper |= 1 << (s.charAt(j) - 'A');
                }
                if (lower == upper && j - i + 1 > maxLen) {
                    maxPos = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(maxPos, maxPos + maxLen);
    }
}
