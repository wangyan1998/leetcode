package medium;
//给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
//        请你找出并返回只出现一次的那个数。
//        你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
//        1 <= nums.length <= 10^5
//        0 <= nums[i] <= 10^5

/**
 * @author wy
 * @date 2022/2/14 9:30
 */
public class SingleNonDuplicate540 {
    /**
     * 凡是涉及到时间复杂度为O(logn)的一般都要用到二分查找。关键在于二分查找条件的判断。
     * 本题中，二分查找的条件是：
     * 因为数组有序，且只有一个数出现一次，这个时候假设nums[x]就是这个出现一次的数。
     * 对于x左边的索引y,如果y是奇数，应该满足：nums[y-1]=nums[y]，如果y是偶数，应该满足
     * ：nums[y]=nums[y+1]
     * 对于x右边的索引z,如果z是奇数，应该满足：nums[z]=nums[z+1],如果z是偶数，应该满足
     * ：nums[z-1]=nums[z]
     * 说明x恰好是奇数偶数索引的变化分界点
     * 我们就可以以此作为条件来判断x在左子数组还是右子数组，相应的问题也就迎刃而解了。
     * @param nums
     * @return
     */
    public int singleNonDuplicate1(int[] nums){
        int low=0,high=nums.length-1;
        while(low<high){
            int mid=(high-low)/2+low;
            if(mid%2==0){
                if(nums[mid]==nums[mid+1]){
                    low=mid+1;
                }else {
                    high=mid;
                }
            }else {
                if(nums[mid-1]==nums[mid]){
                    low=mid+1;
                }else {
                    high=mid;
                }
            }
        }
        return nums[low];
    }

    /**
     * 利用按位异或的性质，可以得到mid和相邻的数之间的如下关系：
     * 当mid是偶数时，mid+1=mid^1
     * 当mid是奇数时，mid-1=mid^1
     * 无论奇偶，需要比较的数都可以统一用mid^1获得，这样就省略了奇偶性的判断
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums){
       int low=0,high=nums.length-1;
       while(low<high){
           int mid=(high-low)/2+low;
           if(nums[mid]==nums[mid^1]){
               low=mid+1;
           }else {
               high=mid;
           }
       }
       return nums[low];
    }

    /**
     * 因为单个出现的数前面的所有数都是成对出现的，所以单个数出现的位置一定是偶数。
     * 所以对于每一个偶数肯定都满足nums[x]=nums[x+1]
     * 所以只要找到最小的不满足该条件的偶数就是该单个数出现的位置。
     * 如果符合条件就说明索引关系正常，单个数还没出现，在mid右边
     * 如果不符合条件，说明单个数已经出现了，在mid左边
     * @param nums
     * @return
     */
    public int singleNonDuplicate2(int[] nums){
        int low=0,high=nums.length-1;
        while(low<high){
            int mid=(high-low)/2+low;
            mid-=mid&1;
            if(nums[mid]==nums[mid+1]){
                low=mid+2;
            }else {
                high=mid;
            }
        }
        return nums[low];
    }
}
