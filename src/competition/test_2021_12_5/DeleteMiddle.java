package competition.test_2021_12_5;
//给你一个链表的头节点 head 。删除链表的中间节点 ，并返回修改后的链表的头节点 head 。
//        长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
//        对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。

import toolclass.ListNode;

/**
 * @author wy
 * @date 2021/12/5 11:17
 */
public class DeleteMiddle {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        int n = 0;
        ListNode p=head;
        while(p!=null){
            n++;
            p=p.next;
        }
        p=head;
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode q=pre;
        int k=n/2;
        n=0;
        while(n!=k){
            p=p.next;
            q=q.next;
            n++;
        }
        q.next=p.next;
        return pre.next;
    }
}
