package classify.dp;
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//        子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
//        例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

public class LengthOfLIS300 {
    /*
    res[i]表示以num[i]结尾的最长递增子序列长度
     */
    public int lengthOfLIS(int[] nums){
        int[] res=new int[nums.length];
        int max=0;
        for(int i=0;i<nums.length;++i){
            res[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){//如果递增，加一，和当前赋值比较，看看哪个更长
                    res[i]=Math.max(res[i],res[j]+1);
                }
            }
            max=Math.max(res[i],max);
        }
        return max;
    }
}
