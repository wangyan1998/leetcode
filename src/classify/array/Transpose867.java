package classify.array;
//给定一个矩阵 A， 返回 A 的转置矩阵。
//        矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
public class Transpose867 {
    /*
    注意只有方阵才能在原矩阵上修改，普通矩阵不能修改
     */
    public int[][] transpose(int[][] A){
        int n=A.length;
        int m=A[0].length;
        int[][] res=new int[m][n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                res[i][j]=A[j][i];
            }
        }
        return res;
    }
}
