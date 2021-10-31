package esay;

public class MatrixReshape566 {
    public int[][] matrixReshape(int[][] nums,int r,int c){
        int row=nums.length;
        int clo=nums[0].length;
        if((row*clo)!=(r*c)){
            return nums;
        }
        int[][] res=new int[r][c];
        int[] a=new int[row*clo];
        int k=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<clo;j++){
                a[k]=nums[i][j];
                k++;
            }
        }
        k=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                res[i][j]=a[k];
                k++;
            }
        }
        return res;
    }

    /**
     * 可以使用取模的方法
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }
}
