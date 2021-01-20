package simple;

import java.util.Arrays;

//给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
public class MaximumProduct628 {
    /**
     * 三个数要么是三个正，要么是绝对值较大的两负一正
     * 先排序
     * （1）最大的三个负数之积
     * （2）最小的两个负数之积乘以最大的正数
     * 这两种情况取最大值
     *但是排序的时间复杂度有点高
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }

    /**
     * 一次遍历找到最小的、第二小的、最大的、第二大的、第三大的五个数
     * @param nums
     * @return
     */
    public int maximumProduct1(int[] nums){
        //最小的和第二小的
        int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
        //最大的、第二大的、第三大的
        int max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE;
        for(int x:nums){
            if(x<min1){
                min2=min1;
                min1=x;
            }else if(x<min2){
                min2=x;
            }
            if(x>max1){
                max3=max2;
                max2=max1;
                max1=x;
            }else if(x>max2){
                max3=max2;
                max2=x;
            }else if(x>max3){
                max3=x;
            }
        }
        return Math.max(min1*min2*max1,max1*max2*max3);
    }
}
