package medium;
//编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//        每行中的整数从左到右按升序排列。
//        每行的第一个整数大于前一行的最后一个整数。

/**
 * @author wy
 * @date 2021/3/30 8:20
 */
public class SearchMatrix74 {
    /**
     * 遍历分别确定行与列
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix,int target){
        int m=matrix.length;
        int n=matrix[0].length;
        if(target<matrix[0][0]||target>matrix[m-1][n-1]){
            return false;
        }
        int r=-1,c=-1;
        for(int i=0;i<m;i++){
            if(matrix[i][0]<=target&&matrix[i][n-1]>target){
                r=i;
                break;
            }
        }
        if(r==-1){
            return false;
        }
        for(int i=0;i<n;i++){
            if(matrix[r][i]==target){
                c=i;
                break;
            }
        }
        if(c==-1){
            return false;
        }
        return true;
    }

    /**
     * 两次二分查找，在行与列方向上都做二分查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);
    }

    public int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1, high = matrix.length - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean binarySearchRow(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    /**
     * 一次二分查找：因为二维数组的属性，如果把每一行拼接起来就是一个单调递增的数组
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
