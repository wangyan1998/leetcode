package medium;
//森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在answers数组里。
//        返回森林中兔子的最少数量。


import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/4/4 9:38
 */
public class NumRabbits781 {
    /**
     * 先统计不同回答的兔子有几类，对于每一类：如果有x只兔子回答y,
     * 则至少有（x/(y+1)）取下限种不同得颜色，且每种颜色有y+1只兔子，因此兔子数至少为：[x/(y+1)]取下限*(y+1)
     * @param answers
     * @return
     */
    public int numRabbits(int[] answers){
        int n=answers.length;
        if(n==0){
            return 0;
        }
        Map<Integer,Integer> num=new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++){
            num.put(answers[i],num.getOrDefault(answers[i],0)+1);
        }
        int res=0;
        for(Map.Entry<Integer,Integer> entry:num.entrySet()){
            int y = entry.getKey(), x = entry.getValue();
            res+= (x + y) / (y + 1) * (y + 1);
        }
        return res;
    }
}
