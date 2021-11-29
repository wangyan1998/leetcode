package hard;
//给你一个按递增顺序排序的数组arr和一个整数k。数组arr由1和若干素数组成，且其中所有整数互不相同。
//        对于每对满足0<i<j<arr.length的i和j，可以得到分数arr[i]/arr[j] 。
//        那么第k个最小的分数是多少呢?以长度为 2 的整数数组返回你的答案, 这里answer[0]==arr[i]且answer[1]==arr[j] 。

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author wy
 * @date 2021/11/29 9:42
 */
public class KthSmallestPrimeFraction786 {
    /**
     * 暴力方法
     * @param arr
     * @param k
     * @return
     */
    public int[] kthSmallestPrimeFraction(int[] arr,int k){
        int n=arr.length;
        List<int[]> frac=new ArrayList<int[]>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                frac.add(new int[]{arr[i],arr[j]});
            }
        }
        Collections.sort(frac,(x,y)->x[0]*y[1]-y[0]*x[1]);
        return frac.get(k-1);
    }

    /**
     * 优先队列
     * @param arr
     * @param k
     * @return
     */
    public int[] kthSmallestPrimeFraction1(int[] arr,int k){
        int n=arr.length;
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((x,y)->arr[x[0]]*arr[y[1]]-arr[y[0]]*arr[x[1]]);
        for(int j=1;j<n;j++){
            pq.offer(new int[]{0,j});
        }
        for(int i=1;i<k;i++){
            int[] frac=pq.poll();
            int x=frac[0],y=frac[1];
            if(x+1<y){
                pq.offer(new int[]{x+1,y});
            }
        }
        return new int[]{arr[pq.peek()[0]],arr[pq.peek()[1]]};
    }
}
