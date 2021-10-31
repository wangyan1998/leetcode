package esay;

import toolclass.TreeNode;
//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值
/**
 * @author wy
 * @date 2021/4/13 8:53
 */
public class MinDiffInBST783 {
    int pre;
    int ans;

    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
