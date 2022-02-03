package esay;
//句子是一串由空格分隔的单词。每个单词仅由小写字母组成。
//        如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，
//        那么这个单词就是不常见的。
//        给你两个句子s1和s2 ，返回所有不常用单词的列表。返回列表中单词可以按任意顺序组织。


import java.util.*;

/**
 * @author wy
 * @date 2022/1/30 16:36
 */
public class UncommonFromSentences {
    public String[] uncommonFromSentences(String s1,String s2){
        String[] arr1=s1.split("\\s+");
        String[] arr2=s2.split("\\s+");
        Set<String> set=new HashSet<String>();
        Map<String,Integer> map=new HashMap<String,Integer>();
        for(int i=0;i<arr1.length;i++){
            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
        }
        for(int i=0;i<arr2.length;i++){
            map.put(arr2[i],map.getOrDefault(arr2[i],0)+1);
        }
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            if(entry.getValue()==1){
                set.add(entry.getKey());
            }
        }
        return set.toArray(new String[set.size()]);
    }

    /**
     * 答案做法，思路一样
     * @param s1
     * @param s2
     * @return
     */
    public String[] uncommonFromSentences1(String s1, String s2) {
        Map<String, Integer> freq = new HashMap<String, Integer>();
        insert(s1, freq);
        insert(s2, freq);

        List<String> ans = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                ans.add(entry.getKey());
            }
        }
        return ans.toArray(new String[0]);
    }

    public void insert(String s, Map<String, Integer> freq) {
        String[] arr = s.split(" ");
        for (String word : arr) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
    }
}
