package competition.test_2021_11_14;
//给你一个链表的头节点 head 。
//        链表中的节点按顺序划分成若干非空组，这些非空组的长度构成一个自然数序列（1, 2, 3, 4, ...）。
//        一个组的 长度 就是组中分配到的节点数目。换句话说：
//        节点 1 分配给第一组
//        节点 2 和 3 分配给第二组
//        节点 4、5 和 6 分配给第三组，以此类推
//        注意，最后一组的长度可能小于或者等于1+倒数第二组的长度 。
//        反转每个偶数长度组中的节点，并返回修改后链表的头节点 head 。

import toolclass.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wy
 * @date 2021/11/14 10:40
 */
public class ReverseEvenLengthGroups {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int idx = 2;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        ListNode h = head;
        ListNode p=h.next;
        int pos = idx;
        while (pos>0&&p.next!=null) {
            if(idx%2==0){
                while(pos>0&&p.next!=null){
                    deque.push(p.val);
                    p=p.next;
                    pos--;
                }
                while(!deque.isEmpty()){
                    p=h.next;
                    p.val=deque.pop();
                    p=p.next;
                }
            }else {
                while(pos>0&&p.next!=null){
                   p=p.next;
                   pos--;
                }
            }
            h=p;
            idx++;
            pos=idx;
        }
        return head;
    }
}
