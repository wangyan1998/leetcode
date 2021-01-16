package classify.tencent;
//给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，
//        并且每个节点只能存储一位数字。
//        请你将两个数相加，并以相同形式返回一个表示和的链表。
//        你可以假设除了数字0之外，这两个数都不会以0开头。

import toolclass.ListNode;

public class AddTwoNumbers2 {
    /**
     * 自写方法，啰嗦，代码不优雅
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
       ListNode head=new ListNode((l1.val+l2.val)%10);
       int b=0;
       b=(l1.val+l2.val)/10;
       l1=l1.next;
       l2=l2.next;
       ListNode res=head;
       while(l1!=null||l2!=null){
           if(l1==null){
               ListNode node=new ListNode((l2.val+b)%10);
               b=(l2.val+b)/10;
               res.next=node;
               res=node;
               l2=l2.next;
               continue;
           }
           if(l2==null){
               ListNode node=new ListNode((l1.val+b)%10);
               b=(l1.val+b)/10;
               res.next=node;
               res=node;
               l1=l1.next;
               continue;
           }
           ListNode node=new ListNode((l1.val+l2.val+b)%10);
           b=(l1.val+l2.val+b)/10;
           res.next=node;
           res=node;
           l1=l1.next;
           l2=l2.next;
       }
       if(b!=0){
           ListNode node=new ListNode(b);
           res.next=node;
           res=node;
       }
       return head;
    }

    /**
     * 题解算法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumber1(ListNode l1,ListNode l2){
        ListNode head = null, tail = null;
        int carry = 0;//进位
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
