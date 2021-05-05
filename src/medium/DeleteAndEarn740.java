package medium;
//给你一个整数数组nums，你可以对它进行一些操作。
//        每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除每个等于nums[i] - 1或nums[i] + 1的元素。
//        开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。


import java.util.*;

/**
 * @author wy
 * @date 2021/5/5 9:07
 */
public class DeleteAndEarn740 {
    /**
     * 根据题意，在选择了元素x后，该元素以及所有等于x−1或 x+1 的元素会从数组中删去。
     * 若还有多个值为 x的元素，由于所有等于 x−1 或x+1 的元素已经被删除，我们可以直接删除x并获得其点数。
     * 因此若选择了 x，所有等于 x 的元素也应一同被选择，以尽可能多地获得点数。
     *记元素 x 在数组中出现的次数为 c，我们可以用一个数组sum记录数组 nums中所有相同元素之和，即 sum[x]=x*c。
     * 若选择了 x，则可以获取sum[x] 的点数，且无法再选择 x−1和x+1。
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums){
        int maxVal=0;
        for(int val:nums){
            maxVal=Math.max(maxVal,val);
        }
        int[] sum=new int[maxVal+1];
        for(int val:nums){
            sum[val]+=val;
        }
        return rob(sum);
    }
    public int rob(int[] nums){
        int size=nums.length;
        int first=nums[0],second=Math.max(nums[0],nums[1]);
        for(int i=2;i<size;i++){
            int temp=second;
            second=Math.max(first+nums[i],second);
            first=temp;
        }
        return second;
    }

    /**
     * 注意到若 nums 中不存在某个元素 x，则选择任一小于 x 的元素不会影响到大于 x 的元素的选择。
     * 因此我们可以将 nums 排序后，将其划分成若干连续子数组，子数组内任意相邻元素之差不超过 1.
     * 对每个子数组按照方法一的动态规划过程计算出结果，累加所有结果即为答案。
     * @param nums
     * @return
     */
    public int deleteAndEarn1(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        List<Integer> sum = new ArrayList<Integer>();
        sum.add(nums[0]);
        int size = 1;
        for (int i = 1; i < n; ++i) {
            int val = nums[i];
            if (val == nums[i - 1]) {
                sum.set(size - 1, sum.get(size - 1) + val);
            } else if (val == nums[i - 1] + 1) {
                sum.add(val);
                ++size;
            } else {
                ans += rob(sum);
                sum.clear();
                sum.add(val);
                size = 1;
            }
        }
        ans += rob(sum);
        return ans;
    }

    public int rob(List<Integer> nums) {
        int size = nums.size();
        if (size == 1) {
            return nums.get(0);
        }
        int first = nums.get(0), second = Math.max(nums.get(0), nums.get(1));
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums.get(i), second);
            first = temp;
        }
        return second;
    }
}
