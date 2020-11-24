package medium;
//给出一个完全二叉树，求出该树的节点个数
import toolclass.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class CountNodes222 {
    public int countNodes(TreeNode root){//层次遍历
        if(root==null){
            return 0;
        }
        Queue<TreeNode> que=new ArrayDeque<TreeNode>();
        que.offer(root);
        TreeNode node;
        int count=0;
        while(que.isEmpty()!=true){
            node=que.poll();
            count++;
            if(node.left!=null){
                que.offer(node.left);
            }
            if(node.right!=null){
                que.offer(node.right);
            }
        }
        return count;
    }
    int count=0;
    public int countNodes1(TreeNode root){//递归算法
        count(root);
        return count;
    }
    public void count(TreeNode root){
        if(root==null){
            return;
        }else {
            count++;
        }
        count(root.left);
        count(root.right);
    }
}
