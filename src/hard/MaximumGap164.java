package hard;

import java.util.Arrays;

//给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
//        如果数组元素个数小于 2，则返回 0。
public class MaximumGap164 {
    public int maximumGap(int[] nums){
        int n=nums.length;
        if(n<2){
            return 0;
        }else {
            Arrays.sort(nums);
            int[] c=new int[n-1];
            for(int i=0;i<n-1;i++){
                c[i]=nums[i+1]-nums[i];
            }
            Arrays.sort(c);
            return c[n-2];
        }
    }
}
