package competition.test_2021_10_17;
//给你一个整数数组 nums ，请你找出 nums 子集 按位或 可能得到的 最大值 ，并返回按位或能得到最大值的 不同非空子集的数目 。
//        如果数组 a 可以由数组 b 删除一些元素（或不删除）得到，则认为数组 a 是数组 b 的一个 子集 。如果选中的元素下
//        标位置不一样，则认为两个子集 不同 。
//        对数组 a 执行 按位或 ，结果等于 a[0] OR a[1] OR ... OR a[a.length - 1]（下标从 0 开始）。


/**
 * @author wy
 * @date 2021/10/17 11:03
 */
public class CountMaxOrSubsets {
        private int ans = 0;
        public int countMaxOrSubsets(int[] nums) {
            // 按位或是不减的操作，所以全部 | 起来是最大值
            int sum = 0;
            for(int p : nums){
                sum |= p;
            }
            dfs(nums, sum, 0, 0);
            return ans;
        }
        public void dfs(int[] nums, int sum, int idx, int cur){
            // 剪枝
            if(cur == sum){
                ans += 1 << (nums.length - idx);
                return;
            }
            if(idx == nums.length){
                return;
            }
            // 加上这个数
            dfs(nums, sum, idx + 1, cur | nums[idx]);
            // 不加这个数
            dfs(nums, sum, idx + 1, cur);
       }
}
