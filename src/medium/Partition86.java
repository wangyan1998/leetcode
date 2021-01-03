package medium;
//给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
//        你应当保留两个分区中每个节点的初始相对位置。
import toolclass.ListNode;

public class Partition86 {
    /**
     * 原地修改，指针之间的转换比较麻烦
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head,int x){
        ListNode q=new ListNode();
        ListNode p=head;
        q.next=head;
        ListNode res=q;
        while(p!=null&&p.val<x){
            q=q.next;
            p=p.next;
        }
        ListNode r=q;
        ListNode s=p;
       while(p!=null){
           if(p.val<x){
               q.next=p.next;
               r.next=p;
               p.next=s;
               r=p;
               p=q.next;
           }else {
               q = p;
               p = p.next;
           }
       }
       return res.next;
    }

    /**
     * 双链表法，只需要维护两个链表，一个存放大于等于x的元素，一个存放小于x的元素
     * @param head
     * @param x
     * @return
     */
     public ListNode partition1(ListNode head,int x){
         ListNode head1=new ListNode(0);
         ListNode head2=new ListNode(0);
         ListNode h1=head1,h2=head2;
         ListNode p=head;
         while(p!=null){
             if(p.val<x){
                 head1.next=p;
                 head1=head1.next;
             }else {
                 head2.next=p;
                 head2=head2.next;
             }
             p=p.next;
         }
         head1.next=h2.next;
         head2.next=null;
         return h1.next;
     }
}
