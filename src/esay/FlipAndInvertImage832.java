package esay;
//给定一个二进制矩阵A，我们想先水平翻转图像，然后反转图像并返回结果。
//        水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转[1, 1, 0]的结果是[0, 1, 1]。
//        反转图片的意思是图片中的0全部被1替换，1全部被0替换。例如，反转[0, 1, 1]的结果是[1, 0, 0]。


public class FlipAndInvertImage832 {
    public int[][] flipAndInvertImage(int[][] A){
        int r=A.length;
        int c=A[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c/2;j++){
                int temp=A[i][j];
                A[i][j]=A[i][c-j-1];
                A[i][c-j-1]=temp;
            }
            for(int k=0;k<c;k++){
                if(A[i][k]==0){
                    A[i][k]=1;
                }else {
                    A[i][k]=0;
                }
            }
        }
        return A;
    }
}
