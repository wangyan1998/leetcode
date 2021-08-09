package medium;
//存在一个不含 0 的 环形 数组nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：
//        (1).如果 nums[i] 是正数，向前 移动 nums[i] 步
//        (2).如果nums[i] 是负数，向后 移动 nums[i] 步
//        因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，
//        而第一个元素向后移动一步会到达最后一个元素。
//        数组中的 循环 由长度为 k 的下标序列 seq ：
//        (1).遵循上述移动规则将导致重复下标序列
//        seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
//        (2).所有 nums[seq[j]] 应当不是 全正 就是 全负
//        (3).k > 1
//        如果 nums 中存在循环，返回 true ；否则，返回 false 。


/**
 * @author wy
 * @date 2021/8/7 10:40
 */
public class CircularArrayLoop457 {
    /**
     * 快慢指针方法
     * @param nums
     * @return
     */
    public boolean circularArrayLoop(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i, fast = next(nums, i);
            // 判断非零且方向相同
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow != next(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            int add = i;
            while (nums[add] * nums[next(nums, add)] > 0) {
                int tmp = add;
                add = next(nums, add);
                nums[tmp] = 0;
            }
        }
        return false;
    }

    public int next(int[] nums, int cur) {
        int n = nums.length;
        return ((cur + nums[cur]) % n + n) % n; // 保证返回值在 [0,n) 中
    }
}
