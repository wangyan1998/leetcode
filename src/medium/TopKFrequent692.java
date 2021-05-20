package medium;
//给一非空的单词列表，返回前 k 个出现次数最多的单词。
//        返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。

import java.util.*;

/**
 * @author wy
 * @date 2021/5/20 8:59
 */
public class TopKFrequent692 {
    /**
     * 哈希表+排序
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> res = new ArrayList<String>();
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            res.add(entry.getKey());
        }
        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String w1, String w2) {
                return map.get(w1)==map.get(w2)?w1.compareTo(w2):map.get(w2)-map.get(w1);
            }
        });
        return res.subList(0,k);
    }

    /**
     * 优先队列
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent1(String[] words,int k){
        Map<String,Integer> map=new HashMap<String,Integer>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq=new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry1.getValue()== entry2.getValue()?entry2.getKey().compareTo(entry1.getKey()):entry1.getValue()-entry2.getValue();
            }
        });
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            pq.offer(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<String> ret=new ArrayList<String>();
        while(!pq.isEmpty()){
            ret.add(pq.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }
}
