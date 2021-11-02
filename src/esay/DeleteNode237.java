package esay;
//请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点head ，只能直接访问 要被删除的节点 。
//        题目数据保证需要删除的节点 不是末尾节点 。


import toolclass.ListNode;

/**
 * @author wy
 * @date 2021/11/2 9:28
 */
public class DeleteNode237 {
    public void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
