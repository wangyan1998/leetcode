package medium;
//给你一个整数数组 nums 和两个整数k 和 t 。请你判断是否存在两个下标 i 和 j，使得abs(nums[i] - nums[j]) <= t ，
//        同时又满足 abs(i - j) <= k 。
//        如果存在则返回 true，不存在返回 false。

import java.util.TreeSet;

/**
 * @author wy
 * @date 2021/4/17 9:32
 */
public class ContainsNearbyAlmostDuplicate220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
