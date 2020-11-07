package hard;
//给定一个整数数组nums，返回区间和在[lower, upper]之间的个数，包含lower和upper。
//        区间和S(i, j)表示在nums中，位置从i到j的元素之和，包含i和j(i ≤ j)。
//        说明:
//        最直观的算法复杂度是O(n^2) ，请在此基础上优化你的算法。


public class CountRangeSum {
    public int countRangeSum(int[] nums,int lower,int upper){
        int n=nums.length;
        long sum;
        int count=0;
     for(int i=0;i<n;i++){
         for(int j=i;j<n;j++){
             sum=getsum(nums,i,j);
             System.out.println(sum+" "+i+","+j);
             if(sum>=lower&&sum<=upper){
                 count++;
             }
         }
     }
     return count;
    }
    public  long getsum(int[] nums,int l,int u){
        long sum=0;
        for(int i=l;i<=u;i++){
            sum=sum+nums[i];
        }
        return sum;
    }
}
