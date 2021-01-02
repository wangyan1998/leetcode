package hard;
//给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
//        你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
//        返回滑动窗口中的最大值。

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSlidingWindow239 {
    /**
     * 优先队列的方法，记录索引值判断最大值是否在滑动窗口内的思想很重要。
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums,int k){
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}
