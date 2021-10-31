package esay;
//给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
import toolclass.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wy
 * @date 2021/4/27 8:36
 */
public class RangeSumBST938 {
    private int sum;
    /**
     * 树的遍历
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST(TreeNode root,int low,int high){
        sum(root,low,high);
        return sum;
    }
    public void sum(TreeNode root,int low,int high){
        if(root==null){
            return;
        }
        if(root.val<=high&&root.val>=low) {
            sum += root.val;
        }
        sum(root.left,low,high);
        sum(root.right,low,high);
    }

    /**
     * 深度优先搜索
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST1(TreeNode root,int low,int high){
        if(root==null){
            return 0;
        }
        if(root.val>high){
            return rangeSumBST1(root.left,low,high);
        }
        if(root.val<low){
            return rangeSumBST1(root.right,low,high);
        }
        return root.val+rangeSumBST1(root.left,low,high)+rangeSumBST1(root.right,low,high);
    }

    /**
     * 广度优先搜索
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST2(TreeNode root,int low,int high){
        int sum=0;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                continue;
            }
            if(node.val>high){
                q.offer(node.left);
            }else if(node.val<low){
                q.offer(node.right);
            }else {
                sum+=node.val;
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sum;
    }
}
