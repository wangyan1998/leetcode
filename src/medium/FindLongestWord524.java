package medium;
//给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
//        如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author wy
 * @date 2021/9/14 8:51
 */
public class FindLongestWord524 {
    /**
     * 先用List中的字符串进行匹配，如果匹配成功意味着该字符串可以由s进行删减得到
     * 然后找到List中符合条件的最长字典序最小的返回即可，否则返回“”。
     * @param s
     * @param dictionary
     * @return
     */
    public String findLongestWord(String s, List<String> dictionary){
        int n=dictionary.size();
        String ls="";
        int lpos=-1;
        for(int i=0;i<n;i++){
            String s1=dictionary.get(i);
            if(contain(s,s1)){
                if(s1.length()>ls.length()){
                    ls=s1;
                    lpos=i;
                }else if(s1.length()==ls.length()){
                    if(s1.compareTo(ls)<0){
                        ls=s1;
                        lpos=i;
                    }
                }
            }
        }
        if(lpos!=-1){
            return ls;
        }else {
            return "";
        }
    }
    public boolean contain(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int i=0,j=0;
        while(i<n&&j<m){
            char c=s2.charAt(j);
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }else {
                i++;
            }
        }
        if(j==m-1){
            return true;
        }else {
            return false;
        }
    }

    public String findLongestWord1(String s,List<String> dictionary){
        String res="";
        for(String t:dictionary){
            int i=0,j=0;
            while(i<t.length()&&j<s.length()){
                if(t.charAt(i)==s.charAt(j)){
                    ++i;
                }
                ++j;
            }
            if(i==t.length()){
                if(t.length()>res.length()||(t.length()==res.length()&&t.compareTo(res)<0)){
                    res=t;
                }
            }
        }
        return res;
    }
}
