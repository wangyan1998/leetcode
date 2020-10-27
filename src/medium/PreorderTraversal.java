package medium;

import toolclass.ListNode;
import toolclass.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
    public List<Integer> preorderTraversal1(TreeNode root){//迭代的方式
        List<Integer> res=new ArrayList<Integer>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> stack=new LinkedList<TreeNode>();
        TreeNode node=root;
        while(!stack.isEmpty()||node!=null){
            while (node!=null){
                res.add(node.val);
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();
            node=node.right;
        }
        return res;
    }
}
