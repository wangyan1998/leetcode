package esay;
//给定一个非空且只包含非负数的整数数组nums，数组的度的定义是指数组里任一元素出现频数的最大值。
//        你的任务是在 nums 中找到与nums拥有相同大小的度的最短连续子数组，返回其长度。

import java.util.HashMap;
import java.util.Map;

public class FindShortestSubArray697 {
    /**
     * 统计方法：统计每一个元素的个数和第一个出现的位置以及最后一个出现的位置，查找出现次数最大
     * 而且初始结束位置差最小的元素
     * @param nums
     * @return
     */
    public  int findShortestSubArray(int[] nums){
        Map<Integer,int[]> map=new HashMap<Integer, int[]>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i])[0]++;
                map.get(nums[i])[2]=i;
            }else {
                map.put(nums[i],new int[]{1,i,i});
            }
        }
        int maxNum=0,minLen=0;
        for(Map.Entry<Integer,int[]> entry:map.entrySet()){
            int[] arr=entry.getValue();
            if(maxNum<arr[0]){
                maxNum=arr[0];
                minLen=arr[2]-arr[1]+1;
            }else if(maxNum==arr[0]){
                if(minLen>arr[2]-arr[1]+1){
                    minLen=arr[2]-arr[1]+1;
                }
            }
        }
        return minLen;
    }
}
