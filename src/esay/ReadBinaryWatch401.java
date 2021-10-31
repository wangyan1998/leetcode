package esay;
//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
//给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
//        小时不会以零开头：
//        例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
//        分钟必须由两位数组成，可能会以零开头：
//        例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。


import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2021/6/21 8:52
 */
public class ReadBinaryWatch401 {
    /**
     * 枚举小时和分钟：
     * 小时是从0-11，分钟是0-59 ，可以枚举小时和分钟，记录当前小时中1的个数和分钟中1的个数之和是否等于turnedOn,如果等于，就算是一种情况
     * @param turnedOn
     * @return
     */
    public List<String> readBinaryWatch(int turnedOn){
        List<String> ans = new ArrayList<String>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }
}
