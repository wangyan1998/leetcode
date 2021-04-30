package medium;
//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/4/30 8:42
 */
public class SingleNumber137 {
    public int singleNumber(int[] nums){
        if(nums.length==1){
            return nums[0];
        }
        Arrays.sort(nums);
        boolean flag=true;
        int i=1;
        for(;i<nums.length;i++){
            if(nums[i]!=nums[i-1]&&nums[i]!=nums[i+1]){
                flag=false;
                break;
            }
        }
        if(flag==false){
            return nums[i];
        }else {
            if(nums[0]!=nums[1]){
                return nums[0];
            }else {
                return nums[nums.length-1];
            }
        }
    }

    /**
     * 哈希表
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }

    /**
     *依次确定每个二进制位，因为出现三遍的每个二进制位的和要么是0要么是3，出现一边的二进制位要么是0要么是1
     * 所以只要单独计算所有二进制位的和并除以3，得到的余数就是该二进制位的出现一次的位值。
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num: nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
