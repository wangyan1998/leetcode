package medium;
import java.util.*;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//        如果数组中不存在目标值 target，返回[-1, -1]。
public class SearchRange34 {
    public int[] searchRange(int[] nums,int target){
      int[] range=new int[2];
      Arrays.fill(range,-1);
      int n=nums.length,j=0;
      int[] a=new int[n];
      for(int i=0;i<n;i++){
          if(nums[i]==target){
              a[j]=i;
              j++;
          }
      }
      if(j!=0){
      range[0]=a[0];
      range[1]=a[j-1];
      }
      return range;
    }
    public int[] searchRange1(int[] nums,int target){//二分查找
        int leftIdx=binarySearch(nums,target,true);
        int rightIdx=binarySearch(nums,target,false)-1;
        if(leftIdx<=rightIdx&&rightIdx<nums.length&&nums[leftIdx]==target&&nums[rightIdx]==target){
            return new int[]{leftIdx,rightIdx};
        }
        return new int[]{-1,-1};
    }
    public int binarySearch(int[] nums,int target,boolean lower){
        int left=0,right=nums.length-1,ans=nums.length;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]>target||(lower&&nums[mid]>=target)){
                right=mid-1;
                ans=mid;
            }else {
                left=mid+1;
            }
        }
        return ans;
    }
}
