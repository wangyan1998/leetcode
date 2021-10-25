package competition.test_2021_10_24;
//给你一棵根节点为 0 的 二叉树 ，它总共有 n 个节点，节点编号为 0 到 n - 1 。
//        同时给你一个下标从 0 开始的整数数组 parents 表示这棵树，其中 parents[i] 是节点 i 的父节点。
//        由于节点 0 是根，所以 parents[0] == -1 。
//        一个子树的 大小 为这个子树内节点的数目。每个节点都有一个与之关联的 分数 。求出某个节点分数的方法是，
//        将这个节点和与它相连的边全部 删除 ，剩余部分是若干个 非空 子树，这个节点的 分数 为所有这些子树 大小的乘积 。
//        请你返回有 最高得分 节点的 数目 。
import java.util.*;
/**
 * @author wy
 * @date 2021/10/24 11:26
 */
public class CountHighestScoreNodes {
    /**
     * 1.使用Map存储当前节点，以及它的子节点。
     * 2.利用DFS查询并存储当前节点下的节点个数。
     * 3.遍历计算各个节点删除后的得分情况(0号节点没有父节点)。
     * @param parents
     * @return
     */
    public int countHighestScoreNodes(int[] parents) {
        Map<Integer, List<Integer>> map = new HashMap();
        int[] count = new int[parents.length];
        for(int i = 1; i < parents.length; i++){
            List<Integer> list = new ArrayList(map.getOrDefault( parents[i], new ArrayList()));
            list.add(i);
            map.put(parents[i], list);
        }
        DFS(0, map, count);
        long scoreMax = Integer.MIN_VALUE;
        int nodes = 0;
        for(int i = 0; i < parents.length; i++){
            long score = 1;
            if(parents[i] == -1){
                List<Integer> list = new ArrayList( map.getOrDefault( i, new ArrayList() ) );
                for(int num : list)
                    score *= count[num];
            }else{
                score = count[0] - count[i];
                List<Integer> list = new ArrayList( map.getOrDefault( i, new ArrayList() ) );
                for(int num : list)
                    score *= count[num];
            }
            if(scoreMax < score){
                scoreMax = score;
                nodes = 1;
            }else if(score == scoreMax) ++nodes;
        }
        return nodes;
    }

    public void DFS(int index,  Map<Integer, List<Integer>> map, int[] count){
        List<Integer> list = new ArrayList( map.getOrDefault( index, new ArrayList() ) );
        if(list.size() == 0){
            count[index] = 1;
            return;
        }
        for(int num : list){
            DFS(num, map, count);
            count[index] += count[num];
        }
        ++count[index];
    }
}
