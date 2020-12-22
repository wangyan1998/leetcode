package medium;

import toolclass.TreeNode;

import java.util.*;

public class ZigzagLevelOrder103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
       List<List<Integer>> ans=new ArrayList<List<Integer>>();
       if(root==null){
           return ans;
       }
       Queue<TreeNode> nodeQueue=new ArrayDeque<TreeNode>();
       nodeQueue.offer(root);
       boolean isOrderLeft=true;
       while (!nodeQueue.isEmpty()){
           Deque<Integer> levelList=new ArrayDeque<Integer>();
           int size=nodeQueue.size();
           for(int i=0;i<size;++i){
               TreeNode curNode=nodeQueue.poll();
               if(isOrderLeft){
                   levelList.offerLast(curNode.val);
               }else {
                   levelList.offerFirst(curNode.val);
               }
               if(curNode.left!=null){
                   nodeQueue.offer(curNode.left);
               }
               if(curNode.right!=null){
                   nodeQueue.offer(curNode.right);
               }
           }
           ans.add(new ArrayList<Integer>(levelList));
           isOrderLeft=!isOrderLeft;
       }
       return ans;
    }
}
