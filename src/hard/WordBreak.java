package hard;
//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
//        说明：
//        分隔时可以重复使用字典中的单词。
//        你可以假设字典中没有重复的单词


import java.util.*;

public class WordBreak {
    public List<String> wordBreak(String s,List<String> wordDict){
        Map<Integer,List<List<String>>> map=new HashMap<Integer, List<List<String>>>();
        List<List<String>> wordBreaks=backtrack(s,s.length(),new HashSet<String>(wordDict),0,map);
        List<String> breakList =new LinkedList<String>();
        for(List<String> wordBreak:wordBreaks){
            breakList.add(String.join(" ",wordBreak));
        }
        return breakList;
    }
    public List<List<String>> backtrack(String s, int length, Set<String> wordSet,int index,Map<Integer,List<List<String>>> map){
        if(!map.containsKey(index)){
            List<List<String>> wordBreaks=new LinkedList<List<String>>();
            if(index==length){
                wordBreaks.add(new LinkedList<String>());
            }
            for(int i=index+1;i<=length;i++){
                String word=s.substring(index,i);
                if(wordSet.contains(word)){
                    List<List<String>> nextWordBreaks=backtrack(s,length,wordSet,i,map);
                    for(List<String> nextWordBreak:nextWordBreaks){
                        LinkedList<String> wordBreak=new LinkedList<String>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index,wordBreaks);
        }
        return map.get(index);
    }
}
