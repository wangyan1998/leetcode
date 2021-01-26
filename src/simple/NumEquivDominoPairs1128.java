package simple;
//给你一个由一些多米诺骨牌组成的列表dominoes。
//        如果其中某一张多米诺骨牌可以通过旋转 0度或 180 度得到另一张多米诺骨牌，
//        我们就认为这两张牌是等价的。
//        形式上，dominoes[i] = [a, b]和dominoes[j] = [c, d]等价的前提是a==c且b==d，
//        或是a==d 且b==c。
//        在0 <= i < j < dominoes.length的前提下，找出满足dominoes[i] 和dominoes[j]等价的骨牌对
//        (i, j) 的数量。
//          1 <= dominoes.length <= 40000
//          1 <= dominoes[i][j] <= 9

import java.util.*;

public class NumEquivDominoPairs1128 {
    /**
     * 单独哈希映射，每个数组元素对应一个十进制的数，把每个数组排序，最后求得数值一样的数都是
     * @param dominoes
     * @return
     */
    public int numEquivDominoPairs(int[][] dominoes){
       int[] num=new int[100];
       int ret=0;
       for(int[] domino:dominoes){
           int val=domino[0]<domino[1]?domino[0]*10+domino[1]:domino[1]*10+domino[0];
           ret+=num[val];
           num[val]++;
       }
       return ret;
    }
}
