package competition.test_2021_9_26;
//给你一个下标从 0 开始的整数数组 nums ，该数组的大小为 n ，请你计算 nums[j]-nums[i] 能求得的最大差值 ，
//        其中 0 <=i<j<n 且nums[i] < nums[j] 。
//        返回 最大差值 。如果不存在满足要求的 i 和 j ，返回 -1 。


/**
 * @author wy
 * @date 2021/9/26 10:32
 */
public class MaximumDifference {
    public int maximumDifference(int[] nums){
        int n=nums.length;
        int max=-1;
        for(int j=0;j<n;j++){
            for(int i=0;i<j;i++){
                if(nums[i]<nums[j]){
                    max=Math.max(max,nums[j]-nums[i]);
                }
            }
        }
        return max;
    }

    /**
     * 一次循环，用min暂存最小值，max暂存最大差值，只需要遍历一次数组即可。
     * @param nums
     * @return
     */
    public int maximumDifference1(int[] nums){
        int max=0;
        int min=nums[0];
        for(int i=1;i<nums.length;i++){
            int temp=nums[i]-min;
            min=Math.min(min,nums[i]);
            if(temp>0&&temp>max){
                max=temp;
            }else {
                continue;
            }
        }
        if(max>0){
            return max;
        }else {
            return -1;
        }
    }
}
