package medium;
//有一个二维矩阵A 其中每个元素的值为0或1。
//        移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
//        在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
//        返回尽可能高的分数。

public class MatrixScore861 {
    /*
    贪心算法：首先要明白，给定一个翻转方案，行翻转和列翻转的顺序不会影响结果，所以我们可以考虑所有的行翻转
    再考虑列翻转。
    我们要定义这样的概念：
    (1)、为了得到最高分数，矩阵的每一行最左边都必须为1，所以我们可以翻转最左边不是1的行
    (2)、当每一行的最左边都是1后，如果要使得分数最大，要让每个列中1的数目尽量多，所以我们从第二列开始，
    如果该列0的数目多于1的数目，就翻转该列，其他的列则保持不变。
    (3)、实际编码时，我们无需修改原矩阵，只需要计算每一列对总分数的贡献就可以了，最左边取值为1，所以每个
    元素贡献2^(n-1),总贡献为m*2^(n-1),其他列要统计0,1的个数,对于第j列，j>0,设k为0、1个数中较大
    的那个，所以k是翻转后的1的个数，总贡献为k*2^(n-j-1).
     */
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        int ret = m * (1 << (n - 1));
        for (int j = 1; j < n; j++) {
            int nOnes = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][0] == 1) {
                    nOnes += A[i][j];
                } else {
                    nOnes += (1 - A[i][j]);//如果这一行进行了翻转，该元素的实际取值为1-A[i][j]
                }
            }
            int k = Math.max(nOnes, m - nOnes);
            ret += k * (1 << (n - j - 1));
        }
        return ret;
    }
}