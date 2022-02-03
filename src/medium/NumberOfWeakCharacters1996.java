package medium;
//你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，
//        其中 properties[i] = [attack_i, defense_i] 表示游戏中第 i 个角色的属性。
//        如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为弱角色。
//        更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attack_j > attack_i
//        且 defense_j > defense_i 。
//        返回 弱角色 的数量。


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author wy
 * @date 2022/1/28 9:41
 */
public class NumberOfWeakCharacters1996 {
    public int numberOfWeakCharacters(int[][] properties) {
       Arrays.sort(properties,(o1, o2) -> {
           return o1[0]==o2[0]?(o1[1]-o2[1]):(o2[0]-o1[0]);
       });
       int maxDef=0;
       int ans=0;
       for(int[] p: properties){
           if(p[1]<maxDef){
               ans++;
           }else {
               maxDef=p[1];
           }
       }
       return ans;
    }
}
