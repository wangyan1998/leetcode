package medium;
//给你一个字符数组 chars ，请使用下述算法压缩：
//        从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
//        如果这一组长度为 1 ，则将字符追加到 s 中。
//        否则，需要向 s 追加字符，后跟这一组的长度。
//        压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，
//        如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
//        请在 修改完输入数组后 ，返回该数组的新长度。
//        你必须设计并实现一个只使用常量额外空间的算法来解决此问题。


/**
 * @author wy
 * @date 2021/8/21 9:21
 */
public class Compress443 {
    /**
     * StringBuffer：没有实现常量个空间
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        int n = chars.length;
        int count = 1;
        StringBuffer s = new StringBuffer();
        s.append(chars[0]);
        for (int i = 1; i < n; i++) {
            if (chars[i] == chars[i - 1]) {
                if (i == n - 1) {
                    count++;
                    s.append(count);
                } else {
                    count++;
                }
            } else {
                if(count!=1){
                    s.append(count);
                }
                s.append(chars[i]);
                count = 1;
            }
        }

        for (int i = 0; i <s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        return s.length();
    }

    /**
     * 为了实现原地压缩，我们可以使用双指针分别标志我们在字符串中读和写的位置。每次当读指针
     * read 移动到某一段连续相同子串的最右侧，我们就在写指针 write 处依次写入该子串对应的字符和子串长度即可。
     * @param chars
     * @return
     */
    public int compress1(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
