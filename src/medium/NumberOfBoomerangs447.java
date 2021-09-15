package medium;
//给定平面上n 对 互不相同的点points ，其中 points[i] = [xi, yi] 。回旋镖 是由点(i, j, k) 表示的元组 ，
//        其中i和j之间的距离和i和k之间的距离相等（需要考虑元组的顺序）。
//        返回平面上所有回旋镖的数量。


import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/9/13 8:50
 */
public class NumberOfBoomerangs447 {
    public int numberOfBoomerangs(int[][] points){
        int ans=0;
        for(int[] p:points){
            Map<Integer,Integer> cnt=new HashMap<Integer, Integer>();
            for(int[] q:points){
                int dis=(p[0]-q[0])*(p[0]-q[0])+(p[1]-q[1])*(p[1]-q[1]);
                cnt.put(dis,cnt.getOrDefault(dis,0)+1);
            }
            for(Map.Entry<Integer,Integer> entry:cnt.entrySet()){
                int m=entry.getValue();
                ans+=m*(m-1);
            }
        }
        return ans;
    }
}
