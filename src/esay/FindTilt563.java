package esay;
//给定一个二叉树，计算 整个树 的坡度 。
//        一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。
//        如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
//        整个树 的坡度就是其所有节点的坡度之和。


import toolclass.TreeNode;

/**
 * @author wy
 * @date 2021/11/18 9:08
 */
public class FindTilt563 {
    public int res=0;
    public int findTilt(TreeNode root){
        getSum(root);
        return res;
    }
    public int getSum(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=getSum(root.left);
        int right=getSum(root.right);
        res+=Math.abs(left-right);
        return left+right+ root.val;
    }
}
