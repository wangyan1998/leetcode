package esay;

public class CheckStraightLine1232 {
    /**
     * 分3种情况：
     * （1）所有纵坐标都相同的时候
     * （2）所有横坐标相同
     * （3）在同一条斜线上
     * 使用斜率判断需要考虑除数为零的情况，把这种情况单独拿出来做一次判断
     * 另外两种情况合并通过斜率来判断
     * @param coordinates
     * @return
     */
    public boolean checkStraightLine(int[][] coordinates){
        int n=coordinates.length;
        if(n<3){
            return true;
        }
        boolean flag1=true;
        for(int i=1;i<n;i++){
            if(coordinates[i][1]!=coordinates[i-1][1]){
                flag1=false;
            }
        }
        boolean flag2=true;
        double x=(double) (coordinates[1][0]-coordinates[0][0])/(coordinates[1][1]-coordinates[0][1]);
        for(int i=1;i<n;i++){
            double y=(double)(coordinates[i][0]-coordinates[i-1][0])/(coordinates[i][1]-coordinates[i-1][1]);
            if(x!=y){
                flag2=false;
            }
        }
        return flag1||flag2;
    }

    /**
     * 数学公式法，首先通过前两个点求出公式Ax+By=0的参数A,B，然后将其他点带入，看是否都符合该点
     * @param coordinate
     * @return
     */
    public boolean checkStraightLine1(int[][] coordinate){
      int deltaX=coordinate[0][0],deltaY=coordinate[0][1];
      int n=coordinate.length;
      for(int i=0;i<n;i++){//使得该线是一条过原点的线
          coordinate[i][0]-=deltaX;
          coordinate[i][1]-=deltaY;
      }
      int A=coordinate[1][1],B=-coordinate[1][0];
      for(int i=2;i<n;i++){
          int x=coordinate[i][0],y=coordinate[i][1];
          if(A*x+B*y!=0){
              return false;
          }
      }
      return true;
    }
}
