package competition.test_2021_10_31;
//给你一个下标从 0 开始的整数数组 nums ，返回 nums 中满足 i mod 10 == nums[i] 的最小下标 i ；如果不存在这样的下标，返回 -1 。
//        x mod y 表示 x 除以 y 的 余数 。
/**
 * @author wy
 * @date 2021/10/31 10:30
 */
public class SmallestEqual {
    public int smallestEqual(int[] nums){
       for (int i=0;i<nums.length;i++){
           if(i%10==nums[i]){
               return i;
           }
       }
       return -1;
    }
}
