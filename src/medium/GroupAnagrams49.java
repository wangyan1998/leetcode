package medium;
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
import java.util.*;

public class GroupAnagrams49 {
    //排序
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map=new HashMap<String, List<String>>();
        for(String str:strs){
            char[] array=str.toCharArray();
            Arrays.sort(array);
            String key=new String(array);
            List<String> list=map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
    //计数法，因为字母异位词的两个字符串包含的字母相同，因此两个字符串中的相同的字母出现的次数一定是相同的，所以可以将每个
    //字母出现的次数使用字符串表示，作为哈希表的键。
    public List<List<String>> groupAnagrams1(String[] strs){
        Map<String,List<String>> map=new HashMap<String,List<String>>();
        for(String str:strs){
            int[] counts=new int[26];
            int length=str.length();
            for(int i=0;i<length;i++){
                counts[str.charAt(i)-'a']++;
            }
            //将每个出现次数大于0的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<26;i++){
                if(counts[i]!=0){
                    sb.append((char)('a'+i));
                    sb.append(counts[i]);
                }
            }
            String key=sb.toString();
            List<String> list=map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
