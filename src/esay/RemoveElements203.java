package esay;

import toolclass.ListNode;

/**
 * @author wy
 * @date 2021/6/5 16:36
 */
public class RemoveElements203 {
    /**
     * 加头结点双指针法
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head,int val){
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode p=pre;
        ListNode q=head;
        while(q!=null){
            if(q.val==val){
                p.next=q.next;
                q=p.next;
            }else {
                p=q;
                q=p.next;
            }
        }
        return pre.next;
    }

    /**
     * 递归方法
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     * 迭代，和第一种方法类似
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }
}
