package simple;
//符合下列属性的数组 arr 称为 山脉数组 ：
//        arr.length >= 3
//        存在 i（0 < i< arr.length - 1）使得：
//        arr[0] < arr[1] < ... arr[i-1] < arr[i]
//        arr[i] > arr[i+1] > ... > arr[arr.length - 1]
//        给你由整数组成的山脉数组 arr ，
//        返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i


/**
 * @author wy
 * @date 2021/6/15 8:36
 */
public class PeakIndexInMountainArray852 {
    public int peakIndexInMountainArray(int[] arr){
        int n=arr.length;
        int i=0;
        for(;i<n-1;i++){
            if(arr[i+1]<arr[i]){
                break;
            }
        }
        return i;
    }

    /**
     * 二分查找。假设结果为ans，那么在ans左侧有arr[i]<arr[i+1],在ans右侧有arr[i]>arr[i+1]
     * 所以每次儿茶查找就比较arr[mid]和arr[mid+1]
     * 如果arr[mid]>arr[mid+1],则说明ans在mid左侧，令right=mid-1
     * 如果arr[mid]<arr[mid+1]，则说明ans在mid右侧，令left=mid+1
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray1(int[] arr) {
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
