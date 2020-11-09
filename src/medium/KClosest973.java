package medium;
//我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
//        （这里，平面上两点之间的距离是欧几里德距离。）
//        你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosest973 {
    public int[][] kClosest(int[][] points,int k){
        int n=points.length;
        int[] dis=new int[n];
        int[][] res=new int[k][2];
        for(int i=0;i<n;i++){
            int x=points[i][0];
            int y=points[i][1];
           dis[i]=x*x+y*y;
        }
       for(int i=0;i<k;i++){
           int min=Integer.MAX_VALUE;
           int b=0;
           for(int j=0;j<n;j++){
               if(dis[j]<min){
                   b=j;
                   min=dis[j];
               }
           }
           res[i]=points[b];
           dis[b]=Integer.MAX_VALUE;
       }
       return res;
    }
    //将每个点到原点的欧几里得距离的平方从小到大排序后，取出前K个即可
    public int[][] kClosest1(int[][] points,int K){
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                return (point1[0]*point1[0]+point1[1]*point1[1])-(point2[0]*point2[0]+point2[1]*point2[1]);
            }
        });
        return Arrays.copyOfRange(points,0,K);
    }
    //优先队列的使用
    public int[][] kClosest2(int[][] points,int k){
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] array1, int[] array2) {
                return array2[0]-array1[0];
            }
        });
        for(int i=0;i<k;i++){
            pq.offer(new int[]{points[i][0]*points[i][0]+points[i][1]*points[i][1],i});
        }
        int n=points.length;
        for(int i=k;i<n;i++){
            int dist=points[i][0]*points[i][0]+points[i][1]*points[i][1];
            if(dist<pq.peek()[0]){
                pq.poll();
                pq.offer(new int[]{dist,i});
            }
        }
        int[][] ans=new int[k][2];
        for(int i=0;i<k;i++){
            ans[i]=points[pq.poll()[1]];
        }
        return ans;
    }
}
