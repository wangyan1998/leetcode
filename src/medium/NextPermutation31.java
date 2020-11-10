package medium;
//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//        如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//        必须原地修改，只允许使用额外常数空间。
//        以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
//        1,2,3 → 1,3,2
//        3,2,1 → 1,2,3
//        1,1,5 → 1,5,1


import java.util.Arrays;

public class NextPermutation31 {
    //两遍扫描，需要找到一个大于当前序列的而且变大幅度尽可能要小的新序列。
    //左边小数与右边大数交换保证序列变大，同时左边小数要尽量靠右，而较大数尽量小，从而保证变大幅度尽可能小
    public void nextPermutation(int[] nums){
      int i=nums.length-2;
      while(i>=0&&nums[i]>=nums[i+1]){
          i--;
      }
      if(i>=0){
          int j=nums.length-1;
          while(j>=0&&nums[i]>=nums[j]){
              j--;
          }
          swap(nums,i,j);
      }
      reverse(nums,i+1);
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverse(int[] nums,int start){
        int left=start,right=nums.length-1;
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
}
