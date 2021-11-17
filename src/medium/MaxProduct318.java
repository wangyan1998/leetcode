package medium;
//给定一个字符串数组words，找到length(word[i]) * length(word[j])的最大值，
//        并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。


import java.util.*;

/**
 * @author wy
 * @date 2021/11/17 9:12
 */
public class MaxProduct318 {
    /***
     * 两个任务，首先判断是否有共同字母，然后判断最大的长度乘积
     * @param words
     * @return
     */
    public int MaxProduct(String[] words){
       int res=0;
       for(int i=0;i<words.length-1;i++){
           for(int j=i+1;j<words.length;j++){
               if(!haveSame(words[i],words[j])){
                   res=Math.max(res,words[i].length()*words[j].length());
               }
           }
       }
       return res;
    }
    public boolean haveSame(String a,String b){
        Set<Character> set=new HashSet<Character>();
        for(int i=0;i<a.length();i++){
            set.add(a.charAt(i));
        }
        for(int i=0;i<b.length();i++){
            if(set.contains(b.charAt(i))){
                return true;
            }
        }
        return false;
    }

    /**
     * 把判断是否含有相同字母的方法用位运算实现。每个一个字母分别对应一个26位的码，如果包含该位的字母，则置位1.
     * 将不同word得到的码进行按位与，如果不存在相同字母这结果应该为0。
     * @param words
     * @return
     */
    public int maxProduct1(String[] words){
        int length=words.length;
        int[] masks=new int[length];
        for(int i=0;i<length;i++){
            String word=words[i];
            int wordLength=word.length();
            for(int j=0;j<wordLength;j++){
                masks[i]|=1<<(word.charAt(j)-'a');
            }
        }
        int maxProd=0;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if((masks[i]&masks[j])==0){
                    maxProd=Math.max(maxProd,words[i].length()*words[j].length());
                }
            }
        }
        return maxProd;
    }

    /**
     * 防止位掩码出现重复的情况，比如meet和met,位掩码就一样，但是只需要记录最长的那个就可以。
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            int mask = 0;
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                mask |= 1 << (word.charAt(j) - 'a');
            }
            if (wordLength > map.getOrDefault(mask, 0)) {
                map.put(mask, wordLength);
            }
        }
        int maxProd = 0;
        Set<Integer> maskSet = map.keySet();
        for (int mask1 : maskSet) {
            int wordLength1 = map.get(mask1);
            for (int mask2 : maskSet) {
                if ((mask1 & mask2) == 0) {
                    int wordLength2 = map.get(mask2);
                    maxProd = Math.max(maxProd, wordLength1 * wordLength2);
                }
            }
        }
        return maxProd;
    }
}


