package medium;
//输入一个字符串，打印出该字符串中字符的所有排列。
//        你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wy
 * @date 2021/6/22 8:19
 */
public class PermutationJZ38 {
    /**
     * 回溯法：
     * 定义递归函数backtrack(i,perm)表示当前排列为perm，下一个待填入的空位是第i个空位（下标从0开始）。那么该递归函数分两种情况：
     * （1）如果i=n,说明已经填充完了n个空位，将perm放入答案数组。
     * （2）如果i<n,此时需要考虑第i个空位填哪个字符。首先不能填充已经填过的字符，因此可以使用一个boolean数组来标记已经填过的字符。
     * 在填入第i个字符时我们遍历题目给的n个字符，如果该字符没有被填过，就可以尝试填充
     * 注：该递归会出现重复的全排列，在重复字符较多的情况下，该函数会生成大量重复的排列。
     * 一种解决办法是先生成所有的排列然后去重。
     * 另一种办法是修改递归函数，使之不会产生重复排列。
     * 只需要设定一个规则保证在填入每一个空位的时候重复的字符只会被填入一次，我们可以对原字符进行排序，保证相同的字符都相邻，在递归函数中
     * 我们限制每次填入的字符一定是这个字符所在的重复字符集合中从左往右第一个未被填入的字符。
     */
    List<String> rec;
    boolean[] vis;

    public String[] permutation(String s) {
        int n = s.length();
        rec = new ArrayList<String>();
        vis = new boolean[n];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuffer perm = new StringBuffer();
        backtrack(arr, 0, n, perm);
        int size = rec.size();
        String[] recArr = new String[size];
        for (int i = 0; i < size; i++) {
            recArr[i] = rec.get(i);
        }
        return recArr;
    }

    public void backtrack(char[] arr, int i, int n, StringBuffer perm) {
        if (i == n) {
            rec.add(perm.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                continue;
            }
            vis[j] = true;
            perm.append(arr[j]);
            backtrack(arr, i + 1, n, perm);
            perm.deleteCharAt(perm.length() - 1);
            vis[j] = false;
        }
    }
}
