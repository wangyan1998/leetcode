package medium;
//请你判断一个9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
//        数字1-9在每一行只能出现一次。
//        数字1-9在每一列只能出现一次。
//        数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
//        数独部分空格内已填入了数字，空白格用'.'表示。
//        注意：
//        一个有效的数独（部分已被填充）不一定是可解的。
//        只需要根据以上规则，验证已经填入的数字是否有效即可。


import java.util.HashSet;
import java.util.Set;

/**
 * @author wy
 * @date 2021/9/17 8:43
 */
public class IsValidSudoku36 {
    /**
     * 暴力方法
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        Set<Character> vis = new HashSet<Character>();
        Set<Character> vis1 = new HashSet<Character>();
        for (int i = 0; i < 9; i++) {
            vis.clear();
            vis1.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (vis.contains(board[i][j])) {
                        return false;
                    } else {
                        vis.add(board[i][j]);
                    }
                }
            }
            for (int k = 0; k < 9; k++) {
                if (board[k][i] != '.') {
                    if (vis1.contains(board[k][i])) {
                        return false;
                    } else {
                        vis1.add(board[k][i]);
                    }
                }
            }
        }
        int[][] pos = {{0, 0}, {0, 3}, {0, 6}, {3, 0}, {3, 3}, {3, 6}, {6, 0}, {6, 3}, {6, 6}};
        for (int[] p : pos) {
            vis.clear();
            for (int i = p[0]; i < p[0]+3; i++) {
                for (int j = p[1]; j < p[1]+3; j++) {
                    if (board[i][j] != '.') {
                        if (vis.contains(board[i][j])) {
                            return false;
                        } else {
                            vis.add(board[i][j]);
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * 一次遍历
     * @param board
     * @return
     */
    public boolean isValidSudoku1(char[][] board){
        int[][] rows=new int[9][9];
        int[][] columns=new int[9][9];
        int[][][] subboxes=new int[3][3][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c=board[i][j];
                if(c!='.'){
                    int index=c-'0'-1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i/3][j/3][index]++;
                    if(rows[i][index]>1||columns[j][index]>1||subboxes[i/3][j/3][index]>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
