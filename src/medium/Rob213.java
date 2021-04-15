package medium;
//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
//        这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
//        如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
//        给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。


/**
 * @author wy
 * @date 2021/4/15 8:51
 */
public class Rob213 {
    /**
     * 动态规划：
     * 如果只有一间房屋，直接取就可以，如果有两间房屋，只能选择其中金额比较大的一个
     * 因为房子首尾相连，所以首尾不能同时偷窃，所以如果不取最后一个，范围是[0,n-2]
     * 如果不取第一个，范围是[1,n-1]
     * 用dp[i]表示在下标范围[start,i]内可以偷窃到的最高总金额，就有如下转移方程：
     *    dp[i]=max(dp[i-2]+nums[i],dp[i-1])
     * @param nums
     * @return
     */
    public  int rob(int[] nums){
       int length=nums.length;
       if(length==1){
           return nums[0];
       }else if(length==2){
           return Math.max(nums[0],nums[1]);
       }
       return Math.max(robRange(nums,0,length-2),robRange(nums,1,length-1));
    }

    public int robRange(int[] nums,int start,int end){
        int first=nums[start],second=Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<=end;i++){
            int temp=second;
            second=Math.max(first+nums[i],second);
            first=temp;
        }
        return second;
    }
}
