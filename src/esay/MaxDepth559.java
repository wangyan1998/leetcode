package esay;

import toolclass.NTreeNode;

/**
 * @author wy
 * @date 2021/11/21 9:32
 */
public class MaxDepth559 {
    public int maxDepth(NTreeNode root){
        if(root==null){
            return 0;
        }
        return 1+dfs(root);
    }
    public int dfs(NTreeNode root){
        if(root==null){
            return 0;
        }
        int max=0;
        for(NTreeNode node:root.children){
            max=Math.max(max,1+dfs(node));
        }
        return max;
    }
}
