package classify.string;
//给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，
//        使最终的字符串不包含任何 连续重复 的字符。
//        注意：你不能修改非 '?' 字符。
//        题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
//        在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。
//        可以证明，在给定的约束条件下，答案总是存在的。

public class ModifyString1576 {
    /**
     * 遇到字符串的题尽量转化成字符数组来处理，这样比较好用。
     * @param s
     * @return
     */
    public String modifyString(String s){
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                //前面一个字符  如果当前是第0个的话 字符就为‘ ’
                char ahead = i == 0 ? ' ' : chars[i - 1];
                //后面一个字符  如果当前是最后一个的话 字符就为‘ ’
                char behind  = i == chars.length - 1 ? ' ' : chars[i + 1];
                //从a开始比较  如果等于前面或者后面的话 就+1
                char temp = 'a';
                while (temp == ahead || temp == behind ) {
                    temp++;
                }
                //找到目标字符后 做替换
                chars[i] = temp;
            }
        }
        return new String(chars);
    }
}
