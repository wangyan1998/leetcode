package simple;
//给你一个大小为m* n的矩阵mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
//        请你返回矩阵中战斗力最弱的k行的索引，按从最弱到最强排序。
//        如果第i行的军人数量少于第j行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
//        军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。

import java.util.*;
import java.util.Comparator;

/**
 * @author wy
 * @date 2021/8/1 9:40
 */
public class KWeakestRows1337 {
    /**
     * 统计每行对应的军人数目，然后按排序取出前k行
     * @param mat
     * @param k
     * @return
     */
    public int[] kWeakestRows(int[][] mat,int k){
        int n=mat.length;
        int m=mat[0].length;
        int[][] map=new int[n][2];
        for(int i=0;i<n;i++){
            int num=0;
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    num++;
                }else {
                    break;
                }
            }
            map[i][0]=i;
            map[i][1]=num;
        }
        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1]){
                    return o1[1]-o2[1];
                }else {
                    return o1[0]-o2[0];
                }
            }
        });
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=map[i][0];
        }
        return res;
    }

    /**
     * 思想和上一个方法一样，但是在统计军人数目时利用了军人在前的条件，使用二分法快速查找最后一个1的位置
     * 然后利用小根堆的思想获得前k个
     * @param mat
     * @param k
     * @return
     */
    public int[] kWeakestRows1(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        List<int[]> power = new ArrayList<int[]>();
        for (int i = 0; i < m; ++i) {
            int l = 0, r = n - 1, pos = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (mat[i][mid] == 0) {
                    r = mid - 1;
                } else {
                    pos = mid;
                    l = mid + 1;
                }
            }
            power.add(new int[]{pos + 1, i});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                if (pair1[0] != pair2[0]) {
                    return pair1[0] - pair2[0];
                } else {
                    return pair1[1] - pair2[1];
                }
            }
        });
        for (int[] pair : power) {
            pq.offer(pair);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = pq.poll()[1];
        }
        return ans;
    }
}
