package esay;
//给你一个长度为n的整数数组，请你判断在 最多 改变1 个元素的情况下，该数组能否变成一个非递减数列。
//        我们是这样定义一个非递减数列的：对于数组中所有的i (0 <= i <= n-2)，
//        总满足 nums[i] <= nums[i + 1]。

public class CheckPossibility665 {
    public boolean checkPossibility(int[] nums){
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n - 1; ++i) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }
}
