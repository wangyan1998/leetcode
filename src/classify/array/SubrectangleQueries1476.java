package classify.array;
//请你实现一个类SubrectangleQueries，它的构造函数的参数是一个 rows x cols的矩形
//         （这里用整数矩阵表示），并支持以下两种操作：
//        1.updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
//          用newValue更新以(row1,col1)为左上角且以(row2,col2)为右下角的子矩形。
//        2.getValue(int row, int col)返回矩形中坐标 (row,col) 的当前值。

public class SubrectangleQueries1476 {
    private int[][] rectangle;
    public SubrectangleQueries1476(int[][] rectangle1) {
        rectangle=new int[rectangle1.length][rectangle1[0].length];
        for(int i=0;i<rectangle1.length;i++){
            for(int j=0;j<rectangle1[0].length;j++){
                rectangle[i][j]=rectangle1[i][j];
            }
        }
    }
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
      for(int i=row1;i<=row2;i++){
          for(int j=col1;j<=col2;j++){
              rectangle[i][j]=newValue;
          }
      }
    }
    public int getValue(int row, int col) {
         return rectangle[row][col];
    }
}
