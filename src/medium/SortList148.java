package medium;
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
import toolclass.ListNode;

public class SortList148 {
    public static ListNode sortList(ListNode head){//自写的插入排序，时间超时
      if(head==null||head.next==null){
          return head;
      }
      ListNode pre=new ListNode(0);
      pre.next=head;
      ListNode prel=head;
      ListNode sort=head,last=head.next;
      head=pre;
      while(last!=null){
          while (sort!=last){
              if(sort.val<=last.val){
              sort=sort.next;
              pre=pre.next;
              }else {
                  break;
              }
          }
          if(sort==last){
              prel=last;
              last=last.next;
              pre=head;
              sort=pre.next;
          }else {
          prel.next=last.next;
          last.next=pre.next;
          pre.next=last;
          last=prel.next;
          pre=head;
          sort=pre.next;
          }
      }
      return head.next;
    }
    public static ListNode insertionSortList(ListNode head) {//插入排序147题
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }
    public ListNode sortList1(ListNode head){//自顶向下的归并排序，链表排序首选快慢指针+归并排序
        return sortList2(head,null);
    }
    public ListNode sortList2(ListNode head,ListNode tail){
        if(head==null){
            return head;
        }
        if(head.next==tail){
            head.next=null;
            return head;
        }
        ListNode slow=head,fast=head;
        while(fast!=tail){
            slow=slow.next;
            fast=fast.next;
            if(fast!=tail){
                fast=fast.next;
            }
        }
        ListNode mid=slow;
        ListNode list1=sortList2(head,mid);
        ListNode list2=sortList2(mid,tail);
        ListNode sorted=merge(list1,list2);
        return sorted;
    }
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode dummyHead=new ListNode(0);
        ListNode temp=dummyHead,temp1=head1,temp2=head2;
        while(temp1!=null&&temp2!=null){
            if(temp1.val<=temp2.val){
                temp.next=temp1;
                temp1=temp1.next;
            }else {
                temp.next=temp2;
                temp2=temp2.next;
            }
            temp=temp.next;
        }
        if(temp1!=null){
            temp.next=temp1;
        }else if(temp2!=null){
            temp.next=temp2;
        }
        return dummyHead.next;
    }
    /*
    自底向上的归并排序
     */
    public ListNode sortList3(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge1(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode merge1(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
    public static void main(String[] args) {
        int[] data={-1,5,3,4,0};
        ListNode head=new ListNode(data[0]);
        ListNode p=head;
        int n=data.length;
        for(int i=1;i<n;i++){
            ListNode node=new ListNode(data[i]);
            p.next=node;
            p=node;
        }
        p=sortList(head);

        while(p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }
}
