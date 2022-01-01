package esay;
//给你一个下标从 0开始的一维整数数组original和两个整数m和n。你需要使用original中所有元素创建一个m行n列的二维数组。
//        original中下标从 0到 n - 1（都包含）的元素构成二维数组的第一行，下标从 n到 2 * n - 1（都 包含）的元素
//        构成二维数组的第二行，依此类推。
//        请你根据上述过程返回一个m x n的二维数组。如果无法构成这样的二维数组，请你返回一个空的二维数组。

/**
 * @author wy
 * @date 2022/1/1 10:57
 */
public class Construct2DArray2022 {
    public int[][] construct2DArray(int[] original,int m,int n){
        int l=original.length;
        if(m*n!=l){
            int[][] res={};
            return res;
        }
        int[][] res=new int[m][n];
        for(int i=0;i<l;i++){
            res[i/n][i%n]=original[i];
        }
        return res;
    }
}
