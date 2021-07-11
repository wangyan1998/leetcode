package medium;
//给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h指数。
//        h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）
//        总共有 h 篇论文分别被引用了至少 h 次。且其余的N - h篇论文每篇被引用次数不超过 h 次。
//        例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。


import java.util.Arrays;

/**
 * @author wy
 * @date 2021/7/11 10:44
 */
public class HIndex274 {
    /**
     * 排序：由H指数的定义，如果当前H指数为h并且在遍历过程中找到当前值citations[i]>h,说明我们找到了一篇被引用了至少h+1次的论文，
     * 所以现有的h+1,继续遍历直到h值无法继续增大，最后返回h作为最终答案。
     * @param citations
     * @return
     */
    public int hIndex(int[] citations){
        Arrays.sort(citations);
        int h=0,i=citations.length-1;
        while(i>=0&&citations[i]>h){
            h++;
            i--;
        }
        return h;
    }

    /**
     * 计数排序
     * @param citations
     * @return
     */
    public int hIndex1(int[] citations) {
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            tot += counter[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }
}
