package medium;
//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

import java.util.*;

/**
 * @author wy
 * @date 2021/7/3 9:25
 */
public class FrequencySort451 {
    /**
     * 先统计每个字符出现的次数，然后进行排序，组合成字符串
     * 尤其需要注意排序的方法。
     * @param s
     * @return
     */
    public String frequencySort(String s){
        int n=s.length();
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        for(int i=0;i<n;i++){
            Character c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Character> list = new ArrayList<Character>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuffer sb = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            char c = list.get(i);
            int frequency = map.get(c);
            for (int j = 0; j < frequency; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 桶排序：以出现次数为桶进行排序
     * （1）遍历字符串，统计每个字符出现的频率，同时记录最高频率 maxFreq；
     * （2）创建桶，存储从 1 到 maxFreq 的每个出现频率的字符；
     * （3）按照出现频率从大到小的顺序遍历桶，对于每个出现频率，获得对应的字符，然后将每个字符按照出现频率拼接到排序后的字符串。
     *
     * @param s
     * @return
     */
    public String frequencySort1(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxFreq = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
            maxFreq = Math.max(maxFreq, frequency);
        }
        StringBuffer[] buckets = new StringBuffer[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new StringBuffer();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].append(c);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = maxFreq; i > 0; i--) {
            StringBuffer bucket = buckets[i];
            int size = bucket.length();
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < i; k++) {
                    sb.append(bucket.charAt(j));
                }
            }
        }
        return sb.toString();
    }
}
