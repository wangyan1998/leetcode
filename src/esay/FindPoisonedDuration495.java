package esay;

import java.util.Map;

/**
 * @author wy
 * @date 2021/11/10 9:29
 */
public class FindPoisonedDuration495 {
    public int findPoisonedDuration(int[] timeSeries,int duration){
        int n=timeSeries.length;
        int res=0;
        int edge=0;
        for(int i=1;i<n;i++){
            edge= Math.min(timeSeries[i],timeSeries[i-1]+duration);
            res+=edge-timeSeries[i-1];
        }
        return res+duration;
    }
}
