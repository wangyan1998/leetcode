package esay;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//给定一个整数数组，判断是否存在重复元素。
//        如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
public class ContainsDuplicate217 {
    /*
    利用set工具的不可重复性
     */
    public boolean containsDuplicate(int[] nums){
        Set<Integer> r=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            r.add(nums[i]);
        }
        if(r.size()==nums.length){
            return false;
        }else {
            return true;
        }
    }
    /*
    排序法：把数组从小到大排序，重复元素一定出现在相邻位置
     */
    public boolean containsDuplicate1(int[] nums){
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
    /*
    利用set的不可重复性，不全遍历完，只要遇到重复就返回
     */
    public boolean containsDuplicate2(int[] nums){
        Set<Integer> set=new HashSet<Integer>();
        for(int x:nums){
            if(!set.add(x)){
                return true;
            }
        }
        return false;
    }
}
