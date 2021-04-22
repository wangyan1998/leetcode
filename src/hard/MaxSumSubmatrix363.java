package hard;
//给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
//        题目数据保证总会存在一个数值和不超过 k 的矩形区域。


import java.util.TreeSet;

/**
 * @author wy
 * @date 2021/4/22 8:23
 */
public class MaxSumSubmatrix363 {
    /**
     * 枚举矩形的上下边界，并计算出该边界内每列的元素和，则远问题转换成了如下一维问题：
     * 给定一个整数数组和一个整数k,计算该数组的最大区间和，要求区间和不超过k
     * 定义长度为n的数组a的前缀和：
     * (1)当i=0时，S[i]=0
     * (2)当1<=i<=n时，S[i]=a[0]+a[1]+...a[i-1]
     * 则区间[l,r)的区间和a[l]+a[l+1]+...a[r-1]可以表示S[r]-S[l]
     * 枚举r，上述问题的约束S[r]-S[l]<=k可以转换成S[l]>=S[r]-k,要使S[r]-S[l]尽可能大，则需要寻找最小的满足上述公式的S[l]
     * 我们可以在枚举r的同时维护一个存储S[i]的有序集合，则可以在O(logn)的时间内二分找到符合要求的S[l]
     *
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int[] sum = new int[n];
            for (int j = i; j < m; j++) {
                for (int c = 0; c < n; c++) {
                    sum[c] += matrix[j][c];
                }
                TreeSet<Integer> sumSet=new TreeSet<Integer>();
                sumSet.add(0);
                int s=0;
                for(int v:sum){
                    s+=v;
                    Integer ceil=sumSet.ceiling(s-k);
                    if(ceil!=null){
                        ans=Math.max(ans,s-ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }
}
