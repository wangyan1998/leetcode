package classify.greedymethod;
//给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。
//        返回使字符串任意相邻两个字母不相同的最小删除成本。
//        请注意，删除一个字符后，删除其他字符的成本不会改变。

public class MinCost1578 {
    /**
     * 双指针加贪心算法
     * j永远指向那个没有被删除的元素
     * @param s
     * @param cost
     * @return
     */
    public int minCost(String s,int[] cost){
        int costmin=0;
        int j=0,i=1;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                if(cost[i]>cost[j]){
                    costmin+=cost[j];
                    j=i;
                }else {
                    costmin+=cost[i];
                }
                i++;
            }else{
                j=i;
                i++;

            }

        }
        return costmin;
    }

    /**
     * 同样的方法，String转换成数组就比较快
     * 因为s.charAt()函数很耗时间。
     * @param s
     * @param cost
     * @return
     */
    public int minCost2(String s, int[] cost) {
        char[] r=s.toCharArray();
        int costmin=0;
        int j=0,i=1;
        while(i<r.length){
            if(r[i]==r[j]){
                if(cost[i]>cost[j]){
                    costmin+=cost[j];
                    j=i;
                }else {
                    costmin+=cost[i];
                }
                i++;
            }else{
                j=i;
                i++;

            }

        }
        return costmin;
    }
    /**
     * 贪心算法加局部原理：
     * 首先求局部一串连续相同元素，找到这一串元素中的最大代价
     * 因为相同元素不相邻，所以该局部只需要保留一个就可以了，为了使代价最小，选择保留那个代价最大的
     * @param s
     * @param cost
     * @return
     */
    public int minCost1(String s, int[] cost) {
        int i = 0, len = s.length();
        int ret = 0;
        while (i < len) {
            char ch = s.charAt(i);
            int maxValue = 0;
            int sum = 0;
            while (i < len && s.charAt(i) == ch) {
                maxValue = Math.max(maxValue, cost[i]);
                sum += cost[i];
                i++;
            }
            ret += (sum - maxValue);
        }
        return ret;
    }
}
