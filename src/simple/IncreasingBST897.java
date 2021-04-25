package simple;
//给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，
//        并且每个节点没有左子节点，只有一个右子节点。

import toolclass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2021/4/25 8:50
 */
public class IncreasingBST897 {
    List<Integer> res = new ArrayList<Integer>();
    private TreeNode resNode;

    public TreeNode increasingBST(TreeNode root) {
        mediumget(root);
        TreeNode re=new TreeNode(res.get(0));
        TreeNode h=re;
        for (int i = 1; i < res.size(); i++) {
            TreeNode node=new TreeNode(res.get(i));
            re.right=node;
            re=node;
        }
        return h;
    }

    public void mediumget(TreeNode root) {
        if (root == null) {
            return;
        }
        mediumget(root.left);
        res.add(root.val);
        mediumget(root.right);
    }

    /**
     * 在中序遍历中修改节点
     * @param root
     * @return
     */
    public TreeNode increasingBST1(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        inorder(root);
        return dummyNode.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);

        // 在中序遍历的过程中修改节点指向
        resNode.right = node;
        node.left = null;
        resNode = node;

        inorder(node.right);
    }
}
