package medium;
//给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
//        现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
//        花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
//        请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。


/**
 * @author wy
 * @date 2021/5/9 9:31
 */
public class MinDays1482 {
    /**
     * 二分查找
     * @param bloomDay
     * @param m
     * @param k
     * @return
     */
    public int minDays(int[] bloomDay,int m,int k){
        if (k * m > bloomDay.length) {
            return -1;
        }
        int low = 1, high = 1;
        int length = bloomDay.length;
        for (int i = 0; i < length; i++) {
            high = Math.max(high, bloomDay[i]);
        }
        while (low < high) {
            int days = (high - low) / 2 + low;
            if (canMake(bloomDay, days, m, k)) {
                high = days;
            } else {
                low = days + 1;
            }
        }
        return low;
    }

    public boolean canMake(int[] bloomDay, int days, int m, int k) {
        int bouquets = 0;
        int flowers = 0;
        int length = bloomDay.length;
        for (int i = 0; i < length && bouquets < m; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
