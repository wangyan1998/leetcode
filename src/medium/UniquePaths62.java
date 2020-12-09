package medium;
//一个机器人位于一个 m x n 网格的左上角 （起始点标记为“Start” ）。
//        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（标记为“Finish”）。
//        问总共有多少条不同的路径？

public class UniquePaths62 {
    /*
    典型的动态规划：如果要求到达（i,j）的路径，需要先知道到达(i-1,j)和(i,j-1)的路径数，然后将这两个路径求和
     */
    public int uniquePaths(int m,int n){
     int[][] re=new int[n][m];
     for(int i=0;i<m;i++){
         re[0][i]=1;
     }
     for(int j=1;j<n;j++){
         re[j][0]=1;
     }
     for(int i=1;i<n;i++){
         for(int j=1;j<m;j++){
             re[i][j]=re[i-1][j]+re[i][j-1];
         }
     }
     return re[n-1][m-1];
    }
}
