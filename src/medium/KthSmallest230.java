package medium;
//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
import toolclass.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wy
 * @date 2021/10/17 9:36
 */
public class KthSmallest230 {
    /**
     * 二叉搜索树的中序遍历
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root,int k){
        Deque<TreeNode> stack=new ArrayDeque<TreeNode>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            --k;
            if(k==0){
                break;
            }
            root=root.right;
        }
        return root.val;
    }
}
