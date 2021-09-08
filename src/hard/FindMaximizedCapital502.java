package hard;
//假设力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，力扣希望在IPO之前开展一些项目以增加其资本。
//        由于资源有限，它只能在IPO之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
//        给你 n 个项目。对于每个项目 i ，它都有一个纯利润profits[i] ，和启动该项目需要的最小资本 capital[i] 。
//        最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
//        总而言之，从给定项目中选择最多k个不同项目的列表,以最大化最终资本，并输出最终可获得的最多资本。
//        答案保证在32位有符号整数范围内。


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author wy
 * @date 2021/9/8 8:45
 */
public class FindMaximizedCapital502 {
    /**
     * 贪心算法：
     * 如果初始资本w>max(captial)，直接返回利润中的k个最大元素即可
     * 因为题目限制了次数k,我们应该贪心的保证选择每次投资的项目获取的利润最大，这样就能保持选择k次后获得的利润最大
     * 首先将项目按照所需资本从小到大排序，每次进行选择时，假设手中资本为w，我们应该从所有投入的资本小于等于w的项目中
     * 选择利润最大的项目j，然后此时我们更新手中的资本为w+profits[j],同时再从所有花费资本小于等于w+profits[j]的项目中
     * 选择，按照上述规则不断选择k次即可。
     * 我们利用大根堆的性质，将所有能够投资的项目得利润全部压入到堆中，每次从堆中取出最大值，然后更新手中的资本，同时将待选项目
     * 利润进入堆。
     * 如果当前堆为空，则此时我们应该直接返回。
     * @param k
     * @param w
     * @param profits
     * @param capital
     * @return
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
       int n=profits.length;
       int curr=0;
       int[][] arr=new int[n][2];
       for(int i=0;i<n;i++){
           arr[i][0]=capital[i];
           arr[i][1]=profits[i];
       }
       Arrays.sort(arr,(a,b)->a[0]-b[0]);
       PriorityQueue<Integer> pq=new PriorityQueue<Integer>((x,y)->y-x);
       for(int i=0;i<k;i++){
           while(curr<n&&arr[curr][0]<=w){
               pq.add(arr[curr][1]);
               curr++;
           }
           if(!pq.isEmpty()){
               w+=pq.poll();
           }else {
               break;
           }
       }
       return w;
    }
}
