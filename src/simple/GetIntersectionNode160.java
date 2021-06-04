package simple;
//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
import toolclass.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wy
 * @date 2021/6/4 9:20
 */
public class GetIntersectionNode160 {
    /**
     * 先求两个链表长度la,lb，从较长的链表开始，先走|la-lb|步，然后两个链表一起前进，知道指向同一个节点，否则返回null
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        ListNode p=headA;
        ListNode q=headB;
        int la=0;
        int lb=0;
       while(p!=null){
           la++;
           p=p.next;
       }
       while(q!=null){
           lb++;
           q=q.next;
       }
       p=headA;
       q=headB;
       if(la>lb){
           for(int i=0;i<la-lb;i++){
               p=p.next;
           }
       }else {
           for(int i=0;i<lb-la;i++){
               q=q.next;
           }
       }
       while(p!=null&&q!=null){
           if(p==q){
               return p;
           }else {
               p=p.next;
               q=q.next;
           }
       }
       return null;
    }

    /**
     * 哈希集合
     * 首先遍历链表A，并将链表A的每个结点加入哈希集合中，然后遍历链表B，对于遍历到的每个结点，判断该节点是否子哈希集合中：
     * 如果不在，则继续遍历下一个节点
     * 如果在，则后面的的节点都在，B遍历到的第一个存在的节点就是相交的第一个节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode0(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    /**
     * 双指针：只有当两个链表都不为空的时候才会相交
     * 如果A为空，就把指针移动到B的初始节点，同样的，如果B为空，就把指针移动到A的初始节点，这样除了公共部分，两个指针各遍历了两个链表的非公共
     * 部分，遍历的长度是一样的，最后一定会在第一个公共节点汇合
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
