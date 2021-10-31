package esay;
//给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
//        另外，我们在该矩阵中给出了一个坐标为(r0, c0) 的单元格。
//        返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，
//        其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。
//        （你可以按任何满足此条件的顺序返回答案。）


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AllCellsDistOrder1030 {
    public  int[][] allCellsDistOrder(int R,int C,int r0,int c0){
     int[][] res=new int[R*C][2];
     int c=0;
     for(int i=0;i<R;i++){
         for(int j=0;j<C;j++){
             res[c][0]=i;
             res[c][1]=j;
             c++;
         }
     }
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                return getdist(point1[0],point1[1],r0,c0)-getdist(point2[0],point2[1],r0,c0);
            }
        });
     return res;
    }
    public int getdist(int x1,int y1,int x2,int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
    public int[][] allCellsDistOrder1(int R,int C,int r0,int c0){//桶排序
        int maxDist=Math.max(r0,R-1-r0)+Math.max(c0,C-1-c0);
        List<List<int[]>> bucket=new ArrayList<List<int[]>>();
        for(int i=0;i<=maxDist;i++){
            bucket.add(new ArrayList<int[]>());
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                int d=getdist(i,j,r0,c0);
                bucket.get(d).add(new int[]{i,j});
            }
        }
        int[][] ret=new int[R*C][];
        int index=0;
        for(int i=0;i<maxDist;i++){
            for(int[] it:bucket.get(i)){
                ret[index++]=it;
            }
        }
        return ret;
    }

    int[] dr={1,1,-1,-1};
    int[] dc={1,-1,-1,1};
    public int[][] allCellsDistOrder2(int R, int C,int r0,int c0){//几何法，类似于广度优先遍历
        int maxDist=Math.max(r0,R-1-r0)+Math.max(c0,C-1-c0);
        int[][] ret=new int[R*C][];
        int row=r0,col=c0;
        int index=0;
        ret[index++]=new int[]{row,col};
        for(int dist=1;dist<=maxDist;dist++){
            row--;
            for(int i=0;i<4;i++){
                while ((i%2==0&&row!=r0)||(i%2!=0&&col!=c0)){
                    if(row>=0&&row<R&&col>=0&&col<C){
                        ret[index++]=new int[]{row,col};
                    }
                    row+=dr[i];
                    col+=dc[i];
                }
            }
        }
        return ret;
    }
}
