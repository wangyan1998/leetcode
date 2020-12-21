package classify.array;
//给定两个大小为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的中位数。
//        进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？

import java.util.Arrays;

public class FindMedianSortedArrays4 {
    public double findMedianSortedArray(int[] nums1,int[] nums2){
        int n=nums1.length+nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res=new int[n];
        int n1=0,n2=0,i=0;
        while(n1<nums1.length&&n2<nums2.length){
            if(nums1[n1]<nums2[n2]){
                res[i]=nums1[n1];
                n1++;
            }else {
                res[i]=nums2[n2];
                n2++;
            }
            i++;
        }
        while(n1<nums1.length){
            res[i]=nums1[n1];
            i++;
            n1++;
        }
        while (n2<nums2.length){
            res[i]=nums2[n2];
            i++;
            n2++;
        }
        if(n%2==0){
            return (res[n/2-1]+res[n/2])/2.0;
        }else {
            return res[n/2]/1.0;
        }
    }
}
