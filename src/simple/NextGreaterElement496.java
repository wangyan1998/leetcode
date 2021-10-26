package simple;
//给你两个没有重复元素的数组nums1和nums2，其中nums1是nums2的子集。
//        请你找出 nums1中每个元素在nums2中的下一个比其大的值。
//        nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出 -1 。


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/10/26 9:17
 */
public class NextGreaterElement496 {
    public int[] nextGreaterElement(int[] nums1,int[] nums2){
        int n=nums1.length;
        int[] res=new int[n];
        for(int i=0;i<nums1.length;i++){
            res[i]=nextNum(nums1[i],nums2);
        }
        return res;
    }
    public int nextNum(int num,int[] nums){
        int i=0;
        for(;i<nums.length;i++){
            if(nums[i]==num){
                break;
            }
        }
        if(i==nums.length-1){
            return -1;
        }else {
            for(;i<nums.length;i++){
                if(nums[i]>num){
                    return nums[i];
                }
            }
        }
        return -1;
    }
    public int nextNum1(int num,int[] nums){
        int i=0;
        boolean flag=false;
        for(;i<nums.length;i++){
            if(nums[i]==num){
                flag=true;
            }
            if(flag==true&&nums[i]>num){
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 单调栈
     * nums2中元素不重复，所以可以用map存储nums2中的右边的较大的一个元素
     * 从nums2[nums2.length()-1]开始遍历，将当前元素入栈，当遍历到当前元素时，将小于当前元素的栈顶元素依次出栈，
     * 这时如果栈顶元素存在，该元素就是当前元素右侧第一个较大的数。如果栈为空，则为-1。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement1(int[] nums1,int[] nums2){
        Map<Integer,Integer> map=new HashMap<>();
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=nums2.length-1;i>=0;i--){
            int num=nums2[i];
            while(!stack.isEmpty()&&num>=stack.peek()){
                stack.pop();
            }
            map.put(num,stack.isEmpty()?-1:stack.peek());
            stack.push(num);
        }
        int[] res=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            res[i]=map.get(nums1[i]);
        }
        return res;
    }
}
