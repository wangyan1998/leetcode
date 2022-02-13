package esay;
//给你一个字符串text，你需要使用 text 中的字母来拼凑尽可能多的单词"balloon"（气球）。
//        字符串text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词"balloon"。


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2022/2/13 11:12
 */
public class maxNumberOfBalloons1189 {
    public int maxNumberOfBalloons(String text){
        Map<Character,Integer> map=new HashMap<>();
        String s="balloon";
        for(int i=0;i<7;i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),0);
            }
        }
        for(int i=0;i<text.length();i++){
            Character c=text.charAt(i);
            if(c=='b'){
                map.put(c,map.getOrDefault(c,0)+1);
            }else if(c=='a'){
                map.put(c,map.getOrDefault(c,0)+1);
            }else if(c=='l'){
                map.put(c,map.getOrDefault(c,0)+1);
            }else if(c=='o'){
                map.put(c,map.getOrDefault(c,0)+1);
            }else if(c=='n'){
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        int res=text.length();
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getKey()=='l'||entry.getKey()=='o'){
                res=Math.min(res,entry.getValue()/2);
            }else {
                res=Math.min(res,entry.getValue());
            }
        }
        return res;
    }

    public int maxNumberOfBalloons1(String text) {
        int[] cnt = new int[5];
        for (int i = 0; i < text.length(); ++i) {
            char ch = text.charAt(i);
            if (ch == 'b') {
                cnt[0]++;
            } else if (ch == 'a') {
                cnt[1]++;
            } else if (ch == 'l') {
                cnt[2]++;
            } else if (ch == 'o') {
                cnt[3]++;
            } else if (ch == 'n') {
                cnt[4]++;
            }
        }
        cnt[2] /= 2;
        cnt[3] /= 2;
        return Arrays.stream(cnt).min().getAsInt();
    }
}
