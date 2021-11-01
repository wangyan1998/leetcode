package competition.test_2021_10_31;
//链表中的 临界点 定义为一个 局部极大值点 或 局部极小值点 。
//        如果当前节点的值 严格大于 前一个节点和后一个节点，那么这个节点就是一个  局部极大值点 。
//        如果当前节点的值 严格小于 前一个节点和后一个节点，那么这个节点就是一个  局部极小值点 。
//        注意：节点只有在同时存在前一个节点和后一个节点的情况下，才能成为一个 局部极大值点 / 极小值点 。
//        给你一个链表 head ，返回一个长度为 2 的数组 [minDistance, maxDistance] ，其中 minDistance
//        是任意两个不同临界点之间的最小距离，maxDistance 是任意两个不同临界点之间的最大距离。如果临界点少于两个，则返回 [-1，-1] 。
import toolclass.ListNode;

import java.util.regex.Matcher;

/**
 * @author wy
 * @date 2021/10/31 10:36
 */
public class NodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head){
        int predata=head.val;
        int firstidx=-1,preidx=0;
        int maxdis=-1,mindis=100000;
        int i=0;
        int count=0;
        ListNode p=head;
        while(p.next!=null&&p.next.next!=null){
            predata=p.val;
            p=p.next;
            i++;
            if((p.val>predata&&p.val>p.next.val)||(p.val<predata&&p.val<p.next.val)){
                count++;
                if(firstidx==-1){
                    firstidx=i;
                    preidx=i;
                }else {
                    maxdis=i-firstidx;
                    mindis= Math.min(mindis,i-preidx);
                    preidx=i;
                }
            }
        }
       if(count<2){
           return new int[]{-1,-1};
       }else {
           return new int[]{mindis,maxdis};
       }
    }
}
