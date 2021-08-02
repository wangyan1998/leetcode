package medium;
//有 n 个网络节点，标记为1到 n。
//        给你一个列表times，表示信号经过有向边的传递时间。times[i] = (ui, vi, wi)，
//        其中ui是源节点，vi是目标节点， wi是一个信号从源节点传递到目标节点的时间。
//        现在，从某个节点K发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回-1 。

import java.util.*;

/**
 * @author wy
 * @date 2021/8/2 9:27
 */
public class NetworkDelayTime743 {
    Map<Integer, Map<Integer, Integer>> connect;

    /**
     * BFS，按最小的时间依次BFS搜索整个图即可。
     * @param times
     * @param n
     * @param k
     * @return
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        connect = new HashMap<>();
        for(int i=0;i<times.length;i++){
            int u = times[i][0], v = times[i][1], w = times[i][2];
            Map cur = connect.getOrDefault(u, new HashMap<>());
            cur.put(v, w);
            connect.put(u, cur);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        q.add(new int[]{0, k});
        Set<Integer> explored = new HashSet<>();
        while(q.size() > 0){
            int[] cur = q.poll();
            int t = cur[0], node = cur[1];
            if(explored.contains(node))
                continue;
            explored.add(node);
            if(explored.size() == n)
                return t;
            if(connect.containsKey(node)){
                for(int other: connect.get(node).keySet()){
                    if(!explored.contains(other)){
                        int tm = connect.get(node).get(other);
                        q.add(new int[]{t+tm, other});
                    }
                }
            }
        }
        return -1;
    }
}
