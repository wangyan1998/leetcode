package medium;
//如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
//        例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
//        给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
//        子数组是数组中的一个连续序列。


/**
 * @author wy
 * @date 2021/8/10 9:41
 */
public class NumberOfArithmeticSlices413 {
    /**
     * 直接计数
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int l = 0;
        int res = 0;
        for(int i=2;i<n;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                res+=++l;
            }else {
                l=0;
            }
        }
        return res;
    }
}
