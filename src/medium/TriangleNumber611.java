package medium;
//给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/8/4 9:21
 */
public class TriangleNumber611 {
    /**
     * 排序+二分查找
     * 三个数组成三角形的条件是a+b>c,a+c>b,b+c>a;我们如果把三条边排序使之a<b<c,那么a+c>b,b+c>a一定成立
     * 只需要再满足a+b>c即可。
     * 我们可以将数组进行排序，使用两层循环枚举a,b,nums[i]=a,nums[j]=b；c的选择是关键，我们可以从[j+1,n-1]里
     * 找最后面的小于nums[i]+nums[j]的位置记为k,[j+1，k]之间的数值都可以作为第三边c
     * 这样依次把情况相加即可。
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums){
        Arrays.sort(nums);
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int left=j+1,right=n-1,k=j;
                while(left<=right){
                    int mid=(left+right)/2;
                    if(nums[mid]<nums[i]+nums[j]){
                        k=mid;
                        left=mid+1;
                    }else {
                        right=mid-1;
                    }
                }
                ans+=k-j;
            }
        }
        return ans;
    }

    /**
     * 排序+双指针
     * 对于nums[k]<nums[i]+nums[j]，如果我们设定i不变，随着j的增大，k的值也是增大的。
     * 所以这是一个双指针递增问题。
     * 每一次不用从j+1开始，从上一次的k增加即可。
     * @param nums
     * @return
     */
    public int triangleNumber1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int k = i;
            for (int j = i + 1; j < n; ++j) {
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                    ++k;
                }
                ans += Math.max(k - j, 0);
            }
        }
        return ans;
    }
}
