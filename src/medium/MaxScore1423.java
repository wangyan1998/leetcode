package medium;
//几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
//        每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
//        你的点数就是你拿到手中的所有卡牌的点数之和。
//        给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。

import java.util.Arrays;

public class MaxScore1423 {
    /**
     * 记数组 cardPoints 的长度为 n，由于只能从开头和末尾拿 k 张卡牌，
     * 所以最后剩下的必然是连续的 n−k 张卡牌。
     * 我们可以通过求出剩余卡牌点数之和的最小值，来求出拿走卡牌点数之和的最大值。
     *设置n-k的窗口，求该窗口的和的最小值，剩下的就是最大值。
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore(int[] cardPoints,int k){
        int n = cardPoints.length;
        // 滑动窗口大小为 n-k
        int windowSize = n - k;
        // 选前 n-k 个作为初始值
        int sum = 0;
        for (int i = 0; i < windowSize; ++i) {
            sum += cardPoints[i];
        }
        int minSum = sum;
        for (int i = windowSize; i < n; ++i) {
            // 滑动窗口每向右移动一格，增加从右侧进入窗口的元素值，并减少从左侧离开窗口的元素值
            sum += cardPoints[i] - cardPoints[i - windowSize];
            minSum = Math.min(minSum, sum);
        }
        return Arrays.stream(cardPoints).sum() - minSum;
    }

    /**
     * 将两头按顺序排好，使用窗口大小为k的滑动窗口，求和的最大值
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore1(int[] cardPoints,int k){
        int[] window=new int[2*k];
        int j=0;
        for(int i=k-1;i>=0;i--){
            window[j]=cardPoints[i];
            j++;
        }
        for(int i=cardPoints.length-1;i>=cardPoints.length-k;i--){
            window[j]=cardPoints[i];
            j++;
        }
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=window[i];
        }
        int maxsum=sum;
        for(int i=k;i<2*k;i++){
            sum=sum-window[i-k]+window[i];
            maxsum=Math.max(maxsum,sum);
        }
        return maxsum;
    }

}
