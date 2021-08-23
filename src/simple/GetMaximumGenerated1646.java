package simple;
//给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
//        nums[0] = 0
//        nums[1] = 1
//        当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
//        当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
//        返回生成数组 nums 中的 最大 值。


/**
 * @author wy
 * @date 2021/8/23 9:18
 */
public class GetMaximumGenerated1646 {
    /**
     * 直接设定数组，求值即可
     * @param n
     * @return
     */
    public int getMaximumGenerated(int n){
        if(n==0||n==1){
            return n;
        }
        int max=1;
        int[] nums=new int[n+1];
        nums[0]=0;
        nums[1]=1;
        for(int i=2;i<=n;i++){
            if(i%2==0){
               nums[i]=nums[i/2];
            }else {
                nums[i]=nums[i/2]+nums[i/2+1];
            }
            max=Math.max(max,nums[i]);
        }
        return max;
    }
}
