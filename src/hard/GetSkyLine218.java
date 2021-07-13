package hard;
//城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回由这些建筑物形成的天际线 。
//        每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：
//        lefti 是第 i 座建筑物左边缘的 x 坐标。
//        righti 是第 i 座建筑物右边缘的 x 坐标。
//        heighti 是第 i 座建筑物的高度。
//        天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标进行排序。
//        关键点是水平线段的左端点。列表中最后一个点是最右侧建筑物的终点，y坐标始终为0 ，仅用于标记天际线的终点。
//        此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
//        注意：输出天际线中不得有连续的相同高度的水平线。
//        例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；
//             三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]


import java.util.*;

/**
 * @author wy
 * @date 2021/7/13 9:19
 */
public class GetSkyLine218 {
    public List<List<Integer>> getSkyLine(int[][] buildings){
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
        List<Integer> boundaries = new ArrayList<Integer>();
        for (int[] building : buildings) {
            boundaries.add(building[0]);
            boundaries.add(building[1]);
        }
        Collections.sort(boundaries);

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = buildings.length, idx = 0;
        for (int boundary : boundaries) {
            while (idx < n && buildings[idx][0] <= boundary) {
                pq.offer(new int[]{buildings[idx][1], buildings[idx][2]});
                idx++;
            }
            while (!pq.isEmpty() && pq.peek()[0] <= boundary) {
                pq.poll();
            }

            int maxn = pq.isEmpty() ? 0 : pq.peek()[1];
            if (ret.size() == 0 || maxn != ret.get(ret.size() - 1).get(1)) {
                ret.add(Arrays.asList(boundary, maxn));
            }
        }
        return ret;
    }
}
