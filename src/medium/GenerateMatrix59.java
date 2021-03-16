package medium;

public class GenerateMatrix59 {
    /**
     * 同样是设置四个边界，转着圈的填充数
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        int left = 0;
        int right =n-1;
        int top = 0;
        int bottom =n-1;
        int num =1;
        int x=n*n;
        while (num<=x) {
            for (int i = left; i <=right && num<=x; i++) {
                matrix[top][i]=num;
                num++;
            }
            top++;
            for (int i = top; i <=bottom && num<=x; i++) {
                matrix[i][right]=num;
                num++;
            }
            right--;
            for (int i = right; i >= left && num<=x; i--) {
                matrix[bottom][i]=num;
                num++;
            }
            bottom--;
            for (int i = bottom; i >= top && num<=x; i--) {
                matrix[i][left]=num;
                num++;
            }
            left++;
        }
        return matrix;
    }
}
