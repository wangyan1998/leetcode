package esay;
//给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
import toolclass.TreeNode;

/**
 * @author wy
 * @date 2021/11/26 9:09
 */
public class SearchBST700 {
    /**
     * 递归查找
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root,int val){
        if(root.val==val){
            return root;
        }
        if(root.val<val&&root.right!=null){
            return searchBST(root.right,val);
        }
        if(root.val>val&&root.left!=null){
            return searchBST(root.left,val);
        }
        return null;
    }
}
