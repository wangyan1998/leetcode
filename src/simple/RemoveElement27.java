package simple;

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/4/19 8:57
 */
public class RemoveElement27 {
    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int fast = 0, slow = 0;
        int n = nums.length;
        while (fast < n) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            } else {
                fast++;
            }
        }
        return slow;
    }
}
