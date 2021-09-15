package medium;
//峰值元素是指其值严格大于左右相邻值的元素。
//        给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
//        你可以假设nums[-1] = nums[n] = -∞ 。
//        你必须实现时间复杂度为 O(log n) 的算法来解决此问题。


import sun.text.UCompactIntArray;

/**
 * @author wy
 * @date 2021/9/15 8:52
 */
public class FindPeakElement162 {
    public int findPeakElement(int[] nums){
      int idx=0;
      for(int i=1;i<nums.length;i++){
          if(nums[i]>nums[idx]){
              idx=i;
          }
      }
      return idx;
    }

    /**
     * 从一个位置开始，不断的向高处走，最终一定可以到达一个峰值
     * 如果nums[i-1]<nums[i]>nums[i+1],该位置就是峰值
     * 如果nums[i-1]>nums[i]<nums[i+1],往左右两边任意方向走都可以
     * 如果nums[i-1]<nums[i]<nums[i+1],处于爬坡状态，向右走
     * 如果nums[i-1]>nums[i]>nums[i+1]，处于下坡状态，向左走
     *
     * 对于第二种情况：可以只看一边做规定
     * 如果nums[i]<nums[i+1]，可以往右走
     * 如果nums[i]>nums[i+1]，可以往左走
     * @param nums
     * @return
     */
    public int findPeakElement1(int[] nums){
        int n=nums.length;
        int idx=(int)(Math.random()*n);
        while(!(compare(nums,idx-1,idx)<0&&compare(nums,idx,idx+1)>0)){
            if(compare(nums,idx,idx+1)<0){
                idx+=1;
            }else {
                idx-=1;
            }
        }
        return idx;
    }
    /*
    辅助函数，输入下标i，返回一个二元数组（0/1，nums[i]）
    方便处理nums[-1]以及nums[n]的边界情况
     */
    public int[] get(int[] nums,int idx){
        if(idx==-1||idx==nums.length){
            return new int[]{0,0};
        }
        return new int[]{1,nums[idx]};
    }
    public int compare(int[] nums,int idx1,int idx2){
        int[] num1=get(nums,idx1);
        int[] num2=get(nums,idx2);
        if(num1[0]!=num2[0]){
            return num1[0]>num2[0]?1:-1;
        }
        if(num1[1]==num2[1]){
            return 0;
        }
        return num1[1]>num2[1]?1:-1;
    }


    public int findPeakElement2(int[] nums){
        int n=nums.length;
        int left=0,right=n-1,ans=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(compare(nums,mid-1,mid)<0&&compare(nums,mid,mid+1)>0){
                ans=mid;
                break;
            }
            if(compare(nums,mid,mid+1)<0){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return ans;
    }
}
