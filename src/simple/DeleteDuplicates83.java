package simple;
//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
//        返回同样按升序排列的结果链表。
import toolclass.ListNode;

public class DeleteDuplicates83 {
    public ListNode deleteDuplicates(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode p=head;
        ListNode q=head.next;
        while(q!=null){
            if(p.val==q.val){
                q=q.next;
                p.next=q;
            }else {
                p=q;
                q=q.next;
            }
        }
        return head;
    }
}
