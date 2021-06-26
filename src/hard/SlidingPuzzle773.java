package hard;
//在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用0来表示.
//        一次移动定义为选择0与一个相邻的数字（上下左右）进行交换.
//        最终当板board的结果是[[1,2,3],[4,5,0]]谜板被解开。
//        给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。

import java.util.*;

/**
 * @author wy
 * @date 2021/6/26 8:55
 */
public class SlidingPuzzle773 {
    /**
     * 广度优先搜索：将每一步的状态和步数记录下来，如果当前状态是目标状态，返回步数，如果不是继续搜索
     * 二维数组的存储有一定的困难，可以把二维数组按行的顺序排列成一个字符串，比如[[1,2,3][4,5,0]]可以写成“123450”
     * 我们可以给每一个位置编号为0,1,2,3,4,5，每一个位置的相邻位置的编号为：
     * 0号相邻位置有：1,3
     * 1号的相邻位置有：0,2,4
     * 2号的相邻位置有：1,5
     * 3号的相邻位置有：0,4
     * 4号的相邻位置有：1,3,5
     * 5号的相邻位置有：2,4
     * 执行一次操作，首先判断0所在的位置x，然后对于每一个与x相邻的位置y,将status[x]和status[y]互换。
     * 如果一开始就是目标状态，直接返回0.
     * @param board
     * @return
     */
        int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

        public int slidingPuzzle(int[][] board) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < 3; ++j) {
                    sb.append(board[i][j]);
                }
            }
            String initial = sb.toString();
            if ("123450".equals(initial)) {
                return 0;
            }

            int step = 0;
            Queue<String> queue = new LinkedList<String>();
            queue.offer(initial);
            Set<String> seen = new HashSet<String>();
            seen.add(initial);

            while (!queue.isEmpty()) {
                ++step;
                int size = queue.size();
                for (int i = 0; i < size; ++i) {
                    String status = queue.poll();
                    for (String nextStatus : get(status)) {
                        if (!seen.contains(nextStatus)) {
                            if ("123450".equals(nextStatus)) {
                                return step;
                            }
                            queue.offer(nextStatus);
                            seen.add(nextStatus);
                        }
                    }
                }
            }

            return -1;
        }

        // 枚举 status 通过一次交换操作得到的状态
        public List<String> get(String status) {
            List<String> ret = new ArrayList<String>();
            char[] array = status.toCharArray();
            int x = status.indexOf('0');
            for (int y : neighbors[x]) {
                swap(array, x, y);
                ret.add(new String(array));
                swap(array, x, y);
            }
            return ret;
        }

        public void swap(char[] array,int x,int y) {
            char temp = array[x];
            array[x] = array[y];
            array[y] = temp;
        }
}
