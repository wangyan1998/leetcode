package simple;
//有一堆石头，每块石头的重量都是正整数。
//        每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。
//        那么粉碎的可能结果如下：
//        如果x == y，那么两块石头都会被完全粉碎；
//        如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
//        最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。

import java.util.Arrays;

public class LastStoneWeight1046 {
    public int lastStoneWeight(int[] stones){
        for(int i=0;i<stones.length-1;++i){
            Arrays.sort(stones);
            stones[stones.length-1]-=stones[stones.length-2];
            stones[stones.length-2]=0;
        }
       Arrays.sort(stones);
        return stones[stones.length-1];
    }
}
