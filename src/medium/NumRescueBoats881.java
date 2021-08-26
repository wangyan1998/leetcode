package medium;
//第i个人的体重为people[i]，每艘船可以承载的最大重量为limit。
//        每艘船最多可同时载两人，但条件是这些人的重量之和最多为limit。
//        返回载到每一个人所需的最小船数。(保证每个人都能被船载)。

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/8/26 9:38
 */
public class NumRescueBoats881 {
    /**
     * 贪心算法
     * @param people
     * @param limit
     * @return
     */
    public int numRescueBoats(int[] people,int limit){
        int ans=0;
        Arrays.sort(people);
        int light=0,heavy=people.length-1;
        while(light<=heavy){
            if(people[light]+people[heavy]<=limit){
                light++;
            }
            --heavy;
            ans++;
        }
        return ans;
    }
}
