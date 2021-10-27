package hard;
//给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
//        返回所有可能的结果。答案可以按 任意顺序 返回。
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wy
 * @date 2021/10/27 9:22
 */
public class RemoveInvalidParentheses301 {
    /**
     * 注意到题目中要求最少删除，这样的描述正是广度优先搜索算法应用的场景，并且题目也要求我们输出所有的结果。
     * 我们在进行广度优先搜索时每一轮删除字符串中的1个括号，直到出现合法匹配的字符串为止，此时进行轮转的次
     * 数即为最少需要删除括号的个数。
     * 我们进行广度优先搜索时，每次保存上一轮搜索的结果，然后对上一轮已经保存的结果中的每一个字符串尝试所有可
     * 能的删除一个括号的方法，然后将保存的结果进行下一轮搜索。在保存结果时，我们可以利用哈希表对上一轮生成的
     * 结果去重，从而提高效率。
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<String>();
        Set<String> currSet = new HashSet<String>();

        currSet.add(s);
        while (true) {
            for (String str : currSet) {
                if (isValid(str)) {
                    ans.add(str);
                }
            }
            if (ans.size() > 0) {
                return ans;
            }
            Set<String> nextSet = new HashSet<String>();
            for (String str : currSet) {
                for (int i = 0; i < str.length(); i ++) {
                    if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                        continue;
                    }
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                        nextSet.add(str.substring(0, i) + str.substring(i + 1));
                    }
                }
            }
            currSet = nextSet;
        }
    }

    private boolean isValid(String str) {
        char[] ss = str.toCharArray();
        int count = 0;

        for (char c : ss) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}
