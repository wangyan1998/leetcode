package competition.test_2021_10_10;
//给你一个大小为 m x n 的二维整数网格 grid 和一个整数 x 。每一次操作，你可以对 grid 中的任一元素 加 x 或 减 x 。
//        单值网格 是全部元素都相等的网格。
//        返回使网格化为单值网格所需的 最小 操作数。如果不能，返回 -1 。

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/10/10 10:41
 */
public class MinOperations {
    /**
     * 找中位数，然后对每一个数加减x直至到达中位数
     * @param grid
     * @param x
     * @return
     */
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int[] arr = new int[m*n];
        int i = 0;
        for(int[] a : grid)
            for(int a_ : a){
                arr[i++] = a_;
            }
        Arrays.sort(arr);
        int j = arr[(n*m)/2];
        int sum = 0;
        for(int a : arr){
            int l = Math.abs(j-a);
            if(l%x != 0) return -1;
            sum += l/x;
        }
        return sum;
    }
}
