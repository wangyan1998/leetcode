package medium;
//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置

import toolclass.ListNode;

public class RotateRight61 {
    /**
     * 先把最后一个元素连起来，然后确定好断开该链的位置
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode p, q;
        p = head;
        int c = 1;//记录链表的节点数目
        while (p.next != null) {
            p = p.next;
            c++;
        }
        q = p;
        p.next = head;
        p = head;
        int x = c - (k % c);//确定断开的位置
        for (int i = 0; i < x; i++) {
            q = p;
            p = p.next;
        }
        q.next = null;
        return p;
    }
}
