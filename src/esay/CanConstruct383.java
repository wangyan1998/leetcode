package esay;
//为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
//        给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符构成。
//        如果可以构成，返回 true ；否则返回 false 。
//        magazine 中的每个字符只能在 ransomNote 中使用一次。

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/12/4 10:16
 */
public class CanConstruct383 {
    public boolean canConstruct(String ransomNote,String magazine){
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            map.put(magazine.charAt(i),map.getOrDefault(magazine.charAt(i),0)+1);
        }
        for(int i=0;i<ransomNote.length();i++){
            char c=ransomNote.charAt(i);
            if(!map.containsKey(c)||map.get(c)==0){
                return false;
            }else {
                map.put(c, map.get(c)-1);
            }
        }
        return true;
    }
}
