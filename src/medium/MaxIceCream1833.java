package medium;
//夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
//        商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。
//        Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
//        给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
//        注意：Tony 可以按任意顺序购买雪糕。


import java.util.Arrays;

/**
 * @author wy
 * @date 2021/7/2 8:40
 */
public class MaxIceCream1833 {
    /**
     * 不变的价格，尽量选取便宜的，才能买到尽可能多的雪糕
     * @param costs
     * @param coins
     * @return
     */
    public int maxIceCream(int[] costs,int coins){
        int sum=0;
        Arrays.sort(costs);
        int i=0;
        boolean flag=true;
        while(sum<=coins){
            if(i==costs.length){
                flag=false;
                break;
            }
            sum+=costs[i];
            i++;
        }
        if(flag==false){
            return i;
        }
        return i-1;
    }

    /**
     * 排序+贪心算法
     * @param costs
     * @param coins
     * @return
     */
    public int maxIceCream1(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        int n = costs.length;
        for (int i = 0; i < n; i++) {
            int cost = costs[i];
            if (coins >= cost) {
                coins -= cost;
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    /**
     * 计数排序，降低排序的复杂度
     * @param costs
     * @param coins
     * @return
     */
    public int maxIceCream2(int[] costs, int coins) {
        int[] freq = new int[100001];
        for (int cost : costs) {
            freq[cost]++;
        }
        int count = 0;
        for (int i = 1; i <= 100000; i++) {
            if (coins >= i) {
                int curCount = Math.min(freq[i], coins / i);
                count += curCount;
                coins -= i * curCount;
            } else {
                break;
            }
        }
        return count;
    }
}
