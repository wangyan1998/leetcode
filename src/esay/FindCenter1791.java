package esay;
//有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，
//        并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。
//        给你一个二维整数数组 edges ，其中edges[i] = [ui, vi] 表示在节点 ui
//        和 vi 之间存在一条边。请你找出并返回edges 所表示星型图的中心节点。

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2022/2/18 13:39
 */
public class FindCenter1791 {
    /**
     * 哈希表统计
     * @param edges
     * @return
     */
    public int findCenter(int[][] edges){
       Map<Integer,Integer> map=new HashMap<Integer, Integer>();
       for(int[] edge:edges){
           map.put(edge[0],map.getOrDefault(edge[0],0)+1);
           map.put(edge[1],map.getOrDefault(edge[1],0)+1);
       }
       for(Map.Entry<Integer,Integer> entry:map.entrySet()){
           if(entry.getValue()==edges.length){
               return entry.getKey();
           }
       }
       return 0;
    }
    public int findCenter1(int[][] edges) {
        int n = edges.length + 1;
        int[] degrees = new int[n + 1];
        for (int[] edge : edges) {
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }
        for (int i = 1; ; i++) {
            if (degrees[i] == n - 1) {
                return i;
            }
        }
    }

    /**
     * 寻找出现在两条边中的节点
     * @param edges
     * @return
     */
    public int findCenter2(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
