package esay;
//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
//        不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

/**
 * @author wy
 * @date 2021/4/18 9:49
 */
public class RemoveDuplicates26 {
    public static int removeDuplicates(int[] nums){
        int n=nums.length;
        if(n==0||n==1){
            return n;
        }
        int j=1;
        int i=0;
        for(;j<n;j++){
            if(nums[j]==nums[j-1]){
                i=j;
                while(i<n){
                    nums[i-1]=nums[i];
                    i++;
                }
                j--;
                n--;
            }
        }
        return n;
    }

    public int removeDuplicates1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }


    public static void main(String[] args) {
        int[] nums={1,1,2};
        removeDuplicates(nums);
    }
}
