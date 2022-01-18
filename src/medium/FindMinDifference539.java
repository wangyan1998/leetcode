package medium;
//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author wy
 * @date 2022/1/18 9:12
 */
public class FindMinDifference539 {
    public int findMinDifference(List<String> timePoints){
       List<Integer> time=new ArrayList<Integer>();
        for(int i=0;i<timePoints.size();i++){
            time.add(getMin(timePoints.get(i)));
        }
        Collections.sort(time, new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t1-t2;
            }
        });
        int min=Integer.MAX_VALUE;
        for(int i=1;i<time.size();i++){
            min=Math.min(min,time.get(i)-time.get(i-1));
        }
        min=Math.min(time.get(0)+1400-time.get(time.size()-1),min);
        return min;
    }
    public int getMin(String s){
        int h=Integer.parseInt(s.substring(0,2));
        int m=Integer.parseInt(s.substring(3,5));
        return h*60+m;
    }
}
