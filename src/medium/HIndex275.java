package medium;
//给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列。编写一个方法，计算出研究者的 h 指数。
//        h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有
//        h 篇论文分别被引用了至少 h 次。（其余的N - h篇论文每篇被引用次数不多于 h 次。）"


/**
 * @author wy
 * @date 2021/7/12 9:17
 */
public class HIndex275 {
    public int hIndex(int[] citations){
        int h=0,i=citations.length-1;
        while(i>=0&&citations[i]>h){
            h++;
            i--;
        }
        return h;
    }

    /**
     * 已经排好序的可以使用二分查找
     * @param citations
     * @return
     */
    public int hIndex1(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }
}
