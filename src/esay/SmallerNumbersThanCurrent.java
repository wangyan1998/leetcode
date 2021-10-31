package esay;

import java.util.Arrays;
import java.util.Comparator;

public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums){//暴力法
        int n=nums.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=0;
            for(int j=0;j<n;j++){
              if(nums[j]<nums[i]){
                  res[i]++;
              }
            }
        }
        return res;
    }
    public int[] smallerNumbersThanCurrent1(int[] nums){//排序，记录原来的位置，统计
        int n=nums.length;
        int[][] data=new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0]=nums[i];
            data[i][1]=i;
        }
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] data1, int[] data2) {
                return data1[0]-data2[0];
            }
        });
        int[] ret=new int[n];
        int prev=-1;
        for (int i = 0; i < n; i++) {
            if(prev==-1||data[i][0]!=data[i-1][0]){
                prev=i;
            }
            ret[data[i][1]]=prev;
        }
        return ret;
    }
}
