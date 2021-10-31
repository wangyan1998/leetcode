package esay;
//给定一个整数数组A，如果它是有效的山脉数组就返回true，否则返回 false。
//        让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
//        A.length >= 3
//        在0 < i< A.length - 1条件下，存在i使得：
//        A[0] < A[1] < ... A[i-1] < A[i]
//        A[i] > A[i+1] > ... > A[A.length - 1]


public class ValidMountainArray {
    public boolean validMountainArray(int[] A){//双指针，两边上山，交汇于一点
    int len=A.length;
    int left=0;
    int right=len-1;
    while(left+1<len&&A[left]<A[left+1]){
        left++;
    }
    while (right>0&&A[right-1]>A[right]){
        right--;
    }
    return left>0&&right<len-1&&left==right;
    }
    public boolean validMountainArray1(int[] A){
        int n=A.length;
        int i=0;
        //递增扫描
        while(i+1<n&&A[i]<A[i+1]){
            i++;
        }
        //最高点本鞥时数组的第一个位置或者最后一个位置
        if(i==0||i==n-1){
            return false;
        }
        //递减扫描
        while (i+1<n&&A[i]>A[i+1]){
            i++;
        }
        return i==n-1;
    }
}
