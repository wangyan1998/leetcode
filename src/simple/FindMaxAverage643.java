package simple;
//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
public class FindMaxAverage643 {
    /**
     * 先求和的最大值，然后除以k
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums,int k){
        int count=0;
        for(int i=0;i<k;i++){
            count+=nums[i];
        }
        int maxcount=count;
        for(int i=1;i<=nums.length-k;i++){
              count=count-nums[i-1]+nums[i+k-1];
              if(count>maxcount){
                  maxcount=count;
              }
        }
        return maxcount/(double)k;
    }
}
