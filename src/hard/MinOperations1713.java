package hard;
//给你一个数组target，包含若干互不相同的整数，以及另一个整数数组arr，arr可能 包含重复元素。
//        每一次操作中，你可以在 arr的任意位置插入任一整数。
//        比方说，如果arr = [1,4,1,2]，那么你可以在中间添加 3得到[1,4,3,1,2]。你可以在数组最开始或最后面添加整数。
//        请你返回 最少操作次数，使得target成为arr的一个子序列。
//        一个数组的 子序列指的是删除原数组的某些元素（可能一个元素都不删除），
//        同时不改变其余元素的相对顺序得到的数组。
//        比方说，[2,7,4]是[4,2,3,7,2,1,4]的子序列（加粗元素），但[2,4,2]不是子序列。


import java.util.*;

/**
 * @author wy
 * @date 2021/7/26 9:28
 */
public class MinOperations1713 {
    /**
     * 先将arr的元素映射成在target中的位置，target也做同样处理，因为target的位置数组是递增的，所以arr的位置映射数组
     * 也应该是递增的，这两个数组的公共子序列越长，需要添加的元素的个数也就越少。因此结果就是target.length-最长公共子序列元素个数
     * 这就成了求最大递增公共子序列的元素个数
     * @param target
     * @param arr
     * @return
     */
    public int minOperations(int[] target,int[] arr){
        int n = target.length;
        Map<Integer, Integer> pos = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; ++i) {
            pos.put(target[i], i);
        }
        List<Integer> d = new ArrayList<Integer>();
        for (int val : arr) {
            if (pos.containsKey(val)) {
                int idx = pos.get(val);
                int it = binarySearch(d, idx);
                if (it != d.size()) {
                    d.set(it, idx);
                } else {
                    d.add(idx);
                }
            }
        }
        return n - d.size();
    }

    public int binarySearch(List<Integer> d, int target) {
        int size = d.size();
        if (size == 0 || d.get(size - 1) < target) {
            return size;
        }
        int low = 0, high = size - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (d.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
