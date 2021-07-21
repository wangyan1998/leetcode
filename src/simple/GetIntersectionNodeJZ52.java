package simple;
//输入两个链表，找出它们的第一个公共节点。
import toolclass.ListNode;

/**
 * @author wy
 * @date 2021/7/21 9:13
 */
public class GetIntersectionNodeJZ52 {
    /**
     * 一次遍历找长度差距，继续遍历找公共节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        ListNode res=null;
        ListNode h1=headA,h2=headB;
        int n1=0,n2=0;
        while(h1!=null){
            h1=h1.next;
            n1++;
        }
        while(h2!=null){
            h2=h2.next;
            n2++;
        }
        if(n2>n1){
            int temp=n1;
            n1=n2;
            n2=temp;
            h2=headA;
            h1=headB;
        }else {
            h1=headA;
            h2=headB;
        }
        for(int i=0;i<n1;i++){
            if(i<n1-n2){
            h1=h1.next;
            }else {
                if(h1==h2){
                    res=h1;
                    break;
                }else {
                    h1=h1.next;
                    h2=h2.next;
                }
            }
        }
        return res;
    }
}
