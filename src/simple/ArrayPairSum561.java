package simple;

import java.util.Arrays;

public class ArrayPairSum561 {
    /**
     * 排序之后，每两个一组，选较小的，也就是不能选大的，那就选第二大的
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums){
        Arrays.sort(nums);
        int sum=0;
        for(int i=nums.length-2;i>=0;i=i-2){
            sum+=nums[i];
        }
        return sum;
    }
}
