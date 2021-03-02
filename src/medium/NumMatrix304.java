package medium;
//给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，
//        右下角为 (row2, col2)。
public class NumMatrix304 {
    private int[][] matrix1;
    public NumMatrix304(int[][] matrix) {
     matrix1=matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
      int sum=0;
      for(int i=row1;i<=row2;i++){
          for(int j=col1;j<=col2;j++){
              sum+=matrix1[i][j];
          }
      }
      return sum;
    }
}
