package medium;
//给你两个版本号 version1 和 version2 ，请你比较它们。
//        版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由多位数字 组成，可能包含前导零 。
//        每个版本号至少包含一个字符。修订号从左到右编号，下标从0开始，最左边的修订号下标为0 ，
//        下一个修订号下标为1,以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
//        比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较忽略任何前导零后的整数值 。
//        也就是说，修订号1和修订号001相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。
//        例如，版本 1.0 小于版本 1.1 ，因为它们下标为0的修订号相同，而下标为1的修订号分别为 0 和 1 ，0 < 1 。
//        返回规则如下：
//        如果version1>version2返回1，
//        如果version1<version2 返回 -1，
//        除此之外返回 0。


import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2021/9/1 8:50
 */
public class CompareVersion165 {
    /**
     * 按点切割，转成整数比较
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length || i < v2.length; ++i) {
            int x = 0, y = 0;
            if (i < v1.length) {
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                y = Integer.parseInt(v2[i]);
            }
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * 双指针法
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion1(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}
