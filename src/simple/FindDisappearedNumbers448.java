package simple;
//给定一个范围在 1 ≤ a[i] ≤ n (n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
//        找到所有在 [1, n] 范围之间没有出现在数组中的数字。
//        在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers448 {
    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> res=new ArrayList<Integer>();
        for(int i=1;i<=nums.length;i++){
            res.add(i);
        }
//        for (int i=0;i<nums.length;i++) {
//            if(res.contains(nums[i])){
//                res.remove((Object)nums[i]);
//            }
//        }
        for (int num:nums) {
            if(res.contains(num)){
                res.remove((Object)num);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;

    }
}
