package esay;

import java.util.Arrays;

//给定两个字符串 s 和 t，它们只包含小写字母。
//        字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//        请找出在 t 中被添加的字母。
public class FindTheDifference389 {
    /*
    排序法
     */
    public char findTheDifference(String s,String t){
        char[] ss=s.toCharArray();
        char[] tt=t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        int i=0;
        for(;i<s.length();i++){
            if(ss[i]!=tt[i]){
                break;
            }
        }
        if(i<s.length()){
        return tt[i];
        }else {
            return tt[t.length() - 1];
        }
    }
    /*
    计数法
     */
    public char findTheDifference1(String s,String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }
    /*
    求和法
     */
    public char findTheDifference2(String s,String t){
        int as=0,at=0;
        for(int i=0;i<s.length();++i){
            as+=s.charAt(i);
        }
        for(int i=0;i<t.length();++i){
            at+=t.charAt(i);
        }
        return (char)(at-as);
    }
    /*
    位运算法：如果两个字符串拼接成一个字符串，则问题成为求字符串中出现次数为奇数的字符
     */
    public char findTheDifference3(String s,String t){
        int ret=0;
        for(int i=0;i<s.length();++i){
            ret^=s.charAt(i);
        }
        for(int i=0;i<t.length();++i){
            ret^=t.charAt(i);
        }
        return (char)ret;
    }
}
