package medium;
//给定一个二叉树（具有根结点root），一个目标结点target，和一个整数值 K 。
//        返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。

import toolclass.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wy
 * @date 2021/7/28 9:12
 */
public class DistanceK863 {
    /*
     深度遍历，首先使用哈希表记录向上的搜索路径，然后从目标节点开始进行深度搜索
     */
    Map<Integer,TreeNode> parents=new HashMap<Integer, TreeNode>();
    List<Integer> ans=new ArrayList<Integer>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
      findParents(root);
      findAns(target,null,0,k);
      return ans;
    }
    public void findParents(TreeNode node){
        if(node.left!=null){
            parents.put(node.left.val,node);
            findParents(node.left);
        }
        if(node.right!=null){
            parents.put(node.right.val,node);
            findParents(node.right);
        }
    }
    public void findAns(TreeNode node,TreeNode from,int depth,int k){
        if(node==null){
            return;
        }
        if(depth==k){
            ans.add(node.val);
            return;
        }
        if(node.left!=from){
            findAns(node.left,node,depth+1,k);
        }
        if(node.right!=from){
            findAns(node.right,node,depth+1,k);
        }
        if(parents.get(node.val)!=from){
            findAns(parents.get(node.val),node,depth+1,k);
        }
    }
}
