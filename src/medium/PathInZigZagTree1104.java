package medium;
//在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按“之” 字形进行标记。
//        在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
//        而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记
//        给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wy
 * @date 2021/7/29 9:31
 */
public class PathInZigZagTree1104 {
    /**
     *正常树某个节点的父节点是label/2。这种树的父节点总是出现在其对称位置。
     * 可以观察到，对称位置label = 上一层的最大值 + 上一层的最小值 - 正常的label位置
     * @param label
     * @return
     */
    public List<Integer> pathInZigZagTree(int label){
        List<Integer> ans = new LinkedList<>();
        ans.add(label);
        int pow = (int) (Math.log(label) / Math.log(2));
        while(pow > 0) {
            label = (1 << (pow - 1)) + ((1 << pow) - 1) - (label >> 1);
            pow = (int) (Math.log(label) / Math.log(2));
            ans.add(0, label);
        }
        return ans;
    }
}
