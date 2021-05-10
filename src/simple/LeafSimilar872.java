package simple;
//请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
//        如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是叶相似。
//        如果给定的两个根结点分别为root1 和root2的树是叶相似的，则返回true；否则返回 false


import toolclass.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2021/5/10 9:09
 */
public class LeafSimilar872 {
    StringBuffer s=new StringBuffer();
    /**
     * 分别使用不同的结构存储每棵树的叶子，然后对比是否相同
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1,TreeNode root2){
        getleaf(root1);
        String s1=s.toString();
        s.delete(0,s.length());
        getleaf(root2);
        String s2=s.toString();
        if(s1.equals(s2)){
            return true;
        }else {
            return false;
        }
    }
    public void getleaf(TreeNode root){
        if(root.left==null&&root.right==null){
            s.append(root.val);
            s.append(',');
            return;
        }
        if(root.left!=null){
            getleaf(root.left);
        }
        if(root.right!=null){
            getleaf(root.right);
        }
    }

    public boolean leafSimilar1(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new ArrayList<Integer>();
        if (root1 != null) {
            dfs(root1, seq1);
        }

        List<Integer> seq2 = new ArrayList<Integer>();
        if (root2 != null) {
            dfs(root2, seq2);
        }

        return seq1.equals(seq2);
    }

    public void dfs(TreeNode node, List<Integer> seq) {
        if (node.left == null && node.right == null) {
            seq.add(node.val);
        } else {
            if (node.left != null) {
                dfs(node.left, seq);
            }
            if (node.right != null) {
                dfs(node.right, seq);
            }
        }
    }
}
