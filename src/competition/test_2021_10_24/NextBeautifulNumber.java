package competition.test_2021_10_24;
//如果整数  x 满足：对于每个数位 d ，这个数位恰好在x中出现d次。那么整数x就是一个数值平衡数 。
//        给你一个整数 n ，请你返回严格大于n的最小数值平衡数 。

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/10/24 11:09
 */
public class NextBeautifulNumber {
    public int nextBeautifulNumber(int n) {
        int i=n+1;
        for(;i<1224444;i++){
            if(validNum(i)==true){
                break;
            }
        }
        return i;
    }
    public boolean validNum(int n){
        Map<Character,Integer> map=new HashMap<>();
        String s=Integer.toString(n);
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            if((entry.getKey()-'0')!=entry.getValue()){
               return false;
            }
        }
        return true;
    }
}
