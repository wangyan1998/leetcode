package esay;

import toolclass.ListNode;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head){//时间复杂度O(n)，空间复杂度O(n)
        List<Integer> vals=new ArrayList<Integer>();
        //复制链表的值到数组
        ListNode currentNode=head;
        while(currentNode!=null){
            vals.add(currentNode.val);
            currentNode=currentNode.next;
        }
        //使用双指针判断回文
        int front=0;
        int back=vals.size()-1;
        while(front<back){
            if(!vals.get(front).equals(vals.get(back))){
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
    public boolean isPalindrome1(ListNode head){
        if(head==null){
            return true;
        }
        //找到前半部分的尾节点并反转后半部分
        ListNode firstHalfEnd=endOfFirstHalf(head);
        ListNode secondHalfStart=reverseList(firstHalfEnd.next);
        //判断是否回文
        ListNode p1=head;
        ListNode p2=secondHalfStart;
        boolean result=true;
        while(result&&p2!=null){
            if(p1.val!= p2.val){
                return false;
            }
            p1=p1.next;
            p2=p2.next;
        }
        firstHalfEnd.next=reverseList(secondHalfStart);
        return  result;
    }
    private ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while (curr!=null){
            ListNode nextTemp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextTemp;
        }
        return prev;
    }
    private ListNode endOfFirstHalf(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
