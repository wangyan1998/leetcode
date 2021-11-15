package esay;
//我们定义，在以下情况时，单词的大写用法是正确的：
//        全部字母都是大写，比如 "USA" 。
//        单词中所有字母都不是大写，比如 "leetcode" 。
//        如果单词不只含有一个字母，只有首字母大写，比如"Google" 。
//        给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。


/**
 * @author wy
 * @date 2021/11/13 9:51
 */
public class DetectCapitalUse520 {
    /**
     * 分情况判断，合理的情况只有三种：全部大写，全部小写，首字母大写
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        char[] w = word.toCharArray();
        if (w.length == 1) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < w.length; i++) {
            if ('A' <= w[i] && w[i] <= 'Z') {
                count++;
            }
        }
        if (count == 0) {
            return true;
        } else {
            if ('A' <= w[0] && w[0] <= 'Z') {
                if (count == w.length || count == 1) {
                    return true;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
    }

    public boolean detectCapitalUse1(String word) {
        // 若第 1 个字母为小写，则需额外判断第 2 个字母是否为小写
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }

        // 无论第 1 个字母是否大写，其他字母必须与第 2 个字母的大小写相同
        for (int i = 2; i < word.length(); ++i) {
            if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1))) {
                return false;
            }
        }
        return true;
    }
}
