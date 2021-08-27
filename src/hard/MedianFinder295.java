package hard;
//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
//        例如，
//        [2,3,4]的中位数是 3
//        [2,3] 的中位数是 (2 + 3) / 2 = 2.5
//        设计一个支持以下两种操作的数据结构：
//        void addNum(int num) - 从数据流中添加一个整数到数据结构中。
//        double findMedian() - 返回目前所有元素的中位数。


import java.util.PriorityQueue;

/**
 * @author wy
 * @date 2021/8/27 9:06
 */
public class MedianFinder295 {
    /**
     * 用两个优先队列queMax和queMin 分别记录大于中位数的数和小于等于中位数的数。
     * 当累计添加的数的数量为奇数时，queMin中的数的数量比queMax多一个，此时中位数为queMin的队头。
     * 当累计添加的数的数量为偶数时，两个优先队列中的数的数量相同，此时中位数为它们的队头的平均值。
     * 当我们尝试添加一个数 num 到数据结构中，我们需要分情况讨论：
     *num≤max{queMin}
     * 此时num 小于等于中位数，我们需要将该数添加到 queMin 中。新的中位数将小于等于原来的中位数，
     * 因此我们可能需要将 queMin 中最大的数移动到queMax 中。
     * num>max{queMin}
     * 此时num 大于中位数，我们需要将该数添加到queMin 中。新的中位数将大于等于原来的中位数，
     * 因此我们可能需要将queMax 中最小的数移动到 queMin 中。
     * 当累计添加的数的数量是0时，我们将num添加到queMin
     */
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;
    /** initialize your data structure here. */
    public MedianFinder295() {
       queMin=new PriorityQueue<Integer>((a,b)->(b-a));
       queMax=new PriorityQueue<Integer>((a,b)->(a-b));
    }

    public void addNum(int num) {
       if(queMin.isEmpty()||num<=queMin.peek()){
           queMin.offer(num);
           if(queMax.size()+1<queMin.size()){
               queMax.offer(queMin.poll());
           }
       }else {
           queMax.offer(num);
           if(queMax.size()>queMin.size()){
               queMin.offer(queMax.poll());
           }
       }
    }

    public double findMedian() {
       if(queMin.size()>queMax.size()){
           return queMin.peek();
       }
       return (queMin.peek()+queMax.peek())/2.0;
    }
}
