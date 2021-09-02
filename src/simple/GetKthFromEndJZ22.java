package simple;
//链表中的倒数第k个节点
// 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
//        例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。


import toolclass.ListNode;

/**
 * @author wy
 * @date 2021/9/2 8:55
 */
public class GetKthFromEndJZ22 {
    public ListNode getKthFromEnd(ListNode head,int k){
       int n=0;
       ListNode h=head;
       while(h!=null){
           n++;
           h=h.next;
       }
       int c=n-k;
       h=head;
       while(c>0){
           h=h.next;
           c--;
       }
       return h;
    }

    public ListNode getKthFromEnd1(ListNode head, int k) {
        int n = 0;
        ListNode node = null;

        for (node = head; node != null; node = node.next) {
            n++;
        }
        for (node = head; n > k; n--) {
            node = node.next;
        }

        return node;
    }

    /**
     * 双指针
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
