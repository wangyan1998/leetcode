package medium;
//超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
//        给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
//        题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。


import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author wy
 * @date 2021/8/9 10:40
 */
public class NthSuperUglyNumber313 {
    public int nthSuperUglyNumber(int n,int[] primes){
        Set<Long> seen=new HashSet<Long>();
        PriorityQueue<Long> heap=new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly=0;
        for(int i=0;i<n;i++){
            long curr=heap.poll();
            ugly=(int)curr;
            for(int prime:primes){
                long next=curr*prime;
                if(seen.add(next)){
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}
