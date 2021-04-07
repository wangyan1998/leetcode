package medium;
//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
//        不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。


/**
 * @author wy
 * @date 2021/4/7 8:34
 */
public class RemoveDuplicates80 {
    /**
     * 计数平移法，对每一个数进行计数，当当前值和前一个值不同时，判断计数是否大于2，如果大于2，将数组后面的数平移
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums){
        int count=1;
        int j=nums.length;
        if(j<3){
            return j;
        }
        for(int i=1;i<j;i++){
            if(nums[i]==nums[i-1]){
                count++;
            }
            if(nums[i]!=nums[i-1]||i==(j-1)){
                if(count>2){
                    int k=count-2;
                    for(int c=i;c<j;c++){
                        nums[c-k]=nums[c];
                    }
                    j=j-k;
                    i=i-k;
                }
                count=1;
            }
        }
        return j;
    }

    public int removeDuplicates1(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
