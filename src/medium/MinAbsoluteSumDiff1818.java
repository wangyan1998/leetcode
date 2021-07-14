package medium;
//给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
//        数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
//        你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
//        在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 10^9 + 7 取余 后返回。
//        |x| 定义为：
//        如果 x >= 0 ，值为 x ，或者
//        如果 x <= 0 ，值为 -x

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/7/14 9:12
 */
public class MinAbsoluteSumDiff1818 {
    /**
     * 假设本来是|nums1[i]-nums2[i]|,假设使用元素nums1[j]替换了nums1[i],那么就变成了|nums1[j]-nums2[i]|
     * 改变前后的差值为|nums1[i]-nums2[i]|-|nums1[j]-nums2[i]|
     * 我们希望最大化该差值，使得答案尽可能的小。因为我们只能修改一个位置，所以我们需要检查每一个i对应的差值的最大值
     * 当i确定时，该式前半部分u去而定，而后半部分取决于j的选择，只需要找到和nums2[i]尽可能接近的nums1[j]即可。
     * 为了优化查找的时间复杂度，我们可以使用辅助数组rec记录nums1中所有元素并排序。这样就可以使用二分查找快速找到
     * nums1中尽可能接近nums2[i]的元素。注意，该元素既可能大于等于nums2[i],也可能小于nums2[i],因此需要各检查一次。
     * 使用sum记录所有差值的和，用maxn记录最大的改变前后的差值，这样答案即为sum-maxn
     * @param nums1
     * @param nums2
     * @return
     */
    public int minAbsoluteSumDiff(int[] nums1,int[] nums2){
        final int MOD = 1000000007;
        int n = nums1.length;
        int[] rec = new int[n];
        System.arraycopy(nums1, 0, rec, 0, n);
        Arrays.sort(rec);
        int sum = 0, maxn = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % MOD;
            int j = binarySearch(rec, nums2[i]);
            if (j < n) {
                maxn = Math.max(maxn, diff - (rec[j] - nums2[i]));
            }
            if (j > 0) {
                maxn = Math.max(maxn, diff - (nums2[i] - rec[j - 1]));
            }
        }
        return (sum - maxn + MOD) % MOD;
    }

    public int binarySearch(int[] rec, int target) {
        int low = 0, high = rec.length - 1;
        if (rec[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (rec[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
