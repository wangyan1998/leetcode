package medium;
//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
//        注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author wy
 * @date 2021/4/12 8:43
 */
public class LargestNumber179 {
    /**
     * 本题的本质是找到一个符合题意的排序规则
     * 针对两个数的相对位置如何比较可以得到一个较大的数，比如：
     *     对于没有重复首字符的数组比如：24,59,1，最大组成59241
     *     对于有重复首字符的数组比如：4,45;454>445
     *     那么针对两个数x,y就需要比较字符串连接的大小：x+y和y+x
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums){
        //大顶堆
        PriorityQueue<String> heap = new PriorityQueue<>(nums.length,(s1, s2) -> {
            if (s1.length() == s2.length()){
                return s2.compareTo(s1);
            }
            return (s2 + s1).compareTo(s1 + s2);
        });
        for (int i = 0; i < nums.length; i++) {
            heap.add(String.valueOf(nums[i]));
        }
        StringBuilder collect = new StringBuilder();
        //foreach并不保证堆顺序 heap.forEach(collect::append);
        for (int i = 0; i < nums.length; i++) {
            collect.append(heap.remove());
        }
        while (collect.length() >= 2 && collect.charAt(0)=='0' && collect.charAt(1)=='0'){
            collect.deleteCharAt(0);
        }
        return collect.toString();
    }

    public String largestNumber1(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }

    public String largestNumber2(int[] nums) {
        PriorityQueue<String> heap = new PriorityQueue<>((x, y) -> (y + x).compareTo(x + y));
        for(int x: nums) heap.offer(String.valueOf(x));
        String res = "";
        while(heap.size() > 0) res += heap.poll();
        if(res.charAt(0) == '0') return "0";
        return res;
    }
}
