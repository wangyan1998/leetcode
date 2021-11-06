package esay;
//给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wy
 * @date 2021/11/6 9:56
 */
public class MissingNumber268 {
    /**
     * 排序
     * @param nums
     * @return
     */
    public int missNumber(int[] nums){
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i!=nums[i]){
                return i;
            }
        }
        return n;
    }

    /**
     * 哈希表
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums){
        Set<Integer> set=new HashSet<Integer>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int missing=-1;
        for(int i=0;i<=n;i++){
            if(!set.contains(i)){
                missing=i;
                break;
            }
        }
        return missing;
    }

    /**
     * 位运算
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums){
        int xor=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            xor^=nums[i];
        }
        for(int i=0;i<=n;i++){
            xor^=i;
        }
        return xor;
    }

    /**
     * 数学方法，前n项和
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums){
        int n=nums.length;
        int total=n*(n+1)/2;
        int arrSum=0;
        for(int i=0;i<n;i++){
            arrSum+=nums[i];
        }
        return total-arrSum;
    }
}
