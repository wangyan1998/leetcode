package hard;
//在大小为 n x n 的网格 grid 上，每个单元格都有一盏灯，最初灯都处于 关闭 状态。
//        给你一个由灯的位置组成的二维数组lamps ，其中 lamps[i] = [rowi, coli]
//        表示打开位于 grid[rowi][coli]的灯。即便同一盏灯可能在 lamps 中多次列出，
//        不会影响这盏灯处于打开状态。
//        当一盏灯处于打开状态，它将会照亮 自身所在单元格 以及同一 行 、同一 列 和两条
//        对角线 上的 所有其他单元格 。
//        另给你一个二维数组 queries ，其中 queries[j] = [rowj, colj] 。对于第 j
//        个查询，如果单元格 [rowj, colj] 是被照亮的，则查询结果为 1 ，否则为 0 。
//        在第 j 次查询之后 [按照查询的顺序] ，关闭 位于单元格 grid[rowj][colj] 上
//        及相邻 8 个方向上（与单元格 grid[rowi][coli] 共享角或边）的任何灯。
//        返回一个整数数组 ans 作为答案， ans[j] 应等于第 j 次查询queries[j]的结果，
//        1 表示照亮，0 表示未照亮。


import java.util.*;

/**
 * @author wy
 * @date 2022/2/8 9:25
 */
public class GridIllumination1001 {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> row = new HashMap<Integer, Integer>();
        Map<Integer, Integer> col = new HashMap<Integer, Integer>();
        Map<Integer, Integer> diagonal = new HashMap<Integer, Integer>();
        Map<Integer, Integer> antiDiagonal = new HashMap<Integer, Integer>();
        Set<Long> points = new HashSet<Long>();
        for (int[] lamp : lamps) {
            if (!points.add(hash(lamp[0], lamp[1]))) {
                continue;
            }
            row.put(lamp[0], row.getOrDefault(lamp[0], 0) + 1);
            col.put(lamp[1], col.getOrDefault(lamp[1], 0) + 1);
            diagonal.put(lamp[0] - lamp[1], diagonal.getOrDefault(lamp[0] - lamp[1], 0) + 1);
            antiDiagonal.put(lamp[0] + lamp[1], antiDiagonal.getOrDefault(lamp[0] + lamp[1], 0) + 1);
        }
        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int r = queries[i][0], c = queries[i][1];
            if (row.getOrDefault(r, 0) > 0) {
                ret[i] = 1;
            } else if (col.getOrDefault(c, 0) > 0) {
                ret[i] = 1;
            } else if (diagonal.getOrDefault(r - c, 0) > 0) {
                ret[i] = 1;
            } else if (antiDiagonal.getOrDefault(r + c, 0) > 0) {
                ret[i] = 1;
            }
            for (int x = r - 1; x <= r + 1; x++) {
                for (int y = c - 1; y <= c + 1; y++) {
                    if (x < 0 || y < 0 || x >= n || y >= n) {
                        continue;
                    }
                    if (points.remove(hash(x, y))) {
                        row.put(x, row.get(x) - 1);
                        if (row.get(x) == 0) {
                            row.remove(x);
                        }
                        col.put(y, col.get(y) - 1);
                        if (col.get(y) == 0) {
                            col.remove(y);
                        }
                        diagonal.put(x - y, diagonal.get(x - y) - 1);
                        if (diagonal.get(x - y) == 0) {
                            diagonal.remove(x - y);
                        }
                        antiDiagonal.put(x + y, antiDiagonal.get(x + y) - 1);
                        if (antiDiagonal.get(x + y) == 0) {
                            antiDiagonal.remove(x + y);
                        }
                    }
                }
            }
        }
        return ret;
    }

    public long hash(int x, int y) {
        return (long) x + ((long) y << 32);
    }
}
