package medium;
//多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。
//        这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
//        给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。


import toolclass.Node;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wy
 * @date 2021/9/24 9:21
 */
public class Flatten430 {
    /**
     * 使用栈记录岔口的下一个元素
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        Deque<Node> stack = new ArrayDeque<Node>();
        Node p = head;
        while (p != null || !stack.isEmpty()) {
            if (p.child != null) {
                if (p.next != null) {
                    stack.push(p.next);
                }
                p.next=p.child;
                p.child.prev=p;
                p.child=null;
            }else {
                if(p.next==null&&!stack.isEmpty()){
                    Node q=stack.pop();
                    p.next=q;
                    q.prev=p;
                }
            }
            p=p.next;
        }
        return head;
    }

    /**
     * 深度优先搜索
     * @param head
     * @return
     */
    public Node flatten1(Node head){
         dfs(head);
         return head;
    }
    public Node dfs(Node node){
        Node cur=node;
        //记录链表的最后一个节点
        Node last=null;
        while(cur!=null){
            Node next=cur.next;
            //如果有子节点，那么首先处理子节点
            if(cur.child!=null){
                Node childLast=dfs(cur.child);
                next=cur.next;
                //将node与child相连
                cur.next=cur.child;
                cur.child.prev=cur;
                //如果next不为空，就将last与next相连
                if(next!=null){
                    childLast.next=next;
                    next.prev=childLast;
                }

                cur.child=null;
                last=childLast;
            }else {
                last=cur;
            }
            cur=next;
        }
        return last;
    }
}
