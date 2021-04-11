package medium;
//给你一个整数 n ，请你找出并返回第 n 个 丑数 。丑数 就是只包含质因数 2、3 和/或 5 的正整数。

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author wy
 * @date 2021/4/11 9:27
 */
public class NthUglyNumber264 {
    /**
     * 一个一个试，时间太长
     * @param n
     * @return
     */
    public int nthUglyNumber(int n){
       int count=0;
       int i=0;
       int last=0;
       while(count<n){
           if(isUgly(i)){
               count++;
               last=i;
           }
           i++;
       }
       return last;
    }
    public boolean isUgly(int n){
        if(n<=0){
            return false;
        }
        int[] factors={2,3,5};
        for(int factor:factors){
            while(n%factor==0){
                n=n/factor;
            }
        }
        return n==1;
    }

    /**
     * 如果x是丑数，2x,3x,5x都是丑数，只要利用SET去重计数就可以了
     * @param n
     * @return
     */
    public int nthUglyNumber1(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}