package hard;
//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
public class MaximalRectangle85 {
    /** 计算出矩阵的每个元素的左边连续 1的数量，使用二维数组left 记录，
     *  其中 left[i][j]表示 i 行第 j 列元素的左边连续 1 的数量。对于矩阵中任意一个点，
     *  我们枚举以该点为右下角的全 1 矩形。当考察以 matrix[i][j] 为右下角的矩形时，
     *  我们枚举满足 0≤k≤i 的所有可能的 k，此时矩阵的最大宽度就为
     * left[i][j],left[i−1][j],…,left[k][j]的最小值。
     */


    public int maximalRectangle(char[][] matrix){
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int width = left[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, (i - k + 1) * width);
                }
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }
}
