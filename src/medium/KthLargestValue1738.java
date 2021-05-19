package medium;
//给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为m x n 由非负整数组成。
//        矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n
//        的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
//        请你找出matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。


import java.util.*;

/**
 * @author wy
 * @date 2021/5/19 9:03
 */
public class KthLargestValue1738 {
    /**
     * 二维异或前缀和+排序
     * @param matrix
     * @param k
     * @return
     */
    public int kthLargestValue(int[][] matrix,int k){
       int m=matrix.length;
       int n=matrix[0].length;
       int[][] res=new int[m][n];
       res[0][0]=matrix[0][0];
       for(int i=1;i<n;i++){
           res[0][i]=res[0][i-1]^matrix[0][i];
       }
       for(int j=1;j<m;j++){
           res[j][0]=res[j-1][0]^matrix[j][0];
       }
       for(int i=1;i<m;i++){
           for(int j=1;j<n;j++){
               res[i][j]=res[i-1][j]^res[i][j-1]^res[i-1][j-1]^matrix[i][j];
           }
       }
       ArrayList<Integer> r=new ArrayList<Integer>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                r.add(res[i][j]);
            }
        }
        r.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer r1, Integer r2) {
                return r2-r1;
            }
        });
       return r.get(k-1);
    }
    public int kthLargestValue1(int[][] matrix,int k){
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] res=new int[m][n];
        List<Integer> l=new ArrayList<Integer>();
        res[0][0]=matrix[0][0];
        l.add(res[0][0]);
        for(int i=1;i<n;i++){
            res[0][i]=res[0][i-1]^matrix[0][i];
            l.add(res[0][i]);
        }
        for(int j=1;j<m;j++){
            res[j][0]=res[j-1][0]^matrix[j][0];
            l.add(res[j][0]);
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                res[i][j]=res[i-1][j]^res[i][j-1]^res[i-1][j-1]^matrix[i][j];
                l.add(res[i][j]);
            }
        }
        Collections.sort(l, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        return l.get(k-1);
    }

    /**
     * 可以使用一个m+1行，n+1列的数组存储，这样就不用单独处理第一行和第一列
     * @param matrix
     * @param k
     * @return
     */
    public int kthLargestValue2(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        List<Integer> results = new ArrayList<Integer>();
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                results.add(pre[i][j]);
            }
        }

        Collections.sort(results, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        return results.get(k - 1);
    }
}
