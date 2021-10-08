package medium;
//所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。
//        在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
//        编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。


import java.util.*;

/**
 * @author wy
 * @date 2021/10/8 9:15
 */
public class FindRepeatedDnaSequences187 {
    /**
     * 哈希表统计，找到重复的子串
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s){
        int n=s.length();
        int left=0,right=10;
        List<String> res=new ArrayList<String>();
        Map<String,Integer> map=new HashMap<String, Integer>();
        while(right<=n){
            String subs=s.substring(left,right);
            map.put(subs,map.getOrDefault(subs,0)+1);
            right++;
            left++;
        }
        for(Map.Entry<String,Integer> entry:map.entrySet()){
              if(entry.getValue()>1){
                  res.add(entry.getKey());
              }
        }
        return res;
    }

    public List<String> findRepeatedDnaSequences1(String s){
        int n=s.length();
        int left=0,right=10;
        List<String> res=new ArrayList<String>();
        Map<String,Integer> map=new HashMap<String, Integer>();
        while(right<=n){
            String subs=s.substring(left,right);
            map.put(subs,map.getOrDefault(subs,0)+1);
            if(map.get(subs)==2){
                res.add(subs);
            }
            right++;
            left++;
        }
        return res;
    }
}
