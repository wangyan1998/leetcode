package hard;
//给定一个已排序的正整数数组 nums，和一个正整数n 。从[1, n]区间内选取任意个数字补充到nums中，
//使得[1, n]区间内的任何数字都可以用nums中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。

public class MinPatches330 {
    /**
     * 贪心算法：对于正整数 xx，如果区间 [1,x-1] 内的所有数字都已经被覆盖，且 x 在数组中，
     * 则区间 [1,2x-1]内的所有数字也都被覆盖。假设数字 xx 缺失，则至少需要在数组中补充一个
     * 小于或等于 x 的数，才能覆盖到 x，否则无法覆盖到 x。如果区间 [1,x-1] 内的所有数字都已经被覆盖，
     * 则从贪心的角度考虑，补充 x 之后即可覆盖到 x，且满足补充的数字个数最少。在补充 x 之后，区间
     * [1,2x-1] 内的所有数字都被覆盖，下一个缺失的数字一定不会小于 2x。
     * 由此可以提出一个贪心的方案。每次找到未被数组 nums 覆盖的最小的整数 x，在数组中补充 x，然后寻找
     * 下一个未被覆盖的最小的整数，重复上述步骤直到区间 [1,n]中的所有数字都被覆盖。
     *
     * @param nums
     * @param n
     * @return
     */
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long x = 1;
        int length = nums.length, index = 0;
        while (x <= n) {
            if (index < length && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {//如果x<=n,且找到一个未覆盖的数字，添加一个
                x *= 2;
                patches++;
            }
        }
        return patches;
    }
}
