package simple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr){
        Map<Integer,Integer> occur=new HashMap<Integer, Integer>();
        for(int x:arr){
            occur.put(x,occur.getOrDefault(x,0)+1);//如果map中有x，就得到x的value+1，如果没有，就是用默认值0+1
        }
        Set<Integer> times=new HashSet<Integer>();//Set不会出现重复元素
        for(Map.Entry<Integer,Integer> x:occur.entrySet()){
            times.add(x.getValue());
        }
        return times.size()==occur.size();
    }
}
