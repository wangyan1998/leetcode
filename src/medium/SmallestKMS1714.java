package medium;
//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wy
 * @date 2021/9/3 9:02
 */
public class SmallestKMS1714 {
    public int[] smallestK(int[] arr,int k){
       int[] res=new int[k];
        Arrays.sort(arr);
        for(int i=0;i<k;i++){
            res[i]=arr[i];
        }
        return res;
    }

    /**
     * 堆中取前k个最小值
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK1(int[] arr,int k){
        int[] vec=new int[k];
        if(k==0){
            return vec;
        }
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<k;i++){
            queue.offer(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(queue.peek()>arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for(int i=0;i<k;i++){
            vec[i]=queue.poll();
        }
        return vec;
    }
}

