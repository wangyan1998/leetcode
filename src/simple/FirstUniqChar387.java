package simple;
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar387 {
    public int firstUniqChar(String s){
        int[] num=new int[26];
        for(int i=0;i<s.length();i++){
            num[s.charAt(i)-'a']++;
        }
        int res=0;
        for(;res<s.length();res++){
            if(num[s.charAt(res)-'a']==1){
                return res;
            }
        }
        return -1;
    }

    /**
    哈希表存储频次
     */
    public int firstUniqChar1(String s){
        Map<Character,Integer> frequency=new HashMap<Character, Integer>();
        for(int i=0;i<s.length();++i){
            char ch=s.charAt(i);
            frequency.put(ch,frequency.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<s.length();++i){
            if(frequency.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
