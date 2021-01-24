package simple;
//给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
//        连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个
//        l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l],
//        nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。

public class FindLengthOfLCIS674 {
    /**
     * 一次遍历，记录最大的递增长度
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums){
        int n=nums.length;
        if(n<2){
            return n;
        }
        int max=0;
        int count=1;
        for(int i=1;i<n;i++){
            if(nums[i-1]<nums[i]){
                count++;
                if(count>max){
                    max=count;
                }
            }else {
                if(count>max){
                    max=count;
                }
                count=1;
            }
        }
        return max;
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int findLengthOfLCIS1(int[] nums){
        if(nums.length<2){
            return nums.length;
        }
        int[] count=new int[nums.length];
        int max=0;
        count[0]=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>nums[i-1]){
                count[i]=count[i-1]+1;
            }else {
                count[i]=1;
            }
            max=Math.max(count[i],max);
        }
        return max;
    }
}
