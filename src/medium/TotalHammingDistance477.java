package medium;
//两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
//        计算一个数组中，任意两个数之间汉明距离的总和。
/**
 * @author wy
 * @date 2021/5/28 9:07
 */
public class TotalHammingDistance477 {
    /**
     * 逐位统计，统计nums中第i为有多少1有多少0，假设有c个1,就有n-c个0，对于结果的贡献就是有c*(n-c)
     * @param nums
     * @return
     */
    public int totalHammingDistance(int[] nums){
       int ans=0,n=nums.length;
       for(int i=0;i<30;++i){
           int c=0;
           for(int val:nums){
               c+=(val>>i)&1;
           }
           ans+=c*(n-c);
       }
       return ans;
    }
}
