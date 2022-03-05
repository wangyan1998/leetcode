package medium;
//给定一组正整数，相邻的整数之间将会进行浮点除法操作。例如，[2,3,4] -> 2 / 3 / 4 。
//        但是，你可以在任意位置添加任意数目的括号，来改变算数的优先级。你需要找出怎么添加括号，
//        才能得到最大的结果，并且返回相应的字符串格式的表达式。你的表达式不应该含有冗余的括号。
//        输入数组的长度在 [1, 10] 之间。
//        数组中每个元素的大小都在 [2, 1000] 之间。
//        每个测试用例只有一个最优除法解。
/**
 * @author wy
 * @date 2022/2/27 18:22
 */
public class OptimalDivision553 {
    /**
     * 除法运算可以表示为分数的形式，其中分子为x,分母为y，为了最大化x/y，则可以使得x最大，y最小。对于序列，x=nums[0]时最大，
     * 它除以后面的任何组合都会变小，所以我们只需要考虑y最小，即对{nums[1],nums[2]......nums[n-1]}进行组合使之最小即可。
     * 因为数组中的每个元素都大于1，所以越除越小，肯定是y=nums[1]/nums[2]/....../nums[n-1]最小。综上，最优的除法肯定是
     * nums[0]/(nums[1]/nums[2]/nums[3]/.....nums[n-1])
     * @param nums
     * @return
     */
    public String optimalDivision(int[] nums){
        int n=nums.length;
        if (n==1){
            return String.valueOf(nums[0]);
        }
        if (n==2){
            return String.valueOf(nums[0])+'/'+String.valueOf(nums[1]);
        }
        StringBuffer res=new StringBuffer();
        res.append(nums[0]);
        res.append("/(");
        res.append(nums[1]);
        for (int i=2;i<n;i++){
            res.append("/");
            res.append(nums[i]);
        }
        res.append(")");
        return res.toString();
    }
}
