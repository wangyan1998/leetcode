package medium;
//你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和应该相等。
//        你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。
//        你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
//        给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。
//        你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量.

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wy
 * @date 2021/5/2 9:48
 */
public class LeastBricks554 {
    /**
     * 对于其穿过的砖块数量加上从边缘经过的砖块数量之和是一个定值，也就是砖墙的高度。
     * 所以结果=砖墙的高度-穿过边缘的最大值
     * 因为每行砖块的边缘不相同，因此可以使用哈希表统计所有符合要求的砖块边缘的数量。
     * 注意：最右侧边缘不应该被统计
     * @param wall
     * @return
     */
    public int leastBricks(List<List<Integer>> wall){
        Map<Integer,Integer> cnt=new HashMap<Integer, Integer>();
        for(List<Integer> widths:wall){
            int n=widths.size();
            int sum=0;
            for(int i=0;i<n-1;i++){
                sum+=widths.get(i);
                cnt.put(sum,cnt.getOrDefault(sum,0)+1);
            }
        }
        int maxCnt=0;
        for(Map.Entry<Integer,Integer> entry:cnt.entrySet()){
            maxCnt=Math.max(maxCnt,entry.getValue());
        }
        return wall.size()-maxCnt;
    }
}
