package competition.test_2021_9_26;
//给你一个mxn的矩阵board，它代表一个填字游戏当前的状态。填字游戏格子中包含小写英文字母（已填入的单词），
//        表示空格的' '和表示障碍格子的'#'。
//        如果满足以下条件，那么我们可以水平（从左到右或者从右到左）或竖直（从上到下或者从下到上）填入一个单词：
//        (1)该单词不占据任何'#'对应的格子。
//        (2)每个字母对应的格子要么是' '（空格）要么与 board中已有字母 匹配。
//        (3)如果单词是 水平放置的，那么该单词左边和右边相邻格子不能为' '或小写英文字母。
//        (4)如果单词是竖直放置的，那么该单词上边和下边相邻格子不能为' '或小写英文字母。
//   给你一个字符串word，如果word可以被放入board中，请你返回true，否则请返回false。

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

/**
 * @author wy
 * @date 2021/9/26 17:18
 */
public class PlaceWordInCrossword {
    boolean found = false;

    enum Direction {
        TOP, BOTTOM, LEFT, RIGHT
    }

    public boolean placeWordInCrossword(char[][] board, String word) {
        found = false;
        int m = board.length + 2, n = board[0].length + 2;
        //添加边界
        char[][] nBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i * j == 0 || i == m - 1 || j == n - 1) {
                    nBoard[i][j] = '#';
                } else {
                    nBoard[i][j] = board[i - 1][j - 1];
                }
            }
        }
        board = nBoard;
        char[] chars = word.toCharArray();
        for (int row = 1; row < m && !found; row++) {
            for (int col = 1; col < n && !found; col++) {
                if (board[row][col] == ' ' || chars[0] == board[row][col] || chars[chars.length - 1] == board[row][col]) {
                    //单词正着方向探索放置
                    if (board[row][col] == ' ' || chars[0] == board[row][col]) {
                        //满足相邻格子不能为' '或者小写英文字母时探索
                        if (bound(board[row - 1][col])) {
                            dfs(board, row, col, Direction.BOTTOM, chars, 1, true);
                        }
                        if (bound(board[row + 1][col])) {
                            dfs(board, row, col, Direction.TOP, chars, 1, true);
                        }
                        if (bound(board[row][col - 1])) {
                            dfs(board, row, col, Direction.RIGHT, chars, 1, true);
                        }
                        if (bound(board[row][col + 1])) {
                            dfs(board, row, col, Direction.LEFT, chars, 1, true);
                        }
                    }
                    if(board[row][col]==' '||chars[chars.length-1]==board[row][col]){
                        if(bound(board[row-1][col])){
                            dfs(board,row,col,Direction.BOTTOM,chars,chars.length-2,false);
                        }
                        if(bound(board[row+1][col])){
                            dfs(board,row,col,Direction.TOP,chars,chars.length-2,false);
                        }
                        if (bound(board[row][col-1])){
                            dfs(board,row,col,Direction.RIGHT,chars,chars.length-2,false);
                        }
                        if(bound(board[row][col+1])){
                            dfs(board,row,col,Direction.LEFT,chars,chars.length-2,false);
                        }
                    }
                }
            }
        }
        return found;
    }

    /**
     * @param board
     * @param r         行索引
     * @param c         列索引
     * @param direction 放置方向
     * @param word      单词
     * @param point     当前放置到单词的索引位置
     * @param forword   单词放置方向
     */
    public void dfs(char[][] board, int r, int c, Direction direction, char[] word, int point, boolean forword) {
        int m = board.length, n = board[0].length;
        //下一个坐标的位置
        int row = r, col = c;
        switch (direction) {
            case TOP:
                row--;
                break;
            case BOTTOM:
                row++;
                break;
            case LEFT:
                col--;
                break;
            case RIGHT:
                col++;
                break;
        }
        if (found) {
            return;
        } else if (bound(board[row][col])) {//到达障碍物
            //单词已经全部放完
            if ((forword && point == word.length) || (!forword && point == -1)) {
                found = true;
            }
            return;
        } else {//未到达障碍物
            //单词已经全部放完
            if ((forword && point == word.length) || (!forword && point == -1)) {
                return;
            } else if (board[row][col] == ' ' || board[row][col] == word[point]) {//继续填单词
                dfs(board, row, col, direction, word, forword ? point + 1 : point - 1, forword);
            }
        }
    }

    /**
     * 是否为边界符号
     *
     * @param c
     * @return
     */
    public boolean bound(char c) {
        if (c == ' ' || ('a' <= c && c <= 'z')) {
            return false;
        } else {
            return true;
        }
    }
}
