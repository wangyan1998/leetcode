package medium;
//给你一个整数数组 nums ，你需要找出一个连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//        请你找出符合题意的最短子数组，并输出它的长度。

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/8/3 9:53
 */
public class FindUnsortedSubarray581 {
    /**
     * 排序，先排序，如果只需要排中间的一部分则通过排序后前半部分和后半部分是不会变的
     * 所以只要排序后找到左右边界即可。
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums){
        int[] numsCopy=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            numsCopy[i]=nums[i];
        }
        Arrays.sort(numsCopy);
        int left=0,right=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=numsCopy[i]){
               left=i;
               break;
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]!=numsCopy[i]){
                right=i;
                break;
            }
        }
        return right>left?right-left+1:0;
    }

    public int findUnsortedSubarray1(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
