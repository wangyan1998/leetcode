package simple;
//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
//        请注意，你可以假定字符串里不包括任何不可打印的字符。
/**
 * @author wy
 * @date 2021/10/7 9:24
 */
public class CountSegments434 {
    /**
     * 计算字符串中单词的数量，就等同于计数单词的第一个下标的个数。因此，我们只需要遍历整个字符串，统计每个单词的第一个下标的数目即可。
     * 满足单词的第一个下标有以下两个条件：
     *  （1）该下标对应的字符不为空格；
     *  （2）该下标为初始下标或者该下标的前下标对应的字符为空格；
     * @param s
     * @return
     */
    public int countSegments(String s){
        int segmentCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }
        return segmentCount;
    }
}
