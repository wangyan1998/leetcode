package medium;
//给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
//        请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

import toolclass.ListNode;

public class OddEventList328 {
 public ListNode oddEventList(ListNode head){//双指针法
     if(head==null){
     }else {
     ListNode a,b,head1;
     a=head;
     b=head.next;
     head1=head.next;
     while(a.next!=null&&b.next!=null){
         a.next=b.next;
         a=a.next;
         b.next=a.next;
         b=b.next;
     }
     a.next=head1;
     }
     return head;
 }
}
