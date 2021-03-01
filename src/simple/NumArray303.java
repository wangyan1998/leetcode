package simple;
//给定一个整数数组 nums，求出数组从索引i到j（i≤j）范围内元素的总和，包含i、j两点。
//        实现 NumArray 类：
//        NumArray(int[] nums) 使用数组 nums 初始化对象
//        int sumRange(int i, int j) 返回数组 nums 从索引i到j（i≤j）范围内元素的总和，
//        包含i、j两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）

public class NumArray303 {
    private int[] num;
    public NumArray303(int[] nums) {
            num=nums;
    }

    public int sumRange(int i, int j) {
      int sum=0;
      for(int k=i;k<=j;k++){
          sum+=num[k];
      }
      return sum;
    }
}
