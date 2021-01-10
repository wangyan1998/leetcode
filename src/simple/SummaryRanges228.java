package simple;
//给定一个无重复元素的有序整数数组 nums 。
//        返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums
//        的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
//        列表中的每个区间范围 [a,b] 应该按如下格式输出：
//        "a->b" ，如果 a != b
//        "a" ，如果 a == b

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {
    /**
     * 自写双指针法：两个指针分别指向连续顺序的开始和结束，以次遍历，但是代码比较啰嗦，尤其是
     * 边界条件写的不是很好
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums){
       List<String> res=new ArrayList<String>();
       int i=0,j=0;
       while(j<nums.length){
           while(j<nums.length-1){
               if(nums[j]+1==nums[j+1]){
               j++;
               }else {
                   break;
               }
           }
           if(j-i==0){
               String s=Integer.toString(nums[i]);
               res.add(s);
           }else {
               String s=nums[i]+"->"+nums[j];
               res.add(s);
           }
           j++;
           i=j;
       }
       return res;
    }

    /**
     * 按自写思路修改的代码，时间主要花费在if判断和字符串拼接上，所以使用StringBuffer就很好用了
     * @param nums
     * @return
     */
    public List<String> summaryRanges2(int[] nums){
        List<String> res=new ArrayList<String>();
        int i=0,j=0;
        while(j<nums.length){
            while(j<nums.length-1&&nums[j]+1==nums[j+1]){
                j++;
            }
            StringBuffer s = new StringBuffer(Integer.toString(nums[i]));
            if (i < j) {
                s.append("->");
                s.append(Integer.toString(nums[j]));
            }
            res.add(s.toString());
            j++;
            i=j;
        }
        return res;
    }
    /**
     * 题解中的双指针一次遍历法，这里需要强调的是如果边界问题不好判定一定写成前判后的形式
     * 比如判断nums[i]=nums[i-1]+1，这样最后一个边界元素也能判断，而上面自写的那种边界条件
     * 不是很好判断。
     * @param nums
     * @return
     */
    public List<String> summaryRanges1(int[] nums){
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }
}
