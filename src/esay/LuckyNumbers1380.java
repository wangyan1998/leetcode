package esay;
//给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
//        幸运数是指矩阵中满足同时下列两个条件的元素：
//        在同一行的所有元素中最小
//        在同一列的所有元素中最大
//        m == mat.length
//        n == mat[i].length
//        1 <= n, m <= 50
//        1 <=matrix[i][j]<= 10^5
//        矩阵中的所有元素都是不同的


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author wy
 * @date 2022/2/15 9:18
 */
public class LuckyNumbers1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<Integer>();
        int[] row = new int[m];
        int[] col = new int[n];
        Arrays.fill(row, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = Math.min(row[i], matrix[i][j]);
                col[j] = Math.max(col[j], matrix[i][j]);

            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row[i]==col[j]){
                    res.add(row[i]);
                }
            }
        }
        return res;
    }
}
