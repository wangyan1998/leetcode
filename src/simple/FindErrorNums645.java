package simple;
//集合 s 包含从 1 到n的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，
//        导致集合 丢失了一个数字 并且 有一个数字重复 。
//        给定一个数组 nums 代表了集合 S 发生错误后的结果。
//        请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/7/4 9:15
 */
public class FindErrorNums645 {
    /**
     * 首先找重复的，再找没有出现的
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums){
       int[] c=new int[nums.length+1];
       int[] res=new int[2];
       for(int i=0;i<nums.length;i++){
           if(c[nums[i]]==0){
               c[nums[i]]=1;
           }else {
               res[0]=nums[i];
           }
       }
       for(int i=1;i<c.length;i++){
           if(c[i]==0){
               res[1]=i;
               break;
           }
       }
       return res;
    }

    /**
     * 排序，可以很容易的找到重复的元素，但是寻找缺少的元素比较麻烦
     * 如果缺少的元素小于n大于1，直接比较当前元素与前一个元素的差值就可以了
     * 但是如果缺少的是1或者n，要单独处理
     * @param nums
     * @return
     */
    public int[] findErrorNums1(int[] nums) {
        int[] errorNums = new int[2];
        int n = nums.length;
        Arrays.sort(nums);
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            if (curr == prev) {
                errorNums[0] = prev;
            } else if (curr - prev > 1) {
                errorNums[1] = prev + 1;
            }
            prev = curr;
        }
        if (nums[n - 1] != n) {
            errorNums[1] = n;
        }
        return errorNums;
    }

    /**
     * 哈希表，重复数字出现两次，丢失数字出现0次，和第一种方法类似，只是采用哈希表的方式实现
     * @param nums
     * @return
     */
    public int[] findErrorNums2(int[] nums) {
        int[] errorNums = new int[2];
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= n; i++) {
            int count = map.getOrDefault(i, 0);
            if (count == 2) {
                errorNums[0] = i;
            } else if (count == 0) {
                errorNums[1] = i;
            }
        }
        return errorNums;
    }
}
