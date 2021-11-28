package competition.test_2021_11_28;

import java.util.Map;

/**
 * @author wy
 * @date 2021/11/28 11:19
 */
public class MinimumDeletions {
    public int minimumDeletions(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int max = 0,min = 0, ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[min]) min = i;
            if (nums[i] > nums[max]) max = i;
        }
        if (max < min) {
            int temp = min;
            min = max;
            max = temp;
        }
        ans = Math.min(max+1,nums.length-min);
        ans = Math.min(ans,min+1+nums.length-max);

        return ans;
    }
}
