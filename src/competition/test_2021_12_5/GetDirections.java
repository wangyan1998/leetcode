package competition.test_2021_12_5;
//给你一棵 二叉树 的根节点 root ，这棵二叉树总共有 n 个节点。每个节点的值为 1 到 n 中的一个整数，且互不相同。
//        给你一个整数 startValue ，表示起点节点 s 的值，和另一个不同的整数 destValue ，表示终点节点 t 的值。
//        请找到从节点 s 到节点 t 的 最短路径 ，并以字符串的形式返回每一步的方向。每一步用 大写 字母 'L' ，'R' 和 'U' 分别表示一种方向：
//        'L' 表示从一个节点前往它的 左孩子 节点。
//        'R' 表示从一个节点前往它的 右孩子 节点。
//        'U' 表示从一个节点前往它的 父 节点。
//        请你返回从 s 到 t 最短路径 每一步的方向。
import toolclass.TreeNode;

/**
 * @author wy
 * @date 2021/12/5 11:25
 */
public class GetDirections {
    String path = "";
    public String getDirections(TreeNode root, int startValue, int destValue) {
        dfs(root,startValue,new StringBuilder());
        String path1 = path;
        path = "";
        dfs(root,destValue,new StringBuilder());
        String path2 = path;

        char[] c1 = path1.toCharArray();
        char[] c2 = path2.toCharArray();
        int index = 0;

        // 找出公共路径
        while(index < c1.length && index < c2.length && c1[index] == c2[index]){
            index++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < c1.length-index; ++i){
            sb.append("U");
        }

        sb.append(path2.substring(index));

        return sb.toString();
    }

    // 找出根节点到目标节点的路径
    public boolean dfs(TreeNode root, int target, StringBuilder sb){

        if(root.val == target) {
            path = sb.toString();
            return true;
        }

        if(root.left != null){
            sb.append("L");
            if(dfs(root.left,target,sb)) return true;
            sb.deleteCharAt(sb.length()-1);
        }

        if(root.right != null){
            sb.append("R");
            if(dfs(root.right,target,sb)) return true;
            sb.deleteCharAt(sb.length()-1);
        }

        return false;
    }
}
