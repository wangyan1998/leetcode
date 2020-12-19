package medium;
//给定一个 n × n 的二维矩阵表示一个图像。
//        将图像顺时针旋转 90 度。
public class Rotate48 {
    /*
    先对矩阵转置，然后在对每一行进行逆转
     */
    public void rotate(int[][] matrix){
        int temp=0;
        for(int i=0;i<matrix.length;++i){
            for(int j=i+1;j<matrix.length;++j){
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix.length/2;++j){
                temp=matrix[i][j];
                matrix[i][j]=matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j]=temp;
            }
        }
    }
}
