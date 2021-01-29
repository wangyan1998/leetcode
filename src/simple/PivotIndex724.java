package simple;
//给定一个整数类型的数组nums，请编写一个能够返回数组 “中心索引” 的方法。
//        我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
//        如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，
//        那么我们应该返回最靠近左边的那一个。

import java.util.Arrays;

public class PivotIndex724 {
    /**
     * 通过和来判断，求前面元素的和是否等于总和减去当前元素的一半
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums){
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
           count+=nums[i];
        }
        int i;
        int c=0;
        for(i=0;i<n;i++){
            int a=(count-nums[i]);
            if(a%2==0){
                if(c==a/2){
                    break;
                }else {
                    c+=nums[i];
                }
            }else {
                c+=nums[i];
            }
        }
        if(i!=n){
            return i;
        }else {
            return -1;
        }
    }

    public int pivotIndex1(int[] nums){
        int total= Arrays.stream(nums).sum();
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(2*sum+nums[i]==total){
                return i;
            }
            sum+=nums[i];
        }
        return -1;
    }

}
