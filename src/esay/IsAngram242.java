package esay;
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

import java.util.Arrays;

public class IsAngram242 {
    public boolean isAngram(String s,String t){//基于统计实现
        int[] res1=new int[26];
        Arrays.fill(res1,0);
        int n=s.length();
        for(int i=0;i<n;i++){
            res1[s.charAt(i)-'a']++;
        }
        int[] res2=new int[26];
        Arrays.fill(res2,0);
        int m=t.length();
        for(int i=0;i<m;i++){
            res2[t.charAt(i)-'a']++;
        }
        boolean r=true;
        for(int i=0;i<26;i++){
            if(res1[i]!=res2[i]){
                r=false;
            }
        }
        return r;
    }

    /*
    基于排序实现，两个单词是异位词等价于两个字符串排序后相等
     */
    public boolean isAnagram1(String s,String t){
        if(s.length()!=t.length()){
            return  false;
        }
        char[] str1=s.toCharArray();
        char[] str2=t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1,str2);
    }

    /*
    基于统计的增减的算法，和第一种思路一样
     */
    public boolean isAnagram(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        int[] table=new int[26];
        for(int i=0;i<s.length();i++){
            table[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            table[t.charAt(i)-'a']--;
            if(table[t.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;
    }
}
