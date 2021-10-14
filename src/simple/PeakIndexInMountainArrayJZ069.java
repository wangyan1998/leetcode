package simple;
//符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
//        arr.length >= 3
//        存在 i（0 < i< arr.length - 1）使得：
//        arr[0] < arr[1] < ... arr[i-1] < arr[i]
//        arr[i] > arr[i+1] > ... > arr[arr.length - 1]
//        给定由整数组成的山峰数组 arr ，返回任何满足
//        arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i，即山峰顶部。


/**
 * @author wy
 * @date 2021/10/14 9:02
 */
public class PeakIndexInMountainArrayJZ069 {
    public int peakIndexInMountainArray(int[] arr){
       int res=0;
       int n=arr.length;
       for(int i=1;i<n-1;i++){
           if(arr[i-1]<arr[i]&&arr[i+1]<arr[i]){
               res=i;
               break;
           }
       }
       return res;
    }

    public int peakIndexInMountainArray1(int[] arr) {
        int n = arr.length;
        int ans = -1;
        for (int i = 1; i < n - 1; ++i) {
            if (arr[i] > arr[i + 1]) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    /**
     * 二分查找
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray2(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
