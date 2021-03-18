package medium;
//给你单链表的头指针 head 和两个整数left 和 right ，
//        其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。


import toolclass.ListNode;

public class ReverseBetween92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
