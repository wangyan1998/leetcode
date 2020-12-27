package simple;
//给定两个字符串s和t，判断它们是否是同构的。
//        如果s中的字符可以被替换得到t，那么这两个字符串是同构的。
//        所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。
//        两个字符不能映射到同一个字符上，但字符可以映射自己本身。


import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic205 {
    //双哈希map,双向映射
    public boolean isIsomorphic(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Character> map1=new HashMap<Character, Character>();
        Map<Character,Character> map2=new HashMap<Character, Character>();
        for(int i=0;i<s.length();i++){
            char sc=s.charAt(i);
            char tc=t.charAt(i);
            char mc1=map1.getOrDefault(sc,' ');
            char mc2=map2.getOrDefault(tc,' ');
            if(mc1==' '&&mc2==' '){
                map1.put(sc,tc);
                map2.put(tc,sc);
            }else {
                if(mc1!=tc||mc2!=sc){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIsomorphic1(String s, String t) {
        char[] ss=s.toCharArray();
        char[] tt=t.toCharArray();
        for(int i=0;i<s.length();i++){
            if(s.indexOf(ss[i])!=t.indexOf(tt[i])){
                return false;
            }
        }
        return true;
    }
}
