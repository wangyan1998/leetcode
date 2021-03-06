package medium;
//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
//        数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，
//        这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElements503 {
    /**
     * 暴力算法求解
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums){
        int n=nums.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            int j=i+1;
            while (j%n!=i){
                if(nums[j%n]>nums[i]){
                    res[i]=nums[j%n];
                    break;
                }
                j++;
            }
            if(j%n==i){
                res[i]=-1;
            }
        }
        return res;
    }

    /**
     * 单调栈
     * @param nums
     * @return
     */
    public int[] nextGreaterElements1(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }
}
