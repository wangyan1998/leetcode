package esay;
//给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
//        初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，
//        这样它就有足够的空间保存来自 nums2 的元素。


import java.util.Arrays;

/**
 * @author wy
 * @date 2021/4/5 9:37
 */
public class Merge88 {
    public void merge(int[] nums1,int m,int[] nums2,int n){
        for(int i=m;i<m+n;i++){
            nums1[i]=nums2[i-m];
        }
        Arrays.sort(nums1);
    }
}
