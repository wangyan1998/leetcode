package esay;

public class IsToeplitzMatrix766 {
    /**
     * 使用对角线判断方法，初始设定为true,如果出现对角线不同得情况设为false
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix){
        int row=matrix.length;
        int clo=matrix[0].length;
        boolean res=true;
        for(int i=0;i<clo-1;i++){
            int k=i+1,j=1;
            while(k<clo&&j<row){
                if(matrix[j-1][k-1]!=matrix[j][k]){
                    res=false;
                }
                k++;
                j++;
            }
        }
        for(int i=0;i<row-1;i++){
            int k=1,j=i+1;
            while(k<clo&&j<row){
                if(matrix[j][k]!=matrix[j-1][k-1]){
                    res=false;
                }
                k++;
                j++;
            }
        }
        return res;
    }

    /**
     * 遍历
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
