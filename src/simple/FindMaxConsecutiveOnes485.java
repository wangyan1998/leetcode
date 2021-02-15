package simple;
//给定一个二进制数组， 计算其中最大连续1的个数。
public class FindMaxConsecutiveOnes485 {
    /**
     * 一次遍历
     * @param nums
     * @return
     */
  public int findMaxConsecutiveOnes(int[] nums){
      int maxcount=0;
      int count=0;
      for(int i=0;i<nums.length;i++){
          if(nums[i]==0){
              count=0;
          }else {
              count++;
          }
          maxcount=Math.max(maxcount,count);
      }
      return maxcount;
  }
}
