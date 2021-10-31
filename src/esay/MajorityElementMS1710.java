package esay;
//数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。
//        请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。


import java.util.Arrays;

/**
 * @author wy
 * @date 2021/7/9 9:04
 */
public class MajorityElementMS1710 {
    /**
     * 首先排序，找到可能是主要元素的的中间位置元素，然后判断个数是否大于一半
     * 时间复杂度比较高，没能达到O(N)
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int c = 0;
        int num = nums[n / 2];
        for (int i = 0; i < n; i++) {
            if (nums[i] == num) {
                c++;
            }
        }
        if (c > n / 2) {
            return num;
        } else {
            return -1;
        }
    }

    /**
     * Boyer-Moore投票算法：在每一轮投票中，从数组中删除两个不同的元素，直到投票过程无法继续，此时数组为空或者数组中剩下的元素都相等。
     * 步骤：
     * （1）维护一个候选主要元素candidate和候选主要元素的出现次数count,初始时candidate为任意值，count=0;
     * (2)遍历数组中的所有元素，遍历到元素x时进行如下操作
     *     如果count==0，则将x的值赋给candidate，否则不更新candidate的值
     *     如果x=candidate,则将count+1,否则将count-1。
     * （3）遍历结束后，如果数组nums中存在主要元素，则candidate即为主要元素，否则candidate可能为数组中任意一个元素。
     * 由于不一定存在主要元素，因此需要第二次遍历数组验证candidate是否为主要元素，第二次遍历主要统计数组中candidate的个数
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        int length = nums.length;
        for (int num : nums) {
            if(num==candidate){
                count++;
            }
        }
        return count*2>length?candidate:-1;
    }
}
