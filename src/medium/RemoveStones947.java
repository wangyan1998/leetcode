package medium;
//n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
//        如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
//        给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，
//        返回 可以移除的石子 的最大数量。

import java.util.*;

public class RemoveStones947 {
    /**
     * 并查集问题，任何节点横坐标或者纵坐标存在相同的都属于同一连通分量
     * 找到连通分量个数，每个连通分量留一个节点就可以了
     * 因为0<=x<=10000,为了区分横纵坐标，将横坐标加10001
     * @param stones
     * @return
     */
    public int removeStones(int[][] stones){
        UnionFind unionFind = new UnionFind();
        for (int[] stone : stones) {
            unionFind.union(stone[0] + 10001, stone[1]);
        }
        return stones.length - unionFind.getCount();
    }

    private class UnionFind {

        private Map<Integer, Integer> parent;
        private int count;//连通分量数

        public UnionFind() {
            this.parent = new HashMap<>();
            this.count = 0;
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {//如果Map中不存在该元素，新开一个连通分量
                parent.put(x, x);
                count++;
            }

            if (x != parent.get(x)) {//如果x不是最顶端的节点
                parent.put(x, find(parent.get(x)));//找到最顶端的节点，把x合并进最顶端的节点
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {//如果x与y在同一个连通分量里，不做任何事
                return;
            }
            parent.put(rootX, rootY);//否则，合并两个连通分量，连通分量数减一
            count--;
        }
    }
}
