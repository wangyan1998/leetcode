package medium;
//给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
//        每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
//        这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
//        返回一个符合上述规则的链表的列表。
//        举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]


import toolclass.ListNode;

import java.util.List;

/**
 * @author wy
 * @date 2021/9/22 8:29
 */
public class SplitListToParts725 {
    /**
     * 先求出链表的长度，对k取余为d和整除为l，前d个部分长度为l+1,其余的部分长度为l。
     * @param head
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode head,int k){
        ListNode h=head;
        int length=0;
        while(h!=null){
            length++;
            h=h.next;
        }
        int d=length%k;
        int l=length/k;
        h=head;
        ListNode[] res=new ListNode[k];
        int idx=0;
        for(int i=0;i<k&&h!=null;i++){
            res[i]=h;
            int size=l+(i<d?1:0);
            for(int j=1;j<size;j++){
                h=h.next;
            }
            ListNode next=h.next;
            h.next=null;
            h=next;
        }
        return res;
    }
}
